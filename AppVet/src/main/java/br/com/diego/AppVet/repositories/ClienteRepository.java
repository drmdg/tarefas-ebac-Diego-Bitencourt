package br.com.diego.AppVet.repositories;

import br.com.diego.AppVet.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    @Query("SELECT m FROM Cliente m WHERE m.id = :uuid")
    Cliente getClienteById(UUID uuid);
}
