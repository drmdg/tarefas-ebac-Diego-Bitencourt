package br.com.diego.msmemeDoDia.services;

import br.com.diego.msmemeDoDia.models.Meme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Random;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.amqp.core.QueueBuilder.LeaderLocator.random;
@Component
public class MemeDoDiaService {
    private static final Logger logger = Logger.getLogger(MemeDoDiaService.class.getName());

    public Meme buscaMemeAleatorio() {
        List<Meme> memes = listaTodosMemes();
        if (memes != null && !memes.isEmpty()) {
            Random random = new Random();
            int indiceAleatorio = random.nextInt(memes.size());

            Meme memeAleatorio = memes.get(indiceAleatorio);
            logger.log(Level.INFO, "Meme aleatório encontrado: {0}", memeAleatorio);
            return memeAleatorio;
        } else {
            logger.log(Level.WARNING, "Lista de memes vazia ou nula. Não foi possível buscar um meme aleatório.");
            return null;
        }
    }

    public List<Meme> listaTodosMemes() {
        String url = "http://localhost:8082/meme";

        try {
            RestTemplate restTemplate = new RestTemplate();
            List<Meme> listaDeMemes = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Meme>>() {}
            ).getBody();

            logger.log(Level.INFO, "Lista de memes obtida com sucesso");
            return listaDeMemes;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao obter a lista de memes", e);
            return null;
        }
    }
}
