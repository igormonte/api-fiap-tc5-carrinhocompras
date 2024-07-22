package br.com.postechfiap.carrinhocompra_itens.domain.usecases;

import br.com.postechfiap.carrinhocompra_itens.domain.entity.Item;

import java.util.List;
import java.util.UUID;

public interface ListarItensUseCase {
    List<Item> todos();

    Item porId(UUID id);
}
