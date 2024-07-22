package br.com.postechfiap.carrinhocompra_itens.domain.usecases;

import br.com.postechfiap.carrinhocompra_itens.domain.entity.Item;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository.CadastrarItemRepository;
import org.springframework.stereotype.Service;

public class CadastrarItemUseCaseImpl implements CadastrarItemUseCase {

    private final CadastrarItemRepository cadastrarItemRepository;

    public CadastrarItemUseCaseImpl(CadastrarItemRepository cadastrarItemRepository) {
        this.cadastrarItemRepository = cadastrarItemRepository;
    }

    @Override
    public Item executar(Item item) {
        return cadastrarItemRepository.executar(item);
    }
}

