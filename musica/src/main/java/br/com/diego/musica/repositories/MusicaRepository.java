package br.com.diego.musica.repositories;

import br.com.diego.musica.enums.DificuldadeMusica;
import br.com.diego.musica.models.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface MusicaRepository extends JpaRepository<Musica, UUID> {

    boolean existsByNomeMusica(String nome);

    @Query("SELECT m FROM Musica m WHERE m.instrumentoMusical = 0")
    List<Musica> findMusicasBateria();
    @Query("SELECT m FROM Musica m WHERE m.instrumentoMusical = 1")
    List<Musica> findMusicasViolao();
    @Query("SELECT m FROM Musica m WHERE m.instrumentoMusical = 2")
    List<Musica> findMusicasGuitarra();
    @Query("SELECT m FROM Musica m WHERE m.instrumentoMusical = 2 and m.dificuldadeMusica = :dificuldadeMusica")
    List<Musica> findMusicasGuitarraDificuldade(DificuldadeMusica dificuldadeMusica);
    @Query("SELECT m FROM Musica m WHERE m.instrumentoMusical = 1 and m.dificuldadeMusica = :dificuldadeMusica")
    List<Musica> findMusicasViolaoDificuldade(DificuldadeMusica dificuldadeMusica);
    @Query("SELECT m FROM Musica m WHERE m.instrumentoMusical = 0 and m.dificuldadeMusica = :dificuldadeMusica")
    List<Musica> findMusicasBateriaDificuldade(DificuldadeMusica dificuldadeMusica);
    @Query("SELECT m FROM Musica m WHERE m.nomeMusica = :nomeDaMusica")
    List<Musica> findMusicaByNome(String nomeDaMusica);
}
