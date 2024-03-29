package br.com.diego.AppVet.dtos;

import br.com.diego.AppVet.enums.Status;
import br.com.diego.AppVet.models.ProdutoQuantidade;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public record VendaDto(String codigo, UUID clienteId, Status status, Set<ProdutoQuantidade> produtos, BigDecimal valorTotal) {
}
