package br.com.postechfiap.carrinhocompra_itens.infrastructure.application.config;

import br.com.postechfiap.carrinhocompra_itens.domain.usecases.*;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository.CadastrarItemRepository;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository.EditarItemRepository;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository.ListarItensRepository;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository.RemoverItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DomainConfig {

    @Bean
    CadastrarItemUseCase getCadastrarItemUseCase(
            CadastrarItemRepository cadastrarItemRepository
    ) {
        return new CadastrarItemUseCaseImpl(cadastrarItemRepository);
    }
    @Bean
    EditarItemUseCase getEditarItemUseCase(
            EditarItemRepository editarItemRepository) {
        return new EditarItemUseCaseImpl(editarItemRepository);
    }
    @Bean
    ListarItensUseCase getListarItensUseCase(
            ListarItensRepository listarItensRepository
    ) {
        return new ListarItensUseCaseImpl(listarItensRepository);
    }
    @Bean
    RemoverItemUseCase getRemoverItemUseCase(
            RemoverItemRepository removerItemRepository
    ) {
        return new RemoverItemUseCaseImpl(removerItemRepository);
    }

}
