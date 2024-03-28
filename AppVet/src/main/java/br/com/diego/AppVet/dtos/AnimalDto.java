package br.com.diego.AppVet.dtos;

import br.com.diego.AppVet.models.Cliente;

import java.util.UUID;

public record AnimalDto(String especie, Double idade, String nome, String raca, Cliente cliente) {
}
