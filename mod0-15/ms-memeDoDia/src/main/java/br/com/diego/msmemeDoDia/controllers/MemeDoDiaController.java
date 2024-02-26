package br.com.diego.msmemeDoDia.controllers;

import br.com.diego.msmemeDoDia.models.Meme;
import br.com.diego.msmemeDoDia.services.MemeDoDiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/memedodia")
public class MemeDoDiaController {

    @Autowired
    MemeDoDiaService memeDoDiaService;
    @GetMapping()
    public Meme buscaMeme() {
        return memeDoDiaService.buscaMemeAleatorio();
    }
}
