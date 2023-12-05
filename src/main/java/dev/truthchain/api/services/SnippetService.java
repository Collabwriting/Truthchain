package dev.truthchain.api.services;

import dev.truthchain.api.entities.Snippet;
import dev.truthchain.api.exceptions.BadRequestException;
import dev.truthchain.api.exceptions.NotFoundException;
import dev.truthchain.api.repositories.SnippetRepository;
import jakarta.persistence.EntityManager;
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

    @Autowired
    private DkgService dkgService;

    @Autowired
    private EntityManager entityManager;

    /**
     * Creates a snippet object and saves it to the database
     * @param snippet the snippet to create
     * @return the created snippet with id and timestamp
     */
    @Transactional
    public Snippet create(Snippet snippet) {

        validateSnippet(snippet);

        // save snippet to database
        snippet.setId(UUID.randomUUID());
        snippet.setCreatedAt(new Date());
        snippet.setStatus(Snippet.Status.PENDING);
        snippet = snippetRepository.save(snippet);

        // verify snippet
        verificationService.verify(snippet);

        // mark snippet as verified
        snippet.setStatus(Snippet.Status.VERIFIED);
        snippet = snippetRepository.save(snippet);

        // save changes to database
        entityManager.flush();

        // publish snippet to DKG
        dkgService.createAsset(snippet);

        return snippet;
    }

    /**
     * Reads a snippet from the database
     * @param id the id of the snippet to read
     * @return the snippet
     * @throws NotFoundException if the snippet is not found
     */
    @Transactional
    public Snippet read(UUID id) {
        return snippetRepository.findById(id).orElseThrow(() -> new NotFoundException("Snippet not found"));
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
