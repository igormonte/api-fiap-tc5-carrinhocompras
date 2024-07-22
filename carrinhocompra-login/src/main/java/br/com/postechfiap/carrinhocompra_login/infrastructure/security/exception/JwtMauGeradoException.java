package br.com.postechfiap.carrinhocompra_login.infrastructure.security.exception;

public class JwtMauGeradoException extends RuntimeException {

    public JwtMauGeradoException() {
        super();
    }

    public JwtMauGeradoException(String message) {
        super(message);
    }

}
