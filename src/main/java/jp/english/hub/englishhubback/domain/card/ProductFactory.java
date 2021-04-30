package jp.english.hub.englishhubback.domain.card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.english.hub.englishhubback.domain.card.response.CardResponse;
import jp.english.hub.englishhubback.domain.infra.ResponseFactory;

@Component
public class ProductFactory {

    @Autowired
    ResponseFactory responseFactory;

    public List<CardResponse> createCardResponses(List<CardEntity> entities) {
        return responseFactory.map(entities, CardResponse.class);
    }

}
