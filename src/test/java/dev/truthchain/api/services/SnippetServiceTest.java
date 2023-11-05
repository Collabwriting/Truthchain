package dev.truthchain.api.services;

import dev.truthchain.api.entities.Snippet;
import dev.truthchain.api.exceptions.BadRequestException;
import dev.truthchain.api.exceptions.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

public class SnippetServiceTest extends AbstractServiceTest {

    @Nested
    @DisplayName("create snippet")
    public class createSnippet {

        @Test
        @DisplayName("valid snippet should create snippet")
        public void validSnippet__shouldCreateSnippet() {

            Snippet snippet = Snippet.builder()
                    .content("Test Content")
                    .url("https://www.google.com")
                    .title("Test Title")
                    .type("article")
                    .build();

            var savedSnippet = snippetService.create(snippet);
            var foundSnippet = snippetRepository.findById(savedSnippet.getId()).orElse(null);

            assertNotNull(foundSnippet);
            assertEquals(foundSnippet.getId(), savedSnippet.getId());
            assertEquals(foundSnippet.getContent(), savedSnippet.getContent());
            assertEquals(foundSnippet.getUrl(), savedSnippet.getUrl());
            assertEquals(foundSnippet.getTitle(), savedSnippet.getTitle());
            assertEquals(foundSnippet.getType(), savedSnippet.getType());
        }

        @Test
        @DisplayName("null snippet should throw not found exception")
        public void nullSnippet__shouldThrowNotFoundException() {
            Snippet snippet = null;

            assertThrows(NotFoundException.class, () -> {
                snippetService.create(snippet);
            });
        }

        @Test
        @DisplayName("empty content should throw bad request exception")
        public void emptyContent__shouldThrowBadRequestException() {
            Snippet snippet = Snippet.builder()
                    .content("")
                    .url("https://www.google.com")
                    .title("Test Title")
                    .type("article")
                    .build();

            assertThrows(BadRequestException.class, () -> {
                snippetService.create(snippet);
            });
        }

        @Test
        @DisplayName("empty url should throw bad request exception")
        public void emptyUrl__shouldThrowBadRequestException() {
            Snippet snippet = Snippet.builder()
                    .content("Test Content")
                    .url("")
                    .title("Test Title")
                    .type("article")
                    .build();

            assertThrows(BadRequestException.class, () -> {
                snippetService.create(snippet);
            });
        }
    }

}
