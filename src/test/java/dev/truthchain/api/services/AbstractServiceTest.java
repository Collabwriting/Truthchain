package dev.truthchain.api.services;

import dev.truthchain.api.repositories.SnippetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@ActiveProfiles("it")
public abstract class AbstractServiceTest {

    @Autowired
    protected SnippetService snippetService;

    @Autowired
    protected SnippetRepository snippetRepository;

    @Autowired
    protected DkgService dkgService;

    @BeforeEach
    void setUp() {
        snippetRepository.deleteAll();
    }
}
