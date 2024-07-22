package br.com.postechfiap.carrinhocompra.infrastructure.security;

import br.com.postechfiap.carrinhocompra.infrastructure.login.LoginMessagingGateway;
import br.com.postechfiap.carrinhocompra.infrastructure.login.dto.UsuarioDto;
import br.com.postechfiap.carrinhocompra.infrastructure.security.exception.UsuarioLogadoNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Optional;

public class RemoteSecurityContextServiceImpl implements RemoteSecurityContextService<UsuarioDto> {

    private final LoginMessagingGateway loginMessagingGateway;

    public RemoteSecurityContextServiceImpl(LoginMessagingGateway loginMessagingGateway) {
        this.loginMessagingGateway = loginMessagingGateway;
    }

    @Override
    public Optional<UsuarioDto> getPrincipal(String token) {

        ResponseEntity<UsuarioDto> response;
        
        try {
            response = this.loginMessagingGateway.me(token,
                    MessageBuilder.withPayload("").build());


        } catch (Exception e) {
            throw new UsuarioLogadoNaoEncontradoException("Não foi possível encontrar o usuário logado.");
        }

        return Optional.ofNullable(response.getBody());
    }
}
