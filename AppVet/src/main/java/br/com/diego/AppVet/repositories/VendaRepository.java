package br.com.diego.AppVet.repositories;

import br.com.diego.AppVet.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface VendaRepository extends JpaRepository<Venda, UUID> {

    @Query("SELECT m FROM Venda m WHERE m.id = :id")
    Venda getClienteById(UUID id);
}
