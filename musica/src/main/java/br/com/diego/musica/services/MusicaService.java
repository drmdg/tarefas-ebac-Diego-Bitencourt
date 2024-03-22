package br.com.diego.musica.services;

import br.com.diego.musica.enums.DificuldadeMusica;
import br.com.diego.musica.models.Musica;
import br.com.diego.musica.repositories.MusicaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MusicaService {


    @Autowired
    MusicaRepository musicaRepository;

    public boolean existByNome(String nome) {
        return musicaRepository.existsByNomeMusica(nome);
    }

    @Transactional
    public Object save(Musica musica) {
        return musicaRepository.save(musica);
    }

    public List<Musica> findAll() {
        return musicaRepository.findAll();
    }
    public List<Musica> findMusicasBateria(){return musicaRepository.findMusicasBateria();}
    public List<Musica> findMusicasViolao(){return musicaRepository.findMusicasViolao();}
    public List<Musica> findMusicasGuitarra(){return musicaRepository.findMusicasGuitarra();}
    public Optional<Musica> findById(UUID id) {
        return musicaRepository.findById(id);
    }

    @Transactional
    public void delete(Musica musica) {
        musicaRepository.delete(musica);
    }

    public List<Musica> findMusicasGuitarraDificuldade(DificuldadeMusica dificuldadeMusica) {
        return musicaRepository.findMusicasGuitarraDificuldade(dificuldadeMusica);
    }

    public List<Musica> findMusicasViolaoDificuldade(DificuldadeMusica dificuldadeMusica) {
        return musicaRepository.findMusicasViolaoDificuldade(dificuldadeMusica);
    }

    public List<Musica> findMusicasBateriaDificuldade(DificuldadeMusica dificuldadeMusica) {
        return musicaRepository.findMusicasBateriaDificuldade(dificuldadeMusica);
    }

    public List<Musica> findMusicaByNome(String nomeDaMusica) {
        return musicaRepository.findMusicaByNome(nomeDaMusica);
    }
}
