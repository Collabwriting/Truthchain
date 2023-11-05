package dev.truthchain.api.services;

import dev.truthchain.api.entities.Snippet;
import dev.truthchain.api.verifiers.VerifierFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationService {

    @Autowired
    private VerifierFactory verifierFactory;

    public void verify(Snippet snippet) {
        verifierFactory.verify(snippet);
    }
}
