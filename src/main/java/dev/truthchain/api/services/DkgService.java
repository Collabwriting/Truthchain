package dev.truthchain.api.services;

import dev.truthchain.api.assets.SnippetAsset;
import dev.truthchain.api.entities.Snippet;
import dev.truthchain.api.exceptions.NotFoundException;
import dev.truthchain.api.repositories.SnippetRepository;
import dev.truthchain.api.wrappers.DkgResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DkgService {

    @Value("${dkg.api.url}")
    private String DKG_API_URL;

    @Value("${dkg.api.key}")
    private String DKG_API_KEY;

    @Autowired
    private SnippetRepository snippetRepository;

    @Async
    public void createAsset(Snippet snippet) {

        // set snippet status to "creating"
        snippet = snippetRepository.findById(snippet.getId()).orElseThrow( () -> new NotFoundException("Snippet not found"));
        snippet.setStatus(Snippet.Status.PUBLISHING);
        snippetRepository.save(snippet);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-KEY", DKG_API_KEY);
        headers.set("Content-Type", "application/json");

        SnippetAsset snippetAsset = new SnippetAsset(snippet);
        HttpEntity<SnippetAsset> request = new HttpEntity<>(snippetAsset, headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<DkgResponse> response = restTemplate.postForEntity(DKG_API_URL + "assets", request, DkgResponse.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {

            // set snippet status to "created"
            snippet.setStatus(Snippet.Status.PUBLISHED);
            snippet.setUal(response.getBody().getUal());
            snippetRepository.save(snippet);

        } else {

            // set snippet status to "failed"
            snippet.setStatus(Snippet.Status.FAILED);
            snippet.setError(Snippet.StatusError.NOT_SAVED_TO_DKG);
            snippetRepository.save(snippet);
        }
    }
}
