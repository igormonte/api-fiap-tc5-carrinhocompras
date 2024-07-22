package br.com.postechfiap.carrinhocompra.infrastructure.application.config;

import br.com.postechfiap.carrinhocompra.domain.usecases.*;
import br.com.postechfiap.carrinhocompra.domain.usecases.repository.AdicionarItemAoCarrinhoRepository;
import br.com.postechfiap.carrinhocompra.domain.usecases.repository.FinalizarCompraRepository;
import br.com.postechfiap.carrinhocompra.domain.usecases.repository.RemoverItemDoCarrinhoRepository;
import br.com.postechfiap.carrinhocompra.domain.usecases.repository.VisualizarCarrinhoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DomainConfig {

    @Bean RemoverItemDoCarrinhoUseCase getRemoverItemDoCarrinhoUseCase(
            RemoverItemDoCarrinhoRepository removerItemDoCarrinhoRepository
    ) {
        return new RemoverItemDoCarrinhoUseCaseImpl(removerItemDoCarrinhoRepository);
    }
    @Bean FinalizarCompraUseCase getFinalizarCompraUseCase(
            FinalizarCompraRepository finalizarCompraRepository
    ) {
        return new FinalizarCompraUseCaseImpl(finalizarCompraRepository);
    }
    @Bean
    AdicionarItemAoCarrinhoUseCase getAdicionarItemAoCarrinhoUseCase(
            AdicionarItemAoCarrinhoRepository adicionarItemAoCarrinhoRepository
    ) {
        return new AdicionarItemAoCarrinhoUseCaseImpl(adicionarItemAoCarrinhoRepository);
    }
    @Bean
    VisualizarCarrinhoUseCase getVisualizarCarrinhoUseCase(
            VisualizarCarrinhoRepository visualizarCarrinhoRepository
    ) {
        return new VisualizarCarrinhoUseCaseImpl(visualizarCarrinhoRepository);
    }

}
