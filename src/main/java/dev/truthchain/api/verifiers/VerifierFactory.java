package dev.truthchain.api.verifiers;

import dev.truthchain.api.entities.Snippet;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VerifierFactory {

    @Value("${verifiers.default.enabled}")
    private boolean defaultEnabled;

    @Value("${verifiers.scraper.enabled}")
    private boolean scraperEnabled;

    private final Map<String, Verifier> verifierServices = new HashMap<>();

    @PostConstruct
    public void init() {
        if (defaultEnabled) {
            Verifier defaultVerifier = new DefaultVerifier();
            defaultVerifier.configure(null);

            verifierServices.put("default", defaultVerifier);
        }

        if (scraperEnabled) {
            Verifier scraperVerifier = new ScraperVerifier();
            scraperVerifier.configure(null);

            verifierServices.put("scraper", scraperVerifier);
        }
    }

    public void verify(Snippet snippet) {
        for (Verifier verifier : verifierServices.values()) {
            verifier.verify(snippet);
        }
    }

}
