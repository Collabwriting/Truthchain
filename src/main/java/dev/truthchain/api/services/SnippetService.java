package dev.truthchain.api.services;

import dev.truthchain.api.entities.Snippet;
import dev.truthchain.api.exceptions.BadRequestException;
import dev.truthchain.api.exceptions.NotFoundException;
import dev.truthchain.api.repositories.SnippetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class SnippetService {

    @Autowired
    private SnippetRepository snippetRepository;

    @Autowired
    private VerificationService verificationService;

    /**
     * Creates a snippet object and saves it to the database
     * @param snippet the snippet to create
     * @return the created snippet with id and timestamp
     */
    @Transactional
    public Snippet create(Snippet snippet) {

        validateSnippet(snippet);

        snippet.setId(UUID.randomUUID());
        snippet.setCreatedAt(new Date());
        snippetRepository.save(snippet);

        verificationService.verify(snippet);

        // dkgService.mint(snippet);
        // snippet.setStatus(Snippet.Status.MINTING);

        return snippet;
    }

    /**
     * Validates a snippet object and throws an exception if it is not valid
     * @param snippet the snippet to validate
     */
    private void validateSnippet(Snippet snippet){
        if(snippet == null) throw new NotFoundException("Snippet not found");
        if(snippet.getContent() == null || snippet.getContent().isEmpty()) throw new BadRequestException("Snippet content cannot be empty");
        if(snippet.getUrl() == null || snippet.getUrl().isEmpty()) throw new BadRequestException("Snippet url cannot be empty");
    }
}
