package br.com.diego.testes;

import org.junit.Assert;
import org.junit.Test;
import br.com.diego.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestesTest {

    @Test
    public void primeiroTeste(){
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Maria","F"));
        pessoas.add(new Pessoa("Joana","F"));
        pessoas.add(new Pessoa("Luana","F"));

        Assert.assertEquals(Main.main(new String[]{"José-M,Maria-F,Joana-F,Marcos-M,Luana-F"}),pessoas);
    }

    @Test
    public void testeComListaSomenteFeminina(){
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Carla","F"));
        pessoas.add(new Pessoa("Maria","F"));
        pessoas.add(new Pessoa("Joana","F"));
        pessoas.add(new Pessoa("Marcela","F"));
        pessoas.add(new Pessoa("Luana","F"));

        Assert.assertEquals(Main.main(new String[]{"Carla-F,Maria-F,Joana-F,Marcela-F,Luana-F"}),pessoas);
    }

    @Test
    public void testeComListaSomenteMasculina(){
        List<Pessoa> pessoas = new ArrayList<>();
        Assert.assertEquals(Main.main(new String[]{"Joao-M,Marcos-M,Mario-M,Ancelmo-M,Lucas-M"}),pessoas);
    }


}