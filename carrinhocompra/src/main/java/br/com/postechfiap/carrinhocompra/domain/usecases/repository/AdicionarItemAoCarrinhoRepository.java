package br.com.postechfiap.carrinhocompra.domain.usecases.repository;

import br.com.postechfiap.carrinhocompra.domain.entity.CarrinhoCompra;

import java.util.UUID;

public interface AdicionarItemAoCarrinhoRepository {
    CarrinhoCompra executar(UUID idCarrinho, UUID idItem, Integer quantidade);
}
