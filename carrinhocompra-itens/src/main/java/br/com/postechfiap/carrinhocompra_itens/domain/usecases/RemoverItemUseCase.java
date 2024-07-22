package br.com.postechfiap.carrinhocompra_itens.domain.usecases;

import java.util.UUID;

public interface RemoverItemUseCase {
    void executar(UUID id);
}
