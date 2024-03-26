package br.com.diego.AppVet.services;

import br.com.diego.AppVet.models.Cliente;
import br.com.diego.AppVet.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    public Object save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
