package br.com.postechfiap.carrinhocompra_pagamento.domain.carrinho.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Item {
    private UUID idItem;
    private Integer quantidade;
    private BigDecimal preco;
    private BigDecimal total;

    void calculaTotal() {

        this.total = preco.multiply(BigDecimal.valueOf(quantidade));

    }

}
