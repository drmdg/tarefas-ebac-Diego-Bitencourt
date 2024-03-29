package br.com.diego.AppVet.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record VacinaDto(String nome, String codigo, String descricao, BigDecimal valor, UUID animalId) {
}
