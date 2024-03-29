package br.com.diego.AppVet.dtos;

import br.com.diego.AppVet.models.Produto;

import java.math.BigDecimal;

public record ProdutoQuantidadeDto(Produto produto, Integer quantidade, BigDecimal valorTotal) {
}
