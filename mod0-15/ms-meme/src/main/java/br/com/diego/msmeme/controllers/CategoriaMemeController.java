package br.com.diego.msmeme.controllers;

import br.com.diego.msmeme.models.CategoriaMeme;
import br.com.diego.msmeme.models.UsuarioModel;
import br.com.diego.msmeme.services.CategoriaMemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(path = "/categoria")
public class CategoriaMemeController {
    @Autowired
    CategoriaMemeService categoriaMemeService;

    @GetMapping()
    public List<CategoriaMeme> buscaCategorias() {
        return categoriaMemeService.listaTodasCategorias();
    }

    @PostMapping()
    public CategoriaMeme novaCategoria(@RequestBody CategoriaMeme categoriaMeme) {
        return categoriaMemeService.novaCategoriaMeme(categoriaMeme);
    }


}
