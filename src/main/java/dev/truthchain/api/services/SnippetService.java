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
        snippet.setStatus(Snippet.Status.CREATED);
        snippet = snippetRepository.save(snippet);

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
        return snippetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Snippet not found"));
    }

    /**
     * Updates a snippet object and saves it to the database
     * @param id the id of the snippet to update
     * @param snippet the snippet to update
     * @return the updated snippet
     * @throws NotFoundException if the snippet is not found
     */
    @Transactional
    public Snippet update(UUID id, Snippet snippet) {

        if(snippet.getUal() == null || snippet.getUal().isEmpty())
            throw new BadRequestException("UAL cannot be empty");

        Snippet existingSnippet = snippetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Snippet not found"));

        if(existingSnippet.getUal() != null)
            throw new BadRequestException("UAL cannot be updated");

        existingSnippet.setUal(snippet.getUal());
        existingSnippet.setStatus(Snippet.Status.PUBLISHED);

        try {
            verifyOnDKG(existingSnippet);
            existingSnippet.setStatus(Snippet.Status.VERIFIED);

        } catch (Exception e) {
            existingSnippet.setError(Snippet.StatusError.NOT_VERIFIED_ON_DKG);
        }

        return snippetRepository.save(existingSnippet);
    }

    @Transactional
    public Snippet verify(String ual) {

        // get snippet from the DKG
        Snippet dkgSnippet = dkgService.readAsset(ual);

        // get snippet from the database
        Snippet snippet = snippetRepository.findById(dkgSnippet.getId())
                .orElseThrow(() -> new NotFoundException("Snippet not found"));

        // validate snippet status
        if(snippet.getStatus() == Snippet.Status.VERIFIED)
            return snippet;

        // verify that snippets are similar
        verifySimilarity(snippet, dkgSnippet);

        // mark snippet as verified
        snippet.setStatus(Snippet.Status.VERIFIED);
        return snippetRepository.save(snippet);
    }

    public void verifyOnDKG(Snippet snippet) {

        // get snippet from the DKG
        Snippet dkgSnippet = dkgService.readAsset(snippet.getUal());

        // verify that snippets are similar
        verifySimilarity(snippet, dkgSnippet);
    }

    public void verifySimilarity(Snippet snippet, Snippet dkgSnippet) {

        // validate that snippets are similar
        if( !dkgSnippet.getContent().equals(snippet.getContent()) ||
                !dkgSnippet.getUrl().equals(snippet.getUrl()) ||
                !dkgSnippet.getTitle().equals(snippet.getTitle()))
            throw new BadRequestException("Snippet cannot be updated");
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
