package br.com.postechfiap.carrinhocompra_itens.domain.usecases;

import br.com.postechfiap.carrinhocompra_itens.domain.entity.Item;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository.EditarItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

public class EditarItemUseCaseImpl implements EditarItemUseCase {

    private final EditarItemRepository editarItemRepository;

    public EditarItemUseCaseImpl(EditarItemRepository editarItemRepository) {
        this.editarItemRepository = editarItemRepository;
    }

    @Override
    public Item executar(Item item) {
        return editarItemRepository.executar(item);
    }
}

