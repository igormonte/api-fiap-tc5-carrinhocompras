package br.com.postechfiap.carrinhocompra_itens.domain.usecases;

import br.com.postechfiap.carrinhocompra_itens.domain.entity.Item;

import java.util.UUID;

public interface EditarItemUseCase {
    public Item executar(Item item) ;
}
