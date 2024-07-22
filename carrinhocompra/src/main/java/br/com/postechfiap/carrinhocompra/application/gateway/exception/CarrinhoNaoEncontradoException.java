package br.com.postechfiap.carrinhocompra.application.gateway.exception;

public class CarrinhoNaoEncontradoException extends RuntimeException {

    public CarrinhoNaoEncontradoException() {
        super();
    }

    public CarrinhoNaoEncontradoException(String message) {
        super(message);
    }

}
