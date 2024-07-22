package br.com.postechfiap.carrinhocompra_pagamento.domain.exception;

public class NumeroParcelasNaoPodeSerNuloException extends RuntimeException {

    public NumeroParcelasNaoPodeSerNuloException() {
        super();
    }

    public NumeroParcelasNaoPodeSerNuloException(String message) {
        super(message);
    }

}
