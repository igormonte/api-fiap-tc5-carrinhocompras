package br.com.postechfiap.carrinhocompra_itens.domain.usecases;

import br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository.RemoverItemRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

public class RemoverItemUseCaseImpl implements RemoverItemUseCase {

    private final RemoverItemRepository removerItemRepository;

    public RemoverItemUseCaseImpl(RemoverItemRepository removerItemRepository) {
        this.removerItemRepository = removerItemRepository;
    }

    @Override
    public void executar(UUID id) {
        this.removerItemRepository.executar(id);
    }
}
