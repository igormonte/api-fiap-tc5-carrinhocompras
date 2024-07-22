package br.com.postechfiap.carrinhocompra_pagamento.application.gateway.exception;

public class CodigoVerificadorNaoPodeSerNuloException extends RuntimeException {

    public CodigoVerificadorNaoPodeSerNuloException() {
        super();
    }

    public CodigoVerificadorNaoPodeSerNuloException(String message) {
        super(message);
    }

}
