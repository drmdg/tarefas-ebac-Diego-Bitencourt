package br.com.diego.AppVet.controllers;

import br.com.diego.AppVet.dtos.ClienteDto;
import br.com.diego.AppVet.dtos.EnderecoDto;
import br.com.diego.AppVet.models.Cliente;
import br.com.diego.AppVet.models.Endereco;
import br.com.diego.AppVet.services.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    @PostMapping
    public ResponseEntity<Object> saveCliente(@RequestBody ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDto,cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));

    }

}
