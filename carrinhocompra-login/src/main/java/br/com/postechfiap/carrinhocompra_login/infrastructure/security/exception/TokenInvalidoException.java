package br.com.postechfiap.carrinhocompra_login.infrastructure.security.exception;

public class TokenInvalidoException extends RuntimeException {

    public TokenInvalidoException() {
        super();
    }

    public TokenInvalidoException(String message) {
        super(message);
    }

}
