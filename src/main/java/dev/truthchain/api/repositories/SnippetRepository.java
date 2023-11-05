package dev.truthchain.api.repositories;

import dev.truthchain.api.entities.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SnippetRepository extends JpaRepository<Snippet, UUID> {
}
