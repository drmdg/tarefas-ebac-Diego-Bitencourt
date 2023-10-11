package main.java.br.com.diego.dao;

import main.java.br.com.diego.domain.Acessorio;
import main.java.br.com.diego.domain.Marca;

import java.util.List;

public interface IAcessorioDao {
    public Acessorio cadastrar(Acessorio acessorio);

    List<Acessorio> buscarTodos();

    void excluir(Acessorio acessorio);

}
