package br.com.postechfiap.carrinhocompra_pagamento.application.gateway.exception;

public class VencimentoNaoPodeSerNuloException extends RuntimeException {

    public VencimentoNaoPodeSerNuloException() {
        super();
    }

    public VencimentoNaoPodeSerNuloException(String message) {
        super(message);
    }

}
