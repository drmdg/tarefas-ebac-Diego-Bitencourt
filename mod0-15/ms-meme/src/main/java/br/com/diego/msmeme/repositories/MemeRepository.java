package br.com.diego.msmeme.repositories;

import br.com.diego.msmeme.models.Meme;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemeRepository extends MongoRepository<Meme,String> {
}
