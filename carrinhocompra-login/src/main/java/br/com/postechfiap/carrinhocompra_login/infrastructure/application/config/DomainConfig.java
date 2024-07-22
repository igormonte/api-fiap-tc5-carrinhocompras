package br.com.postechfiap.carrinhocompra_login.infrastructure.application.config;

import br.com.postechfiap.carrinhocompra_login.domain.usecases.LoginUsuarioUseCase;
import br.com.postechfiap.carrinhocompra_login.domain.usecases.LoginUsuarioUseCaseImpl;
import br.com.postechfiap.carrinhocompra_login.domain.usecases.RegistrarUsuarioUseCase;
import br.com.postechfiap.carrinhocompra_login.domain.usecases.RegistrarUsuarioUseCaseImpl;
import br.com.postechfiap.carrinhocompra_login.domain.usecases.repository.LoginUsuarioRepository;
import br.com.postechfiap.carrinhocompra_login.domain.usecases.repository.RegistrarUsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DomainConfig {

    @Bean
    LoginUsuarioUseCase getLoginUsuarioUseCase(
            LoginUsuarioRepository loginUsuarioRepository
    ) {
        return new LoginUsuarioUseCaseImpl(loginUsuarioRepository);
    }

    @Bean
    RegistrarUsuarioUseCase getRegistrarUsuarioUseCase(
            RegistrarUsuarioRepository registrarUsuarioRepository
    ) {
        return new RegistrarUsuarioUseCaseImpl(registrarUsuarioRepository);
    }

}
