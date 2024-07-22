package br.com.postechfiap.carrinhocompra.infrastructure.itens.login.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemDto (
    UUID id,
    String nome,
    String descricao,
    String categoria,
    BigDecimal preco,
    String urlImagem
) {
}
