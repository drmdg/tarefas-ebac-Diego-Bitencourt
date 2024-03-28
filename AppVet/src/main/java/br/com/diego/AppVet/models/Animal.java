package br.com.diego.AppVet.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "especie", nullable = false)
    private String especie;
    @Column(name = "raca")
    private String raca;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "idade", nullable = false)
    private Double idade;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "animal_id")
    private List<Vacina> vacinas;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
