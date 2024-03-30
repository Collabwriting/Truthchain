package dev.truthchain.api.controllers;

import dev.truthchain.api.entities.Snippet;
import dev.truthchain.api.exceptions.NotFoundException;
import dev.truthchain.api.repositories.SnippetRepository;
import dev.truthchain.api.services.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/snippets")
public class SnippetsViewController {

    @Autowired
    private SnippetRepository snippetRepository;

    @Autowired
    private SnippetService snippetService;

    @GetMapping("/{id}")
    public String view(
            Model model,
            @PathVariable UUID id) {

        var snippet = snippetRepository.findById(id).orElseThrow(() -> new NotFoundException("Snippet not found"));

        model.addAttribute("snippet", snippet);

        return "snippet";
    }

    @GetMapping("/{id}/mint")
    public String mint(
            Model model,
            @PathVariable UUID id
    ) {

        var snippet = snippetRepository.findById(id).orElseThrow(() -> new NotFoundException("Snippet not found"));

        if(snippet.getUal() != null) {
            return "redirect:/snippets/" + snippet.getId();
        }

        model.addAttribute("snippet", snippet);
        return "mint";
    }

    @PostMapping("/verify")
    public String verify(
            Model model,
            @RequestParam(name = "ual") String ual
    ) {

        try {
            Snippet snippet = snippetService.verify(ual);
            return "redirect:/snippets/" + snippet.getId();

        } catch (NotFoundException e) {
            return "redirect:/verify?error=not-found";

        }
    }

}
