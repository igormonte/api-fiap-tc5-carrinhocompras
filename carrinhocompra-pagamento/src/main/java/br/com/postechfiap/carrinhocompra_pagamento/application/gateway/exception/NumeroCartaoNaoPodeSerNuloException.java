package br.com.postechfiap.carrinhocompra_pagamento.application.gateway.exception;

public class NumeroCartaoNaoPodeSerNuloException extends RuntimeException {

    public NumeroCartaoNaoPodeSerNuloException() {
        super();
    }

    public NumeroCartaoNaoPodeSerNuloException(String message) {
        super(message);
    }

}
