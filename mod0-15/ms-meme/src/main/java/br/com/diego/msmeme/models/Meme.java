package br.com.diego.msmeme.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document("Memes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Meme {

    @org.springframework.data.annotation.Id
    private String Id;

    @Field("nome")
    @org.springframework.lang.NonNull
    private String nome;
    @Field("url")
    @org.springframework.lang.NonNull
    private String url;
    @Field("dataCadastro")
    @org.springframework.lang.NonNull
    private LocalDateTime dataCadastro;
    @Field("usuarioId")
    @org.springframework.lang.NonNull
    private String usuarioId;
    @Field("categoria")
    @org.springframework.lang.NonNull
    private String categoria;

    public Meme(String nome, String url,String usuarioId,String categoria){
        this.nome=nome;
        this.url=url;
        this.usuarioId=usuarioId;
        this.categoria=categoria;
        this.dataCadastro=LocalDateTime.now();
    }
}
