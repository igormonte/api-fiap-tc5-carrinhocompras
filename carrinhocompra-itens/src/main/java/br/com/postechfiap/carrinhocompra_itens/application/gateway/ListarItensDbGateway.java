package br.com.postechfiap.carrinhocompra_itens.application.gateway;

import br.com.postechfiap.carrinhocompra_itens.application.gateway.exception.ItemNaoEncontradoException;
import br.com.postechfiap.carrinhocompra_itens.domain.entity.Item;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository.ListarItensRepository;
import br.com.postechfiap.carrinhocompra_itens.infrastructure.db.repository.ItemRepository;
import br.com.postechfiap.carrinhocompra_itens.infrastructure.mapstruct.mapper.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public class ListarItensDbGateway implements ListarItensRepository {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ListarItensDbGateway(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }
    @Override
    public List<Item> todos() {
        return this.itemMapper.toItemList(
                this.itemRepository.findAll());
    }

    @Override
    public Item porId(UUID id) {
        return this.itemMapper.toItem(
                this.itemRepository.findById(id)
                        .orElseThrow(() -> new ItemNaoEncontradoException("Não foi encontrado para o id especificado.")));
    }
}
