package br.com.diego.msmeme.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
@Document("CategoriaMeme")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaMeme {

    @org.springframework.data.annotation.Id
    private String Id;

    @Field("nome")
    @org.springframework.lang.NonNull
    private String nome;
    @Field("descricao")
    @org.springframework.lang.NonNull
    private String descricao;
    @Field("dataCadastro")
    @org.springframework.lang.NonNull
    private LocalDateTime dataCadastro;
    @Field("usuarioId")
    @org.springframework.lang.NonNull
    private String usuarioId;

    public CategoriaMeme(String nome, String descricao,String usuarioId){
        this.nome=nome;
        this.descricao=descricao;
        this.usuarioId=usuarioId;
        this.dataCadastro=LocalDateTime.now();
    }

}
