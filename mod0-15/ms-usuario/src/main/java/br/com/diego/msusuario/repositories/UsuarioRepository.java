package br.com.diego.msusuario.repositories;

import br.com.diego.msusuario.models.UsuarioModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<UsuarioModel,String> {
}
