package dev.truthchain.api.integration;


import dev.truthchain.api.entities.Snippet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.Date;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class SnippetIntegrationTest extends AbstractIntegrationTest {

    @Nested
    @DisplayName("create snippet")
    class creatingSnippet {

            @Test
            @DisplayName("POST /snippets should return 200 OK and snippet")
            void validSnippet__shouldReturnSnippet() throws Exception {

                Snippet snippet = Snippet.builder()
                        .content("Test Content")
                        .url("https://www.google.com")
                        .title("Test Title")
                        .type("article")
                        .build();

                mockMvc.perform(post("/v1/snippets")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(snippet))
                                .with(user("user").password("123123").roles("USER", "ADMIN")))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andExpect(jsonPath("$.id").exists())
                        .andExpect(jsonPath("$.createdAt").exists())
                        .andExpect(jsonPath("$.content").value(snippet.getContent()))
                        .andExpect(jsonPath("$.url").value(snippet.getUrl()))
                        .andExpect(jsonPath("$.title").value(snippet.getTitle()))
                        .andExpect(jsonPath("$.type").value(snippet.getType()))
                        .andDo(print());
            }

            @Test
            @DisplayName("POST /snippets should return 400 BAD REQUEST when snippet doesn't have content or url")
            void noContentOrUrl__shouldReturnBadRequest() throws Exception {

                Snippet snippet = Snippet.builder()
                        .content("")
                        .url("")
                        .title("Test Title")
                        .type("article")
                        .build();

                mockMvc.perform(post("/v1/snippets")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(snippet))
                                .with(user("user").password("123123").roles("USER", "ADMIN")))
                        .andExpect(status().isBadRequest())
                        .andDo(print());
            }
    }

    @Nested
    @DisplayName("get all snippets")
    class getAllSnippets {

        @Test
        @DisplayName("GET /snippets should return 200 OK and snippets")
        void getAll__shouldReturnAllSnippets() throws Exception {

            Snippet snippet1 = Snippet.builder()
                    .id(UUID.randomUUID())
                    .content("Test Content")
                    .url("https://www.google.com")
                    .title("Test Title")
                    .type("article")
                    .createdAt(new Date())
                    .build();

            Snippet snippet2 = Snippet.builder()
                    .id(UUID.randomUUID())
                    .content("Test Content 2")
                    .url("https://www.medium.com")
                    .title("Test Title 2")
                    .type("article")
                    .createdAt(new Date())
                    .build();

            snippetRepository.save(snippet1);
            snippetRepository.save(snippet2);

            mockMvc.perform(get("/v1/snippets")
                            .with(user("user").password("123123").roles("USER", "ADMIN")))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$", hasSize(2)));
        }

    }

}
