package br.com.postechfiap.carrinhocompra.infrastructure.db.mongo.listeners;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MongoListenersConfiguration {
    @Bean
    public CarrinhoCompraDbEntityEventListener getClienteDbEntityEventListener() {
        return new CarrinhoCompraDbEntityEventListener();
    }

}
