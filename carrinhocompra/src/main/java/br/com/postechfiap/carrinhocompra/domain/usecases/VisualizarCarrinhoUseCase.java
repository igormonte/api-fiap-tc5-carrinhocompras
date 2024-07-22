package br.com.postechfiap.carrinhocompra.domain.usecases;

import br.com.postechfiap.carrinhocompra.domain.entity.CarrinhoCompra;

import java.util.UUID;

public interface VisualizarCarrinhoUseCase {
    CarrinhoCompra executar(UUID idUsuario);
}
