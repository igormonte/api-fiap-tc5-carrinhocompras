package br.com.postechfiap.carrinhocompra.infrastructure.db.mongo.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ItemDbEntity {
    private UUID idItem;
    private Integer quantidade;
    private BigDecimal preco;
}
