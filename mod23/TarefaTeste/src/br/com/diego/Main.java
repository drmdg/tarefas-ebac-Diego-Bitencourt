package br.com.diego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static List<Pessoa> main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        System.out.println("Entre com nome e sexo, ex: Jose-M,Maria-F,Marcos-M,Luciana-F");
        String dadosBrutos=args[0];
        String[] nomeEsexo= dadosBrutos.split(",");

        for(String st : nomeEsexo){
            String[] pessoa= st.split("-");
            Pessoa pessoa1 = new Pessoa(pessoa[0],pessoa[1]);
            pessoas.add(pessoa1);
        }
        System.out.println(pessoas);
        System.out.println("**************************************************");
        List<Pessoa> listaFeminina = pessoas.stream().filter(pessoa -> pessoa.getSexo().equalsIgnoreCase("F"))
                .collect(Collectors.toList());
        System.out.println("*** Lista Feminina ***");
        listaFeminina.forEach(pessoa -> System.out.println(pessoa));
        return listaFeminina;

    }
}