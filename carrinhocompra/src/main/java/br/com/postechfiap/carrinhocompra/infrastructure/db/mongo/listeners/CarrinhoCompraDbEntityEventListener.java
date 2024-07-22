package br.com.postechfiap.carrinhocompra.infrastructure.db.mongo.listeners;

import br.com.postechfiap.carrinhocompra.infrastructure.db.mongo.entity.CarrinhoCompraDbEntity;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

import java.util.UUID;

public class CarrinhoCompraDbEntityEventListener extends AbstractMongoEventListener<CarrinhoCompraDbEntity> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<CarrinhoCompraDbEntity> event) {

        super.onBeforeConvert(event);
        CarrinhoCompraDbEntity entity = event.getSource();

        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID());
        }
    }
}