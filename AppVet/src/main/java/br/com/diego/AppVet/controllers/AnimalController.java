package br.com.diego.AppVet.controllers;

import br.com.diego.AppVet.dtos.AnimalDto;
import br.com.diego.AppVet.models.Animal;
import br.com.diego.AppVet.models.Cliente;
import br.com.diego.AppVet.services.AnimalService;
import br.com.diego.AppVet.services.ClienteService;
import br.com.diego.AppVet.services.VacinaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    VacinaService vacinaService;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> saveAnimal(@RequestBody AnimalDto animalDto){
        Animal animal= new Animal();
        BeanUtils.copyProperties(animalDto, animal);

        Cliente cliente = clienteService.getClienteById(animalDto.clienteid());
        if (cliente != null) {
            clienteService.addAnimal(cliente, animal);
        } else {
            // Trate o caso em que o cliente não foi encontrado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.save(animal));
    }

    @GetMapping
    public ResponseEntity<List<Animal>> GetAllAnimal(){
        return ResponseEntity.status(HttpStatus.OK).body(animalService.findAll());
    }

}
