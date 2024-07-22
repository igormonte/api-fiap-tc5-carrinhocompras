package br.com.postechfiap.carrinhocompra_itens.application.gateway;

import br.com.postechfiap.carrinhocompra_itens.application.gateway.exception.ItemNaoEncontradoException;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.RemoverItemUseCase;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository.RemoverItemRepository;
import br.com.postechfiap.carrinhocompra_itens.infrastructure.db.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

public class RemoverItemDbGateway implements RemoverItemRepository {
    private final ItemRepository itemRepository;
    public RemoverItemDbGateway(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void executar(UUID id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
        } else {
            throw new ItemNaoEncontradoException("Item não encontrado");
        }
    }
}
