package br.com.diego.AppVet.dtos;

import java.util.UUID;

public record AnimalDto(String especie, Double idade, String nome, String raca, UUID clienteFk) {
}
