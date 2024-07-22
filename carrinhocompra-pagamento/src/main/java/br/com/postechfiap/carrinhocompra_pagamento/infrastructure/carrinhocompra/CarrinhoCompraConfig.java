package br.com.postechfiap.carrinhocompra_pagamento.infrastructure.carrinhocompra;

import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.carrinhocompra.dto.CarrinhoCompraDto;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.MessageChannel;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Configuration
@ConfigurationProperties(prefix = "carrinhocompra.api")
public class CarrinhoCompraConfig {

    @NotNull
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    @Bean
    public MessageChannel visualizarCarrinho() {
        DirectChannel directChannel = new DirectChannel();
        directChannel.setFailover(false);
        return directChannel;
    }

    @Bean
    public IntegrationFlow visualizarCarrinhoFlow() {
        return IntegrationFlow.from("visualizarCarrinho")
                .handle(Http.outboundGateway(String.format("%s/carrinhocompra",this.url))
                        .charset("UTF-8")
                        .extractResponseBody(false)
                        .expectedResponseType(CarrinhoCompraDto.class)
                        .httpMethod(HttpMethod.GET))
                .log().bridge()
                .get();
    }

}
