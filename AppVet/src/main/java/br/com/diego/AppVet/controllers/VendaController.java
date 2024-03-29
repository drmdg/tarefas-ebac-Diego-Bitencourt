package br.com.diego.AppVet.controllers;

import br.com.diego.AppVet.dtos.ProdutoDto;
import br.com.diego.AppVet.dtos.VacinaDto;
import br.com.diego.AppVet.dtos.VendaDto;
import br.com.diego.AppVet.enums.Status;
import br.com.diego.AppVet.models.*;
import br.com.diego.AppVet.services.ClienteService;
import br.com.diego.AppVet.services.ProdutoQuantidadeService;
import br.com.diego.AppVet.services.VendaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    VendaService vendaService;
    @Autowired
    ClienteService clienteService;

    @Autowired
    ProdutoQuantidadeService produtoQuantidadeService;

    @PostMapping
    public ResponseEntity<Object> saveVenda(@RequestBody VendaDto vendaDto){
        Venda venda= new Venda();
        BeanUtils.copyProperties(vendaDto,venda);
        Cliente cliente = clienteService.getClienteById(vendaDto.clienteId());
        venda.setCliente(cliente);
        for (ProdutoQuantidade prodqtd : vendaDto.produtos()){
            prodqtd.setVenda(venda);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.save(venda));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> FinalizaVenda(@PathVariable (value = "id")UUID id){
        Optional<Venda> venda = Optional.ofNullable(vendaService.getClienteById(id));
        if (venda.isPresent()){
            venda.get().setStatus(Status.valueOf("CONCLUIDA"));
            vendaService.save(venda.get());
            return ResponseEntity.status(HttpStatus.OK).body("Venda Concluida");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body("Venda nao encontrada");
        }

    }

    @PutMapping("adicionarproduto/{id}")
    public ResponseEntity<Object> adicionaItemVenda(@PathVariable (value = "id")UUID id, @RequestBody Produto produto){
        Optional<Venda> venda = Optional.ofNullable(vendaService.getClienteById(id));
        if (venda.isPresent()){
            venda.get().adicionarProduto(produto,1);
            vendaService.save(venda.get());
            return ResponseEntity.status(HttpStatus.OK).body(vendaService.save(venda.get()));
        }else{
            return ResponseEntity.status(HttpStatus.OK).body("Venda nao encontrada");
        }

    }


    @GetMapping
    public ResponseEntity<List<Venda>> getAllVendas(){
        return ResponseEntity.status(HttpStatus.OK).body(vendaService.findAll());
    }
}
