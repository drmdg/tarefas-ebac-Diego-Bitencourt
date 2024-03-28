package br.com.diego.AppVet.controllers;

import br.com.diego.AppVet.dtos.ClienteDto;
import br.com.diego.AppVet.dtos.EnderecoDto;
import br.com.diego.AppVet.models.Animal;
import br.com.diego.AppVet.models.Cliente;
import br.com.diego.AppVet.models.Endereco;
import br.com.diego.AppVet.services.AnimalService;
import br.com.diego.AppVet.services.ClienteService;
import br.com.diego.AppVet.services.EnderecoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    @Autowired
    EnderecoService enderecoService;
    @Autowired
    AnimalService animalService;

    @PostMapping
    public ResponseEntity<Object> saveCliente(@RequestBody ClienteDto clienteDto) {
        Cliente cliente = new Cliente();

        BeanUtils.copyProperties(clienteDto, cliente);

        if (clienteDto.endereco() != null) {
            Endereco endereco = clienteDto.endereco();
            if (endereco.getId() != null) {
                endereco = enderecoService.merge(endereco);
            }
            cliente.setEndereco(endereco);
        }
        Cliente savedCliente = (Cliente) clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCliente);
    }
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }
}

