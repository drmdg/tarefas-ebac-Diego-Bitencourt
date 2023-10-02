package main.java.br.com.diego.dao;

import main.java.br.com.diego.domain.Produto;

import java.util.List;

public interface IProdutoDao {

    public Produto cadastrar(Produto prod);

    List<Produto> buscarTodos();

    void excluir(Produto prod);
}
