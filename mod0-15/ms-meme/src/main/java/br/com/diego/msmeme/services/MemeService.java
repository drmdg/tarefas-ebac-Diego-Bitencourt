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
@Component
public class MemeService {
    @Autowired
    MemeRepository memeRepository;
    public List<Meme> listaTodosMemes() {
        return memeRepository.findAll();
    }

    public Meme novoMeme(Meme meme) {
        meme.setDataCadastro(LocalDateTime.now());
        boolean existeUsuario=verificaExistenciaUsuario(meme.getUsuarioId());
        boolean existeCategoria=verificaExistenciaCategoria(meme.getCategoria());
        if(existeCategoria==true && existeUsuario==true){
            return memeRepository.save(meme);
        }else {
            return null;
        }

    }

    private boolean verificaExistenciaUsuario(String id){
        String url = "http://localhost:8081/usuario";
        boolean existe = false;
        RestTemplate restTemplate = new RestTemplate();
        List<UsuarioModel> usuarios= restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UsuarioModel>>() {}
        ).getBody();

        for (UsuarioModel usuario : usuarios){
            if (usuario.getId().equals(id)){
                existe=true;
            }
        }
        return existe;
    }
    private boolean verificaExistenciaCategoria(String nome){
        String url = "http://localhost:8082/categoria";
        boolean existe = false;
        RestTemplate restTemplate = new RestTemplate();
        List<CategoriaMeme> categorias= restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CategoriaMeme>>() {}
        ).getBody();

        for (CategoriaMeme categoriaMeme : categorias){
            if (categoriaMeme.getNome().equals(nome)){
                existe=true;
            }
        }
        return existe;
    }
}
