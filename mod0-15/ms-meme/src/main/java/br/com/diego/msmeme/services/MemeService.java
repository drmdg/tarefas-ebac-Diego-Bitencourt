package br.com.diego.msmeme.services;

import br.com.diego.msmeme.models.CategoriaMeme;
import br.com.diego.msmeme.models.Meme;
import br.com.diego.msmeme.models.UsuarioModel;
import br.com.diego.msmeme.repositories.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class MemeService {

    private static final Logger logger = Logger.getLogger(MemeService.class.getName());

    @Autowired
    MemeRepository memeRepository;

    public List<Meme> listaTodosMemes() {
        logger.log(Level.INFO, "Listando todos os memes");
        return memeRepository.findAll();
    }

    public Meme novoMeme(Meme meme) {
        meme.setDataCadastro(LocalDateTime.now());
        boolean existeUsuario = verificaExistenciaUsuario(meme.getUsuarioId());
        boolean existeCategoria = verificaExistenciaCategoria(meme.getCategoria());

        if (existeCategoria && existeUsuario) {
            Meme novoMeme = memeRepository.save(meme);
            logger.log(Level.INFO, "Novo meme adicionado: {0}", novoMeme);
            return novoMeme;
        } else {
            logger.log(Level.WARNING, "Não foi possível adicionar o novo meme. Verifique a existência do usuário e da categoria.");
            return null;
        }
    }

    private boolean verificaExistenciaUsuario(String id) {
        String url = "http://localhost:8081/usuario";
        boolean existe = false;

        try {
            RestTemplate restTemplate = new RestTemplate();
            List<UsuarioModel> usuarios = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<UsuarioModel>>() {}
            ).getBody();

            for (UsuarioModel usuario : usuarios) {
                if (usuario.getId().equals(id)) {
                    existe = true;
                    break;
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao verificar a existência do usuário", e);
        }

        return existe;
    }

    private boolean verificaExistenciaCategoria(String nome) {
        String url = "http://localhost:8082/categoria";
        boolean existe = false;

        try {
            RestTemplate restTemplate = new RestTemplate();
            List<CategoriaMeme> categorias = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<CategoriaMeme>>() {}
            ).getBody();

            for (CategoriaMeme categoriaMeme : categorias) {
                if (categoriaMeme.getNome().equals(nome)) {
                    existe = true;
                    break;
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao verificar a existência da categoria", e);
        }

        return existe;
    }
}