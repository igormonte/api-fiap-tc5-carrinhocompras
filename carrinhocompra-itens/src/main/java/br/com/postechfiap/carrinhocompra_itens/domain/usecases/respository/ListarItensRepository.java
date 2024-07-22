package br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository;

import br.com.postechfiap.carrinhocompra_itens.domain.entity.Item;

import java.util.List;
import java.util.UUID;

public interface ListarItensRepository {
    List<Item> todos();

   Item porId(UUID id);
}
