package jp.english.hub.englishhubback.domain.card.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {

    private String id;
    private String tag;
    private String title;
    @JsonIgnore
    private String content;

    @JsonProperty
    public String getContent() {
        return this.content.replace("\n", "<br>");
    }

}
