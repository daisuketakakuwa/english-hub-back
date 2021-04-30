package jp.english.hub.englishhubback.domain.card;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CardSpecifications {

    public Specification<CardEntity> equalsTag(String tag) {
        return StringUtils.isBlank(tag) ? null : (root, query, builder) -> builder.equal(root.get("tag"), tag);
    }

    public Specification<CardEntity> containsTitle(String word) {
        return StringUtils.isBlank(word) ? null
                : (root, query, builder) -> builder.like(root.get("title"), "%" + word + "%");
    }

    public Specification<CardEntity> containsContent(String word) {
        return StringUtils.isBlank(word) ? null
                : (root, query, builder) -> builder.like(root.get("content"), "%" + word + "%");
    }

}
