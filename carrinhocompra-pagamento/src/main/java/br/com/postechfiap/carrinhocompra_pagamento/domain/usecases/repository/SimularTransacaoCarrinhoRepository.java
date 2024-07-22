package br.com.postechfiap.carrinhocompra_pagamento.domain.usecases.repository;

import br.com.postechfiap.carrinhocompra_pagamento.domain.carrinho.entity.CarrinhoCompra;
import br.com.postechfiap.carrinhocompra_pagamento.domain.pagamento.Pagamento;

import java.util.UUID;

public interface SimularTransacaoCarrinhoRepository {

    public CarrinhoCompra executar(String autorizacao, Pagamento pagamento);

}
