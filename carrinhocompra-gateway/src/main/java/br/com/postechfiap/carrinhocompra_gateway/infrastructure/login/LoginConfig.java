package br.com.postechfiap.carrinhocompra_gateway.infrastructure.login;


import br.com.postechfiap.carrinhocompra_gateway.infrastructure.login.dto.CheckDto;
import br.com.postechfiap.carrinhocompra_gateway.infrastructure.security.user.User;
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
@ConfigurationProperties(prefix = "carrinhocompra.login.api")
public class LoginConfig {

    @NotNull
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Bean
    public MessageChannel checkMe() {
        DirectChannel directChannel = new DirectChannel();
        directChannel.setFailover(false);
        return directChannel;
    }
    @Bean
    public MessageChannel me() {
        DirectChannel directChannel = new DirectChannel();
        directChannel.setFailover(false);
        return directChannel;
    }

    @Bean
    public IntegrationFlow checkMeFlow() {
        return IntegrationFlow.from("checkMe")
                .handle(Http.outboundGateway(String.format("%s/autenticacao/checkMe",this.url))
                        .charset("UTF-8")
                        .extractResponseBody(false)
                        .expectedResponseType(CheckDto.class)
                        .httpMethod(HttpMethod.GET))
                .log().bridge()
                .get();
    }
    @Bean
    public IntegrationFlow meFlow() {
        return IntegrationFlow.from("me")
                .handle(Http.outboundGateway(String.format("%s/autenticacao/me",this.url))
                        .charset("UTF-8")
                        .extractResponseBody(false)
                        .expectedResponseType(User.class)
                        .httpMethod(HttpMethod.GET))
                .log().bridge()
                .get();
    }

}
