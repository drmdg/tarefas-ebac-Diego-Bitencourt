package br.com.diego.AppVet.dtos;

import br.com.diego.AppVet.models.Endereco;

import java.util.UUID;

public record ClienteDto(String nome, String cpf, Endereco endereco ) {
}
