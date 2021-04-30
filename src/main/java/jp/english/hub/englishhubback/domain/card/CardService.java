package jp.english.hub.englishhubback.domain.card;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;
    @Autowired
    CardSpecifications specs;

    public void saveCard(String title, String tag, String content) {
        CardEntity entity = new CardEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setTitle(title);
        entity.setTag(tag);
        entity.setContent(content);
        cardRepository.save(entity);
    }

    public List<CardEntity> searchCards(String tag, String word) {
        return cardRepository.findAll(Specification.where(specs.equalsTag(tag)).or(specs.containsTitle(word))
                .or(specs.containsContent(word)));
    }

    public List<String> getTags() {
        return cardRepository.findAll().stream().map(CardEntity::getTag).collect(Collectors.toList());
    }

}
