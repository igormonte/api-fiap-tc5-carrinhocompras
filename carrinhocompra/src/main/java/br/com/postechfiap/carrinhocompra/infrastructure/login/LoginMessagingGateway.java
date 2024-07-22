package br.com.postechfiap.carrinhocompra.infrastructure.login;

import br.com.postechfiap.carrinhocompra.infrastructure.login.dto.UsuarioDto;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.GatewayHeader;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway
public interface LoginMessagingGateway {
    @Gateway(requestChannel = "me",
            requestTimeout = 5000,
            headers = @GatewayHeader(name = MessageHeaders.REPLY_CHANNEL,
                    expression = "@nullChannel"))
    public ResponseEntity<UsuarioDto> me(@Header(value = "Authorization") String authorization, Message<String> body);


}
