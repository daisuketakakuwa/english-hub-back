package jp.english.hub.englishhubback.domain.card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.english.hub.englishhubback.domain.card.request.CardRegistRequest;
import jp.english.hub.englishhubback.domain.card.response.CardResponse;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private ProductFactory productFactory;

    @PutMapping("/register")
    public void registerCard(@RequestBody CardRegistRequest req) {
        cardService.saveCard(req.getTitle(), req.getTag(), req.getContent());
    }

    @GetMapping("/search")
    public List<CardResponse> searchCard(@RequestParam String tag, @RequestParam String word) {
        return productFactory.createCardResponses(cardService.searchCards(tag, word));
    }

    @GetMapping("/tags")
    public List<String> getTags() {
        return cardService.getTags();
    }

}
