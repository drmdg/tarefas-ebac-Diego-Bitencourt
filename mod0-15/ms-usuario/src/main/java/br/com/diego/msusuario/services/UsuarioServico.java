package br.com.diego.msusuario.services;

import br.com.diego.msusuario.models.UsuarioModel;
import br.com.diego.msusuario.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class UsuarioServico {
    private static final Logger logger = Logger.getLogger(UsuarioServico.class.getName());

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioModel> listaTodosUsuarios() {
        logger.log(Level.INFO, "Listando todos os usuários");
        return usuarioRepository.findAll();
    }

    public UsuarioModel novoUsuario(UsuarioModel usuario) {
        usuario.setDataCadastro(LocalDateTime.now());
        UsuarioModel novoUsuario = usuarioRepository.save(usuario);
        logger.log(Level.INFO, "Novo usuário adicionado: {0}", novoUsuario);
        return novoUsuario;
    }
}
