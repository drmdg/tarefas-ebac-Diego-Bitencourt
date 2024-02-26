package br.com.diego.msusuario.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Document("Usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioModel {

    @Id
    private String Id;

    @Field("nome")
    @org.springframework.lang.NonNull
    private String nome;
    @Field("email")
    @org.springframework.lang.NonNull
    private String email;
    @Field("dataCadastro")
    @org.springframework.lang.NonNull
    private LocalDateTime dataCadastro;

    public  UsuarioModel(String nome, String email){
        this.nome=nome;
        this.email=email;
        this.dataCadastro= LocalDateTime.now();
    }
}
