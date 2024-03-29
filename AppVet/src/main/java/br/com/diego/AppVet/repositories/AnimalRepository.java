package br.com.diego.AppVet.repositories;

import br.com.diego.AppVet.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, UUID> {

    @Query("SELECT m FROM Animal m WHERE m.id = :uuid")
    Animal getAnimalById(UUID uuid);
}
