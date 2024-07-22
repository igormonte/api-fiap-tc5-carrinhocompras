package br.com.postechfiap.carrinhocompra.domain.usecases;

import br.com.postechfiap.carrinhocompra.domain.entity.CarrinhoCompra;

import java.util.UUID;

public interface AdicionarItemAoCarrinhoUseCase {
    CarrinhoCompra executar(UUID idCarrinho, UUID idItem, Integer quantidade);
}
