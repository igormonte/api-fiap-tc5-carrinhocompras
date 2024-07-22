package br.com.postechfiap.carrinhocompra.infrastructure.itens.login;


import br.com.postechfiap.carrinhocompra.infrastructure.itens.login.dto.ItemDto;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Configuration
@ConfigurationProperties(prefix = "carrinhocompra.itens.api")
public class ItensConfig {

    @NotNull
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
    @Bean
    public MessageChannel consultaItemPorId() {
        DirectChannel directChannel = new DirectChannel();
        directChannel.setFailover(false);
        return directChannel;
    }
    @Bean
    public IntegrationFlow consultaItemPorIdFlow() {
        return IntegrationFlow.from("consultaItemPorId")
            .handle(
                    Http.outboundGateway( h-> String.format("%s/itens/id/{id}",this.url))
                            .uriVariable("id", Message::getPayload)
                            .charset("UTF-8")
                            .extractResponseBody(false)
                            .expectedResponseType(ItemDto.class)
                            .httpMethod(HttpMethod.GET))
            .log().bridge()
            .get();
    }

}
