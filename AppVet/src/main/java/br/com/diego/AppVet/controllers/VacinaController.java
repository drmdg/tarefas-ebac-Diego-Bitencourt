package br.com.diego.AppVet.controllers;

import br.com.diego.AppVet.dtos.VacinaDto;
import br.com.diego.AppVet.models.Animal;
import br.com.diego.AppVet.models.Vacina;
import br.com.diego.AppVet.services.AnimalService;
import br.com.diego.AppVet.services.VacinaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacina")
public class VacinaController {


    @Autowired
    VacinaService vacinaService;
    @Autowired
    AnimalService animalService;

    @PostMapping
    public ResponseEntity<Object> saveVacina(@RequestBody VacinaDto vacinaDto){
        Vacina vacina= new Vacina();
        BeanUtils.copyProperties(vacinaDto,vacina);
        Animal animal = animalService.getAnimalById(vacinaDto.animalId());
        animal.addVacina(vacina);
        animalService.save(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body("Vacina Adicionada");

    }


    @GetMapping
    public ResponseEntity<List<Vacina>> getAllVacinas(){
        return ResponseEntity.status(HttpStatus.OK).body(vacinaService.findAll());
    }

}
