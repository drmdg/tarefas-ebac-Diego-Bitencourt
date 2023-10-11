package main.java.br.com.diego.dao;

import main.java.br.com.diego.domain.Marca;

import java.util.List;

public interface IMarcaDao {

    public Marca cadastrar(Marca marca);

    List<Marca> buscarTodos();

    void excluir(Marca marca);
}
