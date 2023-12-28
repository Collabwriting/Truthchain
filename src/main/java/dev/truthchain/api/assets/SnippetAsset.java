package dev.truthchain.api.assets;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.truthchain.api.entities.Snippet;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SnippetAsset {

    @JsonProperty("@context")
    public String context = "https://schema.org";

    @JsonProperty("@type")
    public String type = "TruthchainSnippet";

    @JsonProperty("@id")
    public String id;

    @JsonProperty("content")
    public String content;

    @JsonProperty("url")
    public String url;

    @JsonProperty("title")
    public String title;

    @JsonProperty("ual")
    public String ual;

    @JsonProperty("createdAt")
    public Date createdAt;

    @JsonProperty("status")
    public String status;

    @JsonProperty("error")
    public String error;

    public SnippetAsset(Snippet snippet) {
        this.id = "https://api.truthchain.dev/snippets/" + snippet.getId().toString();
        this.content = snippet.getContent();
        this.url = snippet.getUrl();
        this.title = snippet.getTitle();
        this.createdAt = snippet.getCreatedAt();
    }

    public Snippet toSnippet() {
        return Snippet.builder()
                .id(UUID.fromString(this.id.replace("https://api.truthchain.dev/snippets/", "")))
                .content(this.content)
                .url(this.url)
                .title(this.title)
                .createdAt(this.createdAt)
                .build();
    }
}
