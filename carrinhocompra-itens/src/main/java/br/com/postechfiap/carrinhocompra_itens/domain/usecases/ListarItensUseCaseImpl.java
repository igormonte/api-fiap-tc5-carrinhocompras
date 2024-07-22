package br.com.postechfiap.carrinhocompra_itens.domain.usecases;

import br.com.postechfiap.carrinhocompra_itens.domain.entity.Item;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository.ListarItensRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public class ListarItensUseCaseImpl implements ListarItensUseCase {

    private final ListarItensRepository listarItensRepository;

    public ListarItensUseCaseImpl(ListarItensRepository listarItensRepository) {
        this.listarItensRepository = listarItensRepository;
    }

    @Override
    public List<Item> todos() {
        return listarItensRepository.todos();
    }

    @Override
    public Item porId(UUID id) {
        return listarItensRepository.porId(id);
    }
}
