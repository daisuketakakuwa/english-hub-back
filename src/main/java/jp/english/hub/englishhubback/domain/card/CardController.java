package jp.english.hub.englishhubback.domain.card;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.english.hub.englishhubback.domain.card.request.CardRequest;
import jp.english.hub.englishhubback.domain.card.response.CardResponse;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private ProductFactory productFactory;

    @PutMapping("/register")
    public void registerCard(@RequestBody CardRequest req) {
        cardService.saveCard(UUID.randomUUID().toString(), req.getTitle(), req.getTag(), req.getContent());
    }

    @PutMapping("/update")
    public void updateCard(@RequestBody CardRequest req) {
        cardService.updateCard(req.getId(), req.getTitle(), req.getContent());
    }

    @GetMapping("/search")
    public List<CardResponse> searchCard(@RequestParam String tag, @RequestParam String word) {
        return productFactory.createCardResponses(cardService.searchCards(tag, word));
    }

    @GetMapping("/delete")
    public void deleteCard(@RequestParam String id) {
        cardService.deleteCard(id);
    }

    @GetMapping("/tags")
    public List<String> getTags() {
        return cardService.getTags();
    }

}
