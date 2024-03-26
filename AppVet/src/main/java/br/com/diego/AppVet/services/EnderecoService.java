package br.com.diego.AppVet.services;

import br.com.diego.AppVet.models.Endereco;
import br.com.diego.AppVet.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public Object save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}
