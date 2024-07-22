package br.com.postechfiap.carrinhocompra_pagamento.domain.usecases.repository;

import br.com.postechfiap.carrinhocompra_pagamento.domain.carrinho.entity.CarrinhoCompra;

import java.util.UUID;

public interface VisualizarResumoCarrinhoRepository {
    public CarrinhoCompra executar(String autorizacao);

}
