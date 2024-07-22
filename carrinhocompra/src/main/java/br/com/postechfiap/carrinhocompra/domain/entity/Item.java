package br.com.postechfiap.carrinhocompra.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Item {
    private UUID idItem;
    private Integer quantidade;
    private BigDecimal preco;

    public Item(UUID idItem, Integer quantidade, BigDecimal preco) {
        this.idItem = idItem;
        this.quantidade = quantidade;
        this.preco = preco;
    }
}
