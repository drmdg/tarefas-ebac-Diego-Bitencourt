package br.com.ebac.animalsservice.controllers;

import br.com.ebac.animalsservice.entidades.Animal;
import br.com.ebac.animalsservice.repositorios.AnimalRepository;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

// AnimalController.java
@RestController
@RequestMapping("/animais")
public class AnimalController {

    private AnimalRepository repository;

    public AnimalController(AnimalRepository repository){
        this.repository=repository;
    }
    @GetMapping
    private List<Animal> findAll(){
        return repository.findAll();
    }

    @PostMapping
    private Animal create(@RequestBody Animal animal){
        return repository.save(animal);
    }


    @GetMapping("/not-adopted")
    private List<Animal> findNotAdopted(){
        return repository.findNotAdopted();
    }

    @GetMapping("/adopted")
    private List<Animal> findAdopted(){
        return repository.findAdopted();
    }

    @GetMapping("/collaborator-count")
    public List<Object[]> countAnimalsPerCollaborator() {
        return repository.countAnimalsPerCollaborator();
    }

}
