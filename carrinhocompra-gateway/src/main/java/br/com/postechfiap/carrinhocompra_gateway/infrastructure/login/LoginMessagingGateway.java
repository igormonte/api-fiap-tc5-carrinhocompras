package br.com.postechfiap.carrinhocompra_gateway.infrastructure.login;

import br.com.postechfiap.carrinhocompra_gateway.infrastructure.login.dto.CheckDto;
import br.com.postechfiap.carrinhocompra_gateway.infrastructure.security.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.GatewayHeader;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway
public interface LoginMessagingGateway {
    @Gateway(requestChannel = "checkMe",
            requestTimeout = 5000,
            headers = @GatewayHeader(name = MessageHeaders.REPLY_CHANNEL,
                    expression = "@nullChannel"))
    public ResponseEntity<CheckDto> checkMe(@Header(value = "Authorization") String authorization, Message<String> body);
    @Gateway(requestChannel = "me",
            requestTimeout = 5000,
            headers = @GatewayHeader(name = MessageHeaders.REPLY_CHANNEL,
                    expression = "@nullChannel"))
    public ResponseEntity<User> me(@Header(value = "Authorization") String authorization, Message<String> body);


}
