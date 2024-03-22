package br.com.diego.musica.models;

import br.com.diego.musica.enums.DificuldadeMusica;
import br.com.diego.musica.enums.InstrumentoMusical;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Tabela_Musica")
@Getter
@Setter
@NoArgsConstructor
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false,length = 70)
    private String nomeMusica;
    @Column(nullable = false,length = 70)
    private String banda;
    @Column(nullable = false,length = 200)
    private String link;
    @Column(nullable = false,length = 70)
    private InstrumentoMusical instrumentoMusical;
    @Column(nullable = false,length = 70)
    private DificuldadeMusica dificuldadeMusica;
}
