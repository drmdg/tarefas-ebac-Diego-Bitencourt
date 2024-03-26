package br.com.diego.AppVet.services;

import br.com.diego.AppVet.models.Animal;
import br.com.diego.AppVet.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;
    public Object save(Animal animal) {
        return animalRepository.save(animal);
    }
}
