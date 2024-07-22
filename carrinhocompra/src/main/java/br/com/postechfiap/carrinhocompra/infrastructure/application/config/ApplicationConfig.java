package br.com.postechfiap.carrinhocompra.infrastructure.application.config;

import br.com.postechfiap.carrinhocompra.application.gateway.AdicionarItemAoCarrinhoDbGateway;
import br.com.postechfiap.carrinhocompra.application.gateway.RemoverItemDoCarrinhoDbGateway;
import br.com.postechfiap.carrinhocompra.application.gateway.VisualizarCarrinhoDbGateway;
import br.com.postechfiap.carrinhocompra.domain.usecases.repository.AdicionarItemAoCarrinhoRepository;
import br.com.postechfiap.carrinhocompra.domain.usecases.repository.RemoverItemDoCarrinhoRepository;
import br.com.postechfiap.carrinhocompra.domain.usecases.repository.VisualizarCarrinhoRepository;
import br.com.postechfiap.carrinhocompra.infrastructure.db.mongo.repository.CarrinhoCompraRepository;
import br.com.postechfiap.carrinhocompra.infrastructure.itens.login.ItensMessagingGateway;
import br.com.postechfiap.carrinhocompra.infrastructure.mapper.CarrinhoCompraMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfig {

    @Bean
    AdicionarItemAoCarrinhoRepository getAdicionarItemAoCarrinhoRepository(
            CarrinhoCompraRepository carrinhoCompraRepository,
            CarrinhoCompraMapper carrinhoCompraMapper,
            ItensMessagingGateway itensMessagingGateway
    ) {
        return new AdicionarItemAoCarrinhoDbGateway(
                carrinhoCompraRepository,
                carrinhoCompraMapper,
                itensMessagingGateway);
    }
    @Bean
    RemoverItemDoCarrinhoRepository getRemoverItemDoCarrinhoRepository(
            CarrinhoCompraRepository carrinhoCompraRepository,
            CarrinhoCompraMapper carrinhoCompraMapper
    ) {
        return new RemoverItemDoCarrinhoDbGateway(carrinhoCompraRepository, carrinhoCompraMapper);
    }
    @Bean
    VisualizarCarrinhoRepository getVisualizarCarrinhoRepository(
            CarrinhoCompraRepository carrinhoCompraRepository,
            CarrinhoCompraMapper carrinhoCompraMapper
    ) {
        return new VisualizarCarrinhoDbGateway(carrinhoCompraRepository, carrinhoCompraMapper);
    }

}
