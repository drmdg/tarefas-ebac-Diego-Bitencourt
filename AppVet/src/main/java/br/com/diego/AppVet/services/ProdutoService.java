package br.com.diego.AppVet.services;

import br.com.diego.AppVet.models.Produto;
import br.com.diego.AppVet.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Object save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
}
