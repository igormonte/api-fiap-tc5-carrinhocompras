package br.com.postechfiap.carrinhocompra_itens.application.gateway;

import br.com.postechfiap.carrinhocompra_itens.application.gateway.exception.ItemNaoEncontradoException;
import br.com.postechfiap.carrinhocompra_itens.domain.entity.Item;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.EditarItemUseCase;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository.EditarItemRepository;
import br.com.postechfiap.carrinhocompra_itens.infrastructure.db.repository.ItemRepository;
import br.com.postechfiap.carrinhocompra_itens.infrastructure.mapstruct.mapper.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

public class EditarItemDbGateway implements EditarItemRepository {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public EditarItemDbGateway(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }


    @Override
    public Item executar(Item item) {
        Item itemExistente =
                this.itemMapper.toItem(
                        this.itemRepository.findById(item.getId()).orElse(null));

        if (itemExistente == null) {
            throw new ItemNaoEncontradoException("Item não encontrado");
        }

        itemExistente.setNome(item.getNome());
        itemExistente.setDescricao(item.getDescricao());
        itemExistente.setCategoria(item.getCategoria());
        itemExistente.setPreco(item.getPreco());
        itemExistente.setUrlImagem(item.getUrlImagem());
//        itemExistente.setQuantidade(item.getQuantidade());
        return this.itemMapper.toItem(
                this.itemRepository.save(
                        this.itemMapper.toItemDbEntity(item)));

    }
}

