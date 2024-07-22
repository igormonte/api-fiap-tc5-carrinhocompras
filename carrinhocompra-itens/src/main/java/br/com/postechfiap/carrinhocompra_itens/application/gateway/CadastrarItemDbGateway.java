package br.com.postechfiap.carrinhocompra_itens.application.gateway;

import br.com.postechfiap.carrinhocompra_itens.domain.entity.Item;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.CadastrarItemUseCase;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository.CadastrarItemRepository;
import br.com.postechfiap.carrinhocompra_itens.infrastructure.db.repository.ItemRepository;
import br.com.postechfiap.carrinhocompra_itens.infrastructure.mapstruct.mapper.ItemMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CadastrarItemDbGateway implements CadastrarItemRepository {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public CadastrarItemDbGateway(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public Item executar(Item item) {
        log.info(item.toString());

        return this.itemMapper.toItem(
                itemRepository.save(
                        this.itemMapper.toItemDbEntity(item)));
    }
}

