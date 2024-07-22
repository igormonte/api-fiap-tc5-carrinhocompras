package br.com.postechfiap.carrinhocompra_pagamento.infrastructure.security;

import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.login.LoginMessagingGateway;
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
