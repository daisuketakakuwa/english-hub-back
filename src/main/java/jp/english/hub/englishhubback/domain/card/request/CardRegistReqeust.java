package jp.english.hub.englishhubback.domain.card.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardRegistReqeust {
    private String title;
    private String tag;
    private String content;
}
