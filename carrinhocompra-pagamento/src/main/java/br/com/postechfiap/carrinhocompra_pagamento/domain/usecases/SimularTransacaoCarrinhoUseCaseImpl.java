package br.com.postechfiap.carrinhocompra_pagamento.domain.usecases;

import br.com.postechfiap.carrinhocompra_pagamento.domain.carrinho.entity.CarrinhoCompra;
import br.com.postechfiap.carrinhocompra_pagamento.domain.exception.MeioPagamentoNaoEncontradoException;
import br.com.postechfiap.carrinhocompra_pagamento.domain.pagamento.MeioPagamento;
import br.com.postechfiap.carrinhocompra_pagamento.domain.pagamento.Pagamento;
import br.com.postechfiap.carrinhocompra_pagamento.domain.usecases.repository.*;

import java.util.HashMap;
import java.util.UUID;

public class SimularTransacaoCarrinhoUseCaseImpl implements SimularTransacaoCarrinhoUseCase {

    private HashMap<MeioPagamento, SimularTransacaoCarrinhoRepository> simular = null;

    public SimularTransacaoCarrinhoUseCaseImpl(
            SimularTransacaoCarrinhoBoletoRepository simularTransacaoCarrinhoBoletoRepository,
            SimularTransacaoCarrinhoCreditoRepository simularTransacaoCarrinhoCreditoRepository,
            SimularTransacaoCarrinhoDebitoRepository simularTransacaoCarrinhoDebitoRepository,
            SimularTransacaoCarrinhoPixRepository simularTransacaoCarrinhoPixRepository

    ) {
        this.simular = new HashMap<>(){{
            put(MeioPagamento.BOLETO, simularTransacaoCarrinhoBoletoRepository);
            put(MeioPagamento.CREDITO, simularTransacaoCarrinhoCreditoRepository);
            put(MeioPagamento.DEBITO, simularTransacaoCarrinhoDebitoRepository);
            put(MeioPagamento.PIX, simularTransacaoCarrinhoPixRepository);
        }};

    }

    @Override
    public CarrinhoCompra executar(String autorizacao, Pagamento pagamento) {

        SimularTransacaoCarrinhoRepository simular =
                this.buscaSimulacao(pagamento.getMeioPagamento());

        CarrinhoCompra carrinhoCompra =
                simular.executar(autorizacao, pagamento);

        carrinhoCompra.calcularTotal();

        return carrinhoCompra;
    }

    private SimularTransacaoCarrinhoRepository buscaSimulacao(MeioPagamento meioPagamento) {

        if(!this.simular.containsKey(meioPagamento)) {
            throw new MeioPagamentoNaoEncontradoException("Não foi encontrado o meio de pagamento indicado.");
        }

        return this.simular.get(meioPagamento);

    }
}
