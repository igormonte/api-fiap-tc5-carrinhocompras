package br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository;

import br.com.postechfiap.carrinhocompra_itens.domain.entity.Item;

import java.util.UUID;

public interface EditarItemRepository {

    public Item executar(Item item) ;
}
