package main.java.br.com.diego.dao;

import main.java.br.com.diego.domain.Carro;
import main.java.br.com.diego.domain.Marca;

import java.util.List;

public interface ICarroDao {
    public Carro cadastrar(Carro carro);

    List<Carro> buscarTodos();

    void excluir(Carro carro);
}
