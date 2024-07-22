package br.com.postechfiap.carrinhocompra_login.application.gateway;

import br.com.postechfiap.carrinhocompra_login.domain.usecases.repository.LoginUsuarioRepository;
import br.com.postechfiap.carrinhocompra_login.infrastructure.db.repository.UsuarioRepository;
import br.com.postechfiap.carrinhocompra_login.infrastructure.mapstruct.mapper.UsuarioMapper;
import br.com.postechfiap.carrinhocompra_login.infrastructure.security.entity.UserDetail;
import br.com.postechfiap.carrinhocompra_login.infrastructure.security.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@Slf4j
public class LoginUsuarioAuthGateway implements LoginUsuarioRepository {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public LoginUsuarioAuthGateway(
            AuthenticationManager authenticationManager,
            TokenService tokenService,
            UsuarioRepository usuarioRepository,
            UsuarioMapper usuarioMapper) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public String executar(String email, String senha) {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(email, senha);

        Authentication auth = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        return this.tokenService.generateToken((UserDetail) auth.getPrincipal());

    }

}
