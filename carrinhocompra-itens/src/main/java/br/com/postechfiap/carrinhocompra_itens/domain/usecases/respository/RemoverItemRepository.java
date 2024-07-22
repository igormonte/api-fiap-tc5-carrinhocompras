package br.com.postechfiap.carrinhocompra_itens.domain.usecases.respository;

import java.util.UUID;

public interface RemoverItemRepository {
    void executar(UUID id);
}
