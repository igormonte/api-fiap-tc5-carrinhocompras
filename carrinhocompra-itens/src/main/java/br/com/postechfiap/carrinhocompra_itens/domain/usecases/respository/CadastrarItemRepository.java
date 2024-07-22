package br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository;

import br.com.postechfiap.carrinhocompra_itens.domain.entity.Item;

public interface CadastrarItemRepository {
    Item executar(Item item);
}
