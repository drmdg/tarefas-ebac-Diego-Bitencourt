package br.com.diego.AppVet.controllers;


import br.com.diego.AppVet.dtos.EnderecoDto;
import br.com.diego.AppVet.dtos.ProdutoDto;
import br.com.diego.AppVet.models.Endereco;
import br.com.diego.AppVet.models.Produto;
import br.com.diego.AppVet.services.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Object> saveProduto(@RequestBody ProdutoDto produtoDto){
        Produto produto= new Produto();
        BeanUtils.copyProperties(produtoDto,produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));

    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }
}
