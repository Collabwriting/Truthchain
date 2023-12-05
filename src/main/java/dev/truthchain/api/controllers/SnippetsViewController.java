package dev.truthchain.api.controllers;

import dev.truthchain.api.exceptions.NotFoundException;
import dev.truthchain.api.repositories.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/snippets")
public class SnippetsViewController {

    @Autowired
    private SnippetRepository snippetRepository;

    @GetMapping("/{id}")
    public String view(
            Model model,
            @PathVariable UUID id) {

        var snippet = snippetRepository.findById(id).orElseThrow(() -> new NotFoundException("Snippet not found"));

        model.addAttribute("snippet", snippet);

        return "snippet";
    }
}
