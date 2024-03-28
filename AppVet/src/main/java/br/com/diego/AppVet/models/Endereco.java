package br.com.diego.AppVet.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "cep", nullable = false)
    private String cep;
    @Column(name = "nome_da_rua", nullable = false)
    private String nomeDaRua;
    @Column(name = "bairro", nullable = false)
    private String bairro;
    @Column(name = "cidade", nullable = false)
    private String cidade;
    @Column(name = "estado", nullable = false)
    private String estado;
    @Column(name = "pais", nullable = false)
    private String pais;
    @Column(name = "numero_da_casa", nullable = false)
    private Integer numeroCasa;
}
