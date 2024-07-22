package br.com.postechfiap.carrinhocompra.infrastructure.security.exception;

public class UsuarioLogadoNaoEncontradoException extends RuntimeException {

    public UsuarioLogadoNaoEncontradoException() {
        super();
    }

    public UsuarioLogadoNaoEncontradoException(String message) {
        super(message);
    }

}
