package br.com.ebac.animalsservice.repositorios;

import br.com.ebac.animalsservice.entidades.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// AnimalRepository.java
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT a from Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada ")
    List<Animal> findNotAdopted();

    @Query("SELECT a from Animal a WHERE a.dataAdocao IS NOT NULL")
    List<Animal> findAdopted();

    @Query("SELECT a.collaborator, COUNT(a) FROM Animal a GROUP BY a.collaborator")
    List<Object[]> countAnimalsPerCollaborator();

}
