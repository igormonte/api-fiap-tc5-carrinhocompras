package br.com.postechfiap.carrinhocompra_pagamento.infrastructure.carrinhocompra.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ItemDto {
    private UUID idItem;
    private Integer quantidade;
    private BigDecimal preco;

}
