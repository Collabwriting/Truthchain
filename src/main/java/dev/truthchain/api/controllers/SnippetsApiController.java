package dev.truthchain.api.controllers;

import dev.truthchain.api.entities.Snippet;
import dev.truthchain.api.services.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/snippets")
public class SnippetsApiController {

    @Autowired
    private SnippetService snippetService;

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
        return snippetService.read(id);
    }

    @PatchMapping("/{id}")
    public Snippet update(
            @PathVariable UUID id,
            @RequestBody Snippet snippet
    ) {
        return snippetService.update(id, snippet);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable UUID id
    ) {
        // TODO: snippetService.delete(id);
    }

    @PostMapping("/verify/{ual}")
    public Snippet verify(
            @PathVariable String ual
    ) {
        return snippetService.verify(ual);
    }

}
