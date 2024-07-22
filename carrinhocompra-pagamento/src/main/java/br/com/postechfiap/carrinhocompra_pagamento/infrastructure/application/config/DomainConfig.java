package br.com.postechfiap.carrinhocompra_pagamento.infrastructure.application.config;

import br.com.postechfiap.carrinhocompra_pagamento.application.gateway.*;
import br.com.postechfiap.carrinhocompra_pagamento.domain.usecases.SimularTransacaoCarrinhoUseCase;
import br.com.postechfiap.carrinhocompra_pagamento.domain.usecases.SimularTransacaoCarrinhoUseCaseImpl;
import br.com.postechfiap.carrinhocompra_pagamento.domain.usecases.VisualizarResumoCarrinhoUseCase;
import br.com.postechfiap.carrinhocompra_pagamento.domain.usecases.VisualizarResumoCarrinhoUseCaseImpl;
import br.com.postechfiap.carrinhocompra_pagamento.domain.usecases.repository.*;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.carrinhocompra.CarrinhoCompraMessagingGateway;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.login.LoginMessagingGateway;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.mapstruct.mapper.CarrinhoCompraMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DomainConfig {

    @Bean
    SimularTransacaoCarrinhoUseCase getSimularTransacaoCarrinhoUseCase(
            SimularTransacaoCarrinhoBoletoRepository simularTransacaoCarrinhoBoletoRepository,
            SimularTransacaoCarrinhoCreditoRepository simularTransacaoCarrinhoCreditoRepository,
            SimularTransacaoCarrinhoDebitoRepository simularTransacaoCarrinhoDebitoRepository,
            SimularTransacaoCarrinhoPixRepository simularTransacaoCarrinhoPixRepository
    ) {
        return new SimularTransacaoCarrinhoUseCaseImpl(
                simularTransacaoCarrinhoBoletoRepository,
                simularTransacaoCarrinhoCreditoRepository,
                simularTransacaoCarrinhoDebitoRepository,
                simularTransacaoCarrinhoPixRepository
        );

    }


    @Bean
    VisualizarResumoCarrinhoUseCase getVisualizarResumoCarrinhoUseCase(
            VisualizarResumoCarrinhoRepository visualizarResumoCarrinhoRepository
    ) {
        return new VisualizarResumoCarrinhoUseCaseImpl(
                visualizarResumoCarrinhoRepository);
    }

    @Bean
    SimularTransacaoCarrinhoBoletoRepository getSimularTransacaoCarrinhoBoletoRepository(
            CarrinhoCompraMessagingGateway carrinhoCompraMessagingGateway,
            CarrinhoCompraMapper carrinhoCompraMapper,
            LoginMessagingGateway loginMessagingGateway
    ) {
        return new SimularTransacaoCarrinhoBoletoGateway(
                carrinhoCompraMessagingGateway,
                carrinhoCompraMapper,
                loginMessagingGateway);
    }

    @Bean
    VisualizarResumoCarrinhoRepository getVisualizarResumoCarrinhoRepository(
            CarrinhoCompraMessagingGateway carrinhoCompraMessagingGateway,
            CarrinhoCompraMapper carrinhoCompraMapper
    ) {
        return new VisualizarResumoCarrinhoGateway(
                carrinhoCompraMessagingGateway,
                carrinhoCompraMapper
        );
    }

    @Bean
    SimularTransacaoCarrinhoCreditoRepository getSimularTransacaoCarrinhoCreditoRepository(
            CarrinhoCompraMessagingGateway carrinhoCompraMessagingGateway,
            CarrinhoCompraMapper carrinhoCompraMapper,
            LoginMessagingGateway loginMessagingGateway) {
        return new SimularTransacaoCarrinhoCreditoGateway(
                carrinhoCompraMessagingGateway,
                carrinhoCompraMapper,
                loginMessagingGateway);
    }
    @Bean
    SimularTransacaoCarrinhoDebitoRepository getSimularTransacaoCarrinhoDebitoRepository(
            CarrinhoCompraMessagingGateway carrinhoCompraMessagingGateway,
            CarrinhoCompraMapper carrinhoCompraMapper,
            LoginMessagingGateway loginMessagingGateway) {
        return new SimularTransacaoCarrinhoDebitoGateway(
                carrinhoCompraMessagingGateway,
                carrinhoCompraMapper,
                loginMessagingGateway);
    }
    @Bean
    SimularTransacaoCarrinhoPixRepository getSimularTransacaoCarrinhoPixRepository(
            CarrinhoCompraMessagingGateway carrinhoCompraMessagingGateway,
            CarrinhoCompraMapper carrinhoCompraMapper,
            LoginMessagingGateway loginMessagingGateway) {
        return new SimularTransacaoCarrinhoPixGateway(
                carrinhoCompraMessagingGateway,
                carrinhoCompraMapper,
                loginMessagingGateway);
    }

}
