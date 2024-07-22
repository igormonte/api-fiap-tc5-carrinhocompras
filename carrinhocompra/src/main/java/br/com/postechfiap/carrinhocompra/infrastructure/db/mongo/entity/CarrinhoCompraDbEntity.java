package br.com.postechfiap.carrinhocompra.infrastructure.db.mongo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@Data
@Document("trajeto")
public class CarrinhoCompraDbEntity {

    @MongoId
    private UUID id;
    private UUID idUsuario;
    private List<ItemDbEntity> itens;
    private BigDecimal total;

}
