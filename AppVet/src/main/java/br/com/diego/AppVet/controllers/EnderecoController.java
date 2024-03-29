package br.com.diego.AppVet.controllers;


import br.com.diego.AppVet.dtos.EnderecoDto;
import br.com.diego.AppVet.models.Endereco;
import br.com.diego.AppVet.services.EnderecoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Object> saveEndereco(@RequestBody EnderecoDto enderecoDto){
        Endereco endereco= new Endereco();
        BeanUtils.copyProperties(enderecoDto,endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(endereco));

    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getAllenderecos(){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll());
    }
}
