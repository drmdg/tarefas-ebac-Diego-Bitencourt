package br.com.diego.AppVet.services;

import br.com.diego.AppVet.models.ProdutoQuantidade;
import br.com.diego.AppVet.repositories.ProdutoQuantidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoQuantidadeService {
    @Autowired
    ProdutoQuantidadeRepository produtoQuantidadeRepository;
}
