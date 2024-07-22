package br.com.postechfiap.carrinhocompra_pagamento.infrastructure.carrinhocompra;

import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.carrinhocompra.dto.CarrinhoCompraDto;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.GatewayHeader;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway
public interface CarrinhoCompraMessagingGateway {
    @Gateway(requestChannel = "visualizarCarrinho",
            requestTimeout = 5000,
            headers = @GatewayHeader(name = MessageHeaders.REPLY_CHANNEL,
                    expression = "@nullChannel"))
    public ResponseEntity<CarrinhoCompraDto> visualizarCarrinho(@Header(value = "Authorization") String authorization, Message<String> body);


}
