package dev.truthchain.api.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.truthchain.api.repositories.SnippetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles("it")
public abstract class AbstractIntegrationTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected SnippetRepository snippetRepository;

    @Autowired
    protected ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        snippetRepository.deleteAll();
    }
}
