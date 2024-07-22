package br.com.postechfiap.carrinhocompra.infrastructure.login;


import br.com.postechfiap.carrinhocompra.infrastructure.login.dto.UsuarioDto;
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

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
    @Bean
    public MessageChannel me() {
        DirectChannel directChannel = new DirectChannel();
        directChannel.setFailover(false);
        return directChannel;
    }
    @Bean
    public IntegrationFlow meFlow() {
        return IntegrationFlow.from("me")
                .handle(Http.outboundGateway(String.format("%s/autenticacao/me",this.url))
                        .charset("UTF-8")
                        .extractResponseBody(false)
                        .expectedResponseType(UsuarioDto.class)
                        .httpMethod(HttpMethod.GET))
                .log().bridge()
                .get();
    }

}
