package br.com.diego.msusuario.controllers;


import br.com.diego.msusuario.models.UsuarioModel;
import br.com.diego.msusuario.services.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServico usuarioServico;

    @GetMapping()
    public List<UsuarioModel> buscaUsuarios() {
        return usuarioServico.listaTodosUsuarios();
    }

    @PostMapping()
    public UsuarioModel novoUsuario(@RequestBody UsuarioModel usuario) {
        return usuarioServico.novoUsuario(usuario);
    }
}
