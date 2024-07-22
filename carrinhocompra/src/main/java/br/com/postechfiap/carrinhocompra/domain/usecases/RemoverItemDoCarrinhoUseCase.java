package br.com.postechfiap.carrinhocompra.domain.usecases;

import br.com.postechfiap.carrinhocompra.domain.entity.CarrinhoCompra;

import java.util.UUID;

public interface RemoverItemDoCarrinhoUseCase {
    CarrinhoCompra executar(UUID idUsuario, UUID idItem);
}
