package br.com.diego.AppVet.services;

import br.com.diego.AppVet.models.Vacina;
import br.com.diego.AppVet.repositories.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VacinaService {
    @Autowired
    VacinaRepository vacinaRepository;

    public Object save(Vacina vacina) {
        return vacinaRepository.save(vacina);
    }

    public List<Vacina> findAll() {
        return vacinaRepository.findAll();
    }

    public Vacina getVacinaById(UUID uuid) {
        return vacinaRepository.getVacinaById(uuid);
    }
}
