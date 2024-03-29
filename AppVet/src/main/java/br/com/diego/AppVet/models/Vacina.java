package br.com.diego.AppVet.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "codigo", nullable = false)
    private String codigo;
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Column(name = "valor", nullable = false)
    private BigDecimal valor;
}
