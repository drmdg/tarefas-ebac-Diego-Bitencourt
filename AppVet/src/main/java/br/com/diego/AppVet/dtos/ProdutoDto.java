package br.com.diego.AppVet.dtos;

import java.math.BigDecimal;

    public record ProdutoDto(String codigo, String descricao, String nome, BigDecimal valor) {
}
