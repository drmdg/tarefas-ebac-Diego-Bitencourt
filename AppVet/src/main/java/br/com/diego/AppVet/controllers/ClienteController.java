package br.com.diego.AppVet.controllers;

import br.com.diego.AppVet.dtos.ClienteDto;
import br.com.diego.AppVet.dtos.EnderecoDto;
import br.com.diego.AppVet.models.Cliente;
import br.com.diego.AppVet.models.Endereco;
import br.com.diego.AppVet.services.ClienteService;
import br.com.diego.AppVet.services.EnderecoService;
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
    @Autowired
    EnderecoService enderecoService;




    @PostMapping
    public ResponseEntity<Object> saveCliente(@RequestBody ClienteDto clienteDto) {
        // Cria um novo cliente
        Cliente cliente = new Cliente();

        // Copia as propriedades do clienteDto para o cliente
        BeanUtils.copyProperties(clienteDto, cliente);

        // Verifica se o endereço do cliente está presente no DTO
        if (clienteDto.endereco() != null) {
            // Obtém o endereco do DTO
            Endereco endereco = clienteDto.endereco();

            // Verifica se o endereco já existe no banco de dados
            if (endereco.getId() != null) {
                // Mescla o endereco com o estado persistido
                endereco = enderecoService.merge(endereco);
            }

            // Associa o endereco ao cliente
            cliente.setEndereco(endereco);
        }

        // Salva o cliente com o endereco associado
        Cliente savedCliente = (Cliente) clienteService.save(cliente);

        // Retorna a resposta com o cliente salvo
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCliente);
    }
}
