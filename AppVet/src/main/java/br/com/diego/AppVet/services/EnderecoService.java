package br.com.diego.AppVet.services;

import br.com.diego.AppVet.models.Endereco;
import br.com.diego.AppVet.repositories.EnderecoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @PersistenceContext
    private EntityManager entityManager;


    public Object save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    @Transactional
    public Endereco merge(Endereco endereco) {
        return entityManager.merge(endereco);
    }
}
