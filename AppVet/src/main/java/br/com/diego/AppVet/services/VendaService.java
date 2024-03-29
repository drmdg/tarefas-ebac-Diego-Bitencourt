package br.com.diego.AppVet.services;

import br.com.diego.AppVet.models.Venda;
import br.com.diego.AppVet.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class VendaService {
    @Autowired
    VendaRepository vendaRepository;

    public Object save(Venda venda) {
        return vendaRepository.save(venda);
    }

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public Venda getClienteById(UUID id) {
        return vendaRepository.getClienteById(id);
    }
}
