package br.com.diego.AppVet.services;

import br.com.diego.AppVet.models.Animal;
import br.com.diego.AppVet.repositories.AnimalRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    AnimalRepository animalRepository;
    public Object save(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal merge(Animal animal) {
        return entityManager.merge(animal);
    }
}
