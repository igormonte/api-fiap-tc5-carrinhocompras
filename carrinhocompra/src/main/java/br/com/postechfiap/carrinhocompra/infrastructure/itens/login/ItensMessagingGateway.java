package br.com.postechfiap.carrinhocompra.infrastructure.itens.login;

import br.com.postechfiap.carrinhocompra.infrastructure.itens.login.dto.ItemDto;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.GatewayHeader;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.UUID;

@MessagingGateway
public interface ItensMessagingGateway {
    @Gateway(requestChannel = "consultaItemPorId",
            requestTimeout = 5000,
            headers = @GatewayHeader(name = MessageHeaders.REPLY_CHANNEL,
                    expression = "@nullChannel"))
    public ResponseEntity<ItemDto> consultaItemPorId(UUID id);


}
