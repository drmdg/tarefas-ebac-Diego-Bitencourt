package br.com.diego.msmeme.services;

import br.com.diego.msmeme.models.CategoriaMeme;
import br.com.diego.msmeme.models.UsuarioModel;
import br.com.diego.msmeme.repositories.CategoriaMemeRepository;
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
public class CategoriaMemeService {

    private static final Logger logger = Logger.getLogger(CategoriaMemeService.class.getName());
    @Autowired
    CategoriaMemeRepository categoriaMemeRepository;
    public List<CategoriaMeme> listaTodasCategorias() {
        logger.log(Level.INFO, "Listando todas as categorias de memes");
        return categoriaMemeRepository.findAll();
    }

    public CategoriaMeme novaCategoriaMeme(CategoriaMeme categoriaMeme) {
        categoriaMeme.setDataCadastro(LocalDateTime.now());
        boolean existe = verificaExistenciaUsuario(categoriaMeme.getUsuarioId());
        if(existe){
            CategoriaMeme novaCategoria = categoriaMemeRepository.save(categoriaMeme);
            logger.log(Level.INFO, "Nova categoria de meme adicionada: {0} " + categoriaMeme.getUsuarioId(), novaCategoria);
            return novaCategoria;
        } else{
            logger.log(Level.WARNING, "Usuário não encontrado. Não foi possível adicionar a nova categoria de meme. "+categoriaMeme.getUsuarioId());
            return null;
        }

    }
    private boolean verificaExistenciaUsuario(String id) {
        String url = "http://localhost:8081/usuario";
        boolean existe = false;

        RestTemplate restTemplate = new RestTemplate();

        try {
            List<UsuarioModel> usuarios = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<UsuarioModel>>() {
                    }
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
}
