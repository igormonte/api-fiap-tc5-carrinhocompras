package br.com.postechfiap.carrinhocompra_pagamento.application.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemResponseDto (
    UUID idItem,
    Integer quantidade,
    BigDecimal preco,
    BigDecimal total
) {

}
