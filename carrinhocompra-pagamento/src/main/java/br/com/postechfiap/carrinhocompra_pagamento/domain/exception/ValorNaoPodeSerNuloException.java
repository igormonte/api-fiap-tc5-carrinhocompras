package br.com.postechfiap.carrinhocompra_pagamento.domain.exception;

public class ValorNaoPodeSerNuloException extends RuntimeException {

    public ValorNaoPodeSerNuloException() {
        super();
    }

    public ValorNaoPodeSerNuloException(String message) {
        super(message);
    }

}
