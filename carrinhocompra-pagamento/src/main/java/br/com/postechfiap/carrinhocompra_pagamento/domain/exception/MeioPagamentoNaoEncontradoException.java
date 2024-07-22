package br.com.postechfiap.carrinhocompra_pagamento.domain.exception;

public class MeioPagamentoNaoEncontradoException extends RuntimeException {

    public MeioPagamentoNaoEncontradoException() {
        super();
    }

    public MeioPagamentoNaoEncontradoException(String message) {
        super(message);
    }

}
