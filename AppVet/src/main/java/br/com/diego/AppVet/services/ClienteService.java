package br.com.diego.AppVet.services;

import br.com.diego.AppVet.models.Animal;
import br.com.diego.AppVet.models.Cliente;
import br.com.diego.AppVet.repositories.ClienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    ClienteRepository clienteRepository;
    public Object save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(UUID uuid){
        return clienteRepository.getClienteById(uuid);
    }

    public Optional<Cliente> merge(Cliente clienteOptional) {
        return Optional.ofNullable(entityManager.merge(clienteOptional));
    }

    public void addAnimal(Cliente cliente, Animal animal){
        cliente.setAnimal(animal);
    }
}
