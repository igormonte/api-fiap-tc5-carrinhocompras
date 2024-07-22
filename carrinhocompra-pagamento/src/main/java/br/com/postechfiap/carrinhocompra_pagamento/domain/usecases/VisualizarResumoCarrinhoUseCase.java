package br.com.postechfiap.carrinhocompra_pagamento.domain.usecases;

import br.com.postechfiap.carrinhocompra_pagamento.domain.carrinho.entity.CarrinhoCompra;

import java.util.UUID;

public interface VisualizarResumoCarrinhoUseCase {
    public CarrinhoCompra executar(String autorizacao);

}
