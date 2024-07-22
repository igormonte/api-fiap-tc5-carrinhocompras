package br.com.postechfiap.carrinhocompra_itens.application.dto;

import java.math.BigDecimal;

public record CriarItemDto
    (String nome,
    String descricao,
    String categoria,
    BigDecimal preco,
    String urlImagem) {
}
