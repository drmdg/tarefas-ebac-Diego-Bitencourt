package br.com.diego.AppVet.repositories;

import br.com.diego.AppVet.models.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, UUID> {

    @Query("SELECT m FROM Vacina m WHERE m.id = :uuid")
    Vacina getVacinaById(UUID uuid);
}
