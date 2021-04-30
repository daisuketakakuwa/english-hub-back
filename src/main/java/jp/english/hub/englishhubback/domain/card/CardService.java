package jp.english.hub.englishhubback.domain.card;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public void saveCard(String title, String tag, String content) {
        CardEntity entity = new CardEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setTitle(title);
        entity.setTag(tag);
        entity.setContent(content);
        cardRepository.save(entity);
    }

}
