package br.com.postechfiap.carrinhocompra_itens.infrastructure.application.config;

import br.com.postechfiap.carrinhocompra_itens.application.gateway.CadastrarItemDbGateway;
import br.com.postechfiap.carrinhocompra_itens.application.gateway.EditarItemDbGateway;
import br.com.postechfiap.carrinhocompra_itens.application.gateway.ListarItensDbGateway;
import br.com.postechfiap.carrinhocompra_itens.application.gateway.RemoverItemDbGateway;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository.CadastrarItemRepository;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository.EditarItemRepository;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository.ListarItensRepository;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository.RemoverItemRepository;
import br.com.postechfiap.carrinhocompra_itens.infrastructure.db.repository.ItemRepository;
import br.com.postechfiap.carrinhocompra_itens.infrastructure.mapstruct.mapper.ItemMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfig {

    @Bean
    CadastrarItemRepository getCadastrarItemRepository(
            ItemRepository itemRepository,
            ItemMapper itemMapper) {
        return new CadastrarItemDbGateway(itemRepository,itemMapper);
    }
    @Bean
    EditarItemRepository getEditarItemRepository(
            ItemRepository itemRepository,
            ItemMapper itemMapper) {
        return new EditarItemDbGateway(itemRepository,itemMapper);
    }
    @Bean
    ListarItensRepository getListarItensRepository(
            ItemRepository itemRepository,
            ItemMapper itemMapper) {
        return new ListarItensDbGateway(itemRepository,itemMapper);
    }
    @Bean
    RemoverItemRepository getRemoverItemRepository(
            ItemRepository itemRepository) {
        return new RemoverItemDbGateway(itemRepository);
    }

}
