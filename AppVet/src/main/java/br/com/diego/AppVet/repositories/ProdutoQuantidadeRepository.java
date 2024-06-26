package br.com.diego.AppVet.repositories;

import br.com.diego.AppVet.models.ProdutoQuantidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoQuantidadeRepository extends JpaRepository<ProdutoQuantidade, UUID> {
}
