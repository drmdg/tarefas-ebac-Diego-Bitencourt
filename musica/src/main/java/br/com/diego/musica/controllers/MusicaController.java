package br.com.diego.musica.controllers;

import br.com.diego.musica.Dtos.MusicaDto;
import br.com.diego.musica.enums.DificuldadeMusica;
import br.com.diego.musica.models.Musica;
import br.com.diego.musica.services.MusicaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/musica")
public class MusicaController {


    @Autowired
    MusicaService musicaService;

    @PostMapping
    public ResponseEntity<Object> saveMusica(@RequestBody MusicaDto musicaDto){
            Musica musica= new Musica();
            BeanUtils.copyProperties(musicaDto,musica);
            return ResponseEntity.status(HttpStatus.CREATED).body(musicaService.save(musica));

    }


    @GetMapping("/nome/{nomeDaMusica}")
    public ResponseEntity<List<Musica>> getMusicaBateria(@PathVariable(value = "nomeDaMusica") String nomeDaMusica ){
        return ResponseEntity.status(HttpStatus.OK).body(musicaService.findMusicaByNome(nomeDaMusica));
    }

    @GetMapping
    public ResponseEntity<List<Musica>> getAllMusicas(){
        return ResponseEntity.status(HttpStatus.OK).body(musicaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getMusicaById(@PathVariable(value = "id") UUID id){
        Optional<Musica> musicaOptional = musicaService.findById(id);
        return musicaOptional.<ResponseEntity<Object>>map(musica -> ResponseEntity.status(HttpStatus.OK).body(musica)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Música não encontrada"));
    }

    @GetMapping("/bateria")
    public ResponseEntity<List<Musica>> getMusicaBateria(){
        return ResponseEntity.status(HttpStatus.OK).body(musicaService.findMusicasBateria());
    }
    @GetMapping("/violao")
    public ResponseEntity<List<Musica>> getMusicaViolao(){
        return ResponseEntity.status(HttpStatus.OK).body(musicaService.findMusicasViolao());
    }
    @GetMapping("/guitarra")
    public ResponseEntity<List<Musica>> getMusicaGuitarra(){
        return ResponseEntity.status(HttpStatus.OK).body(musicaService.findMusicasGuitarra());
    }

    @GetMapping("/guitarra/{dificuldadeMusica}")
    public ResponseEntity<List<Musica>> getMusicaGuitarraByDificuldade(@PathVariable(value = "dificuldadeMusica") String dificuldadeMusicaStr ){
        DificuldadeMusica dificuldadeMusica = DificuldadeMusica.valueOf(dificuldadeMusicaStr);
        return ResponseEntity.status(HttpStatus.OK).body(musicaService.findMusicasGuitarraDificuldade(dificuldadeMusica));
    }

    @GetMapping("/violao/{dificuldadeMusica}")
    public ResponseEntity<List<Musica>> getMusicaViolaoByDificuldade(@PathVariable(value = "dificuldadeMusica") String dificuldadeMusicaStr ){
        DificuldadeMusica dificuldadeMusica = DificuldadeMusica.valueOf(dificuldadeMusicaStr);
        return ResponseEntity.status(HttpStatus.OK).body(musicaService.findMusicasViolaoDificuldade(dificuldadeMusica));
    }

    @GetMapping("/bateria/{dificuldadeMusica}")
    public ResponseEntity<List<Musica>> getMusicaBateriaByDificuldade(@PathVariable(value = "dificuldadeMusica") String dificuldadeMusicaStr ){
        DificuldadeMusica dificuldadeMusica = DificuldadeMusica.valueOf(dificuldadeMusicaStr);
        return ResponseEntity.status(HttpStatus.OK).body(musicaService.findMusicasBateriaDificuldade(dificuldadeMusica));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMusica(@PathVariable(value = "id") UUID id){
        Optional<Musica> musicaOptional = musicaService.findById(id);
        if (!musicaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Musica não encontrada");
        }
        musicaService.delete(musicaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("DELETADA!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMusica(@PathVariable(value = "id") UUID id,
                                               @RequestBody MusicaDto musicaDto){
        Optional<Musica> musicaOptional = musicaService.findById(id);
        if (!musicaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Musica não encontrada");
        }
        var musica = musicaOptional.get();
        musica.setNomeMusica(musicaDto.nomeMusica());
        musica.setBanda(musicaDto.banda());
        musica.setLink(musicaDto.link());
        musica.setDificuldadeMusica(musicaDto.dificuldadeMusica());
        musica.setInstrumentoMusical(musicaDto.instrumentoMusical());
        return ResponseEntity.status(HttpStatus.OK).body(musicaService.save(musica));
    }
}
