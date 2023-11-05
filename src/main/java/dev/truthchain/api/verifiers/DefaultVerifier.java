package dev.truthchain.api.verifiers;

import dev.truthchain.api.entities.Snippet;

public class DefaultVerifier implements Verifier {

    public boolean verify(Snippet snippet) {
        return true;
    }

    public boolean configure(Object config) {
        return true;
    }
}
