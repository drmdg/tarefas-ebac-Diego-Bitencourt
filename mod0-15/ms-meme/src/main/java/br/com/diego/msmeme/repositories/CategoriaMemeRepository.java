package br.com.diego.msmeme.repositories;

import br.com.diego.msmeme.models.CategoriaMeme;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriaMemeRepository extends MongoRepository<CategoriaMeme,String> {
}
