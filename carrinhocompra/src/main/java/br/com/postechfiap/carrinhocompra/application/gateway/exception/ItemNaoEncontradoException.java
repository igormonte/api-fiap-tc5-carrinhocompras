package br.com.postechfiap.carrinhocompra.application.gateway.exception;

public class ItemNaoEncontradoException extends RuntimeException {

    public ItemNaoEncontradoException() {
        super();
    }

    public ItemNaoEncontradoException(String message) {
        super(message);
    }

}
