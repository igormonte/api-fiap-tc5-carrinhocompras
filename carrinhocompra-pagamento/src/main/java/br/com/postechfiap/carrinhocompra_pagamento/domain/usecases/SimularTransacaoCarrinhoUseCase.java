package br.com.postechfiap.carrinhocompra_pagamento.domain.usecases;

import br.com.postechfiap.carrinhocompra_pagamento.domain.carrinho.entity.CarrinhoCompra;
import br.com.postechfiap.carrinhocompra_pagamento.domain.pagamento.Pagamento;

import java.util.UUID;

public interface SimularTransacaoCarrinhoUseCase {

    public CarrinhoCompra executar(String autorizacao, Pagamento pagamento);
}
