package br.com.postechfiap.carrinhocompra_pagamento.application.gateway.exception;

public class CarrinhoNaoEncontradoException extends RuntimeException {

    public CarrinhoNaoEncontradoException() {
        super();
    }

    public CarrinhoNaoEncontradoException(String message) {
        super(message);
    }

}
