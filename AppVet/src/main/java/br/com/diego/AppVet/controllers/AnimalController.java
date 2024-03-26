package br.com.diego.AppVet.controllers;

import br.com.diego.AppVet.dtos.AnimalDto;
import br.com.diego.AppVet.models.Animal;
import br.com.diego.AppVet.services.AnimalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @PostMapping
    public ResponseEntity<Object> saveAnimal(@RequestBody AnimalDto animalDto){
        Animal animal= new Animal();
        BeanUtils.copyProperties(animalDto,animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.save(animal));

    }

}
