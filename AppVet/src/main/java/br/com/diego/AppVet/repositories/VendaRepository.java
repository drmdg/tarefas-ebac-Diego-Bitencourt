package br.com.diego.AppVet.repositories;

import br.com.diego.AppVet.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VendaRepository extends JpaRepository<Venda, UUID> {

}
