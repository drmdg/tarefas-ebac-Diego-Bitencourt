package br.com.diego.msmeme.controllers;

import br.com.diego.msmeme.models.Meme;
import br.com.diego.msmeme.services.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/meme")
public class MemeController {

    @Autowired
    MemeService memeService;

    @GetMapping()
    public List<Meme> buscaMemes() {
        return memeService.listaTodosMemes();
    }

    @PostMapping()
    public Meme novoMeme(@RequestBody Meme meme) {
        return memeService.novoMeme(meme);
    }
}
