package br.com.postechfiap.carrinhocompra.infrastructure.security;

import br.com.postechfiap.carrinhocompra.infrastructure.login.LoginMessagingGateway;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {

    @Bean
    protected RemoteSecurityContextService<?> getRemoteSecurityContextService(
            LoginMessagingGateway loginMessagingGateway) {
        return new RemoteSecurityContextServiceImpl(loginMessagingGateway);
    }

}
