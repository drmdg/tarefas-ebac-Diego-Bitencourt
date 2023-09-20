package main.br.com.diego.dao;

import main.br.com.diego.domain.Produto;

import java.util.List;

public interface IProdutoDAO {

    public Integer cadastrar(Produto produto) throws Exception;

    public Produto consultar(String codigo) throws Exception;

    public Integer excluir(Produto produto) throws Exception;

    public List<Produto> buscarTodos() throws Exception;

    public Integer alterar(Produto produto) throws Exception;
}
