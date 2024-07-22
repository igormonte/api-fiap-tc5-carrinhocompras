package br.com.postechfiap.carrinhocompra_pagamento.application.gateway.exception;

public class NumeroParcelasInvalidasException extends RuntimeException {

    public NumeroParcelasInvalidasException() {
        super();
    }

    public NumeroParcelasInvalidasException(String message) {
        super(message);
    }

}
