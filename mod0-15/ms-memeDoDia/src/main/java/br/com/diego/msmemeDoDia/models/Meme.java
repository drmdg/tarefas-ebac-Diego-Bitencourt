package br.com.diego.msmemeDoDia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Meme {

    private String Id;

    private String nome;

    private String descricao;

    private LocalDateTime dataCadastro;
    private String usuarioId;

    public Meme(String nome, String descricao,String usuarioId){
        this.nome=nome;
        this.descricao=descricao;
        this.usuarioId=usuarioId;
        this.dataCadastro=LocalDateTime.now();
    }
}