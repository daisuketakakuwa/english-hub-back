package jp.english.hub.englishhubback.domain.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.english.hub.englishhubback.domain.card.request.CardRegistReqeust;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PutMapping("/register")
    public void registerCard(@RequestBody CardRegistReqeust req) {
        cardService.saveCard(req.getTitle(), req.getTag(), req.getContent());
    }

}
