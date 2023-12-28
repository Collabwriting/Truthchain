package dev.truthchain.api.services;

import dev.truthchain.api.entities.Snippet;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

    @Nested
    @DisplayName("read asset")
    public class readAsset {

        @Test
        @DisplayName("valid snippet should read dkg asset")
        public void validSnippet__shouldReadAsset() {
            Snippet dkgSnippet = dkgService.readAsset("did:dkg:otp/0x1a061136ed9f5ed69395f18961a0a535ef4b3e5f/1190732");

            assertNotNull(dkgSnippet);
            assertEquals(dkgSnippet.getId(), UUID.fromString("d40a8dc2-e757-4226-8d1e-d8fdd8f355b8"));
        }
    }
}
