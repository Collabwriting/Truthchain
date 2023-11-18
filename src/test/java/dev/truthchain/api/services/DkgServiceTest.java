package dev.truthchain.api.services;

import dev.truthchain.api.entities.Snippet;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Disabled("DKG Service requires a valid running DKG node and API key to run")
public class DkgServiceTest extends AbstractServiceTest {

    @Nested
    @DisplayName("create asset")
    public class createAsset {

        @Test
        @DisplayName("valid snippet should create dkg asset")
        public void validSnippet__shouldCreateAsset() {

            Snippet snippet = Snippet.builder()
                    .content("Test Content")
                    .url("https://www.google.com")
                    .title("Test Title")
                    .type("article")
                    .build();

            var savedSnippet = snippetService.create(snippet);

            dkgService.createAsset(savedSnippet);
        }
    }
}
