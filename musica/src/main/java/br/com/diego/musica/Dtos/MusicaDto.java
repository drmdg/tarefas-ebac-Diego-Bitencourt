package br.com.diego.musica.Dtos;

import br.com.diego.musica.enums.DificuldadeMusica;
import br.com.diego.musica.enums.InstrumentoMusical;

public record MusicaDto(String nomeMusica, String banda, String link, InstrumentoMusical instrumentoMusical,DificuldadeMusica dificuldadeMusica) {
}
