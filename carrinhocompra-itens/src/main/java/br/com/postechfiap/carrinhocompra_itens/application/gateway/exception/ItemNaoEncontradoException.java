package br.com.postechfiap.carrinhocompra_itens.application.gateway.exception;

public class ItemNaoEncontradoException extends RuntimeException {

    public  ItemNaoEncontradoException() {
        super();
    }

    public  ItemNaoEncontradoException(String message) {
        super(message);
    }

}
