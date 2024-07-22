package br.com.postechfiap.carrinhocompra_itens.domain.usecases;

import br.com.postechfiap.carrinhocompra_itens.domain.entity.Item;

public interface CadastrarItemUseCase {
    Item executar(Item item);
}
