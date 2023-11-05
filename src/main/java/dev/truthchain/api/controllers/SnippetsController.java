package dev.truthchain.api.controllers;

import dev.truthchain.api.entities.Snippet;
import dev.truthchain.api.repositories.SnippetRepository;
import dev.truthchain.api.services.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/snippets")
public class SnippetsController {

    @Autowired
    private SnippetService snippetService;

    @Autowired
    private SnippetRepository snippetRepository;

    @GetMapping
    public Collection<Snippet> readAll() {
        return snippetRepository.findAll();
    }

    @PostMapping
    public Snippet create(
            @RequestBody Snippet snippet
    ) {
        return snippetService.create(snippet);
    }

    @GetMapping("/{id}")
    public Snippet read(
            @PathVariable UUID id
    ) {
        // TODO: return snippetService.read(id);
        return null;
    }

    @PatchMapping("/{id}")
    public Snippet update(
            @PathVariable UUID id,
            @RequestBody Snippet snippet
    ) {
        // TODO: return snippetService.update(id, snippet);
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable UUID id
    ) {
        // TODO: snippetService.delete(id);
    }

}
