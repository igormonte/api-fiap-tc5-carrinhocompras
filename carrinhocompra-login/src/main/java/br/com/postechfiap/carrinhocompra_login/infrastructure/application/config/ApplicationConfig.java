package br.com.postechfiap.carrinhocompra_login.infrastructure.application.config;

import br.com.postechfiap.carrinhocompra_login.application.gateway.LoginUsuarioAuthGateway;
import br.com.postechfiap.carrinhocompra_login.application.gateway.RegistrarUsuarioDbGateway;
import br.com.postechfiap.carrinhocompra_login.domain.usecases.repository.LoginUsuarioRepository;
import br.com.postechfiap.carrinhocompra_login.domain.usecases.repository.RegistrarUsuarioRepository;
import br.com.postechfiap.carrinhocompra_login.infrastructure.db.repository.UsuarioRepository;
import br.com.postechfiap.carrinhocompra_login.infrastructure.mapstruct.mapper.UsuarioMapper;
import br.com.postechfiap.carrinhocompra_login.infrastructure.security.service.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfig {

    @Bean
    LoginUsuarioRepository getLoginUsuarioRepository(
            AuthenticationManager authenticationManager,
            TokenService tokenService,
            UsuarioRepository usuarioRepository,
            UsuarioMapper usuarioMapper
    ) {
        return new LoginUsuarioAuthGateway(
                authenticationManager,
                tokenService,
                usuarioRepository,
                usuarioMapper
        );
    }

    @Bean
    RegistrarUsuarioRepository getRegistrarUsuarioRepository(
            UsuarioRepository usuarioRepository,
            UsuarioMapper usuarioMapper,
            PasswordEncoder passwordEncode
    ) {
        return new RegistrarUsuarioDbGateway(
                usuarioRepository,
                usuarioMapper,
                passwordEncode
        );
    }

}
