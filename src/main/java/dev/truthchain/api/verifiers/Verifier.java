package dev.truthchain.api.verifiers;

import dev.truthchain.api.entities.Snippet;

public interface Verifier {

    public boolean verify(Snippet snippet);

    public boolean configure(Object config);

}
