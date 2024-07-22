package br.com.postechfiap.carrinhocompra_login.infrastructure.security.filter;

import br.com.postechfiap.carrinhocompra_login.domain.entity.Usuario;
import br.com.postechfiap.carrinhocompra_login.infrastructure.db.repository.UsuarioRepository;
import br.com.postechfiap.carrinhocompra_login.infrastructure.mapstruct.mapper.UsuarioMapper;
import br.com.postechfiap.carrinhocompra_login.infrastructure.security.entity.UserDetail;
import br.com.postechfiap.carrinhocompra_login.infrastructure.security.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class TokenFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public TokenFilter(
            TokenService tokenService,
            UsuarioRepository usuarioRepository,
            UsuarioMapper usuarioMapper) {
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        if(token != null){
            String login = tokenService.validateToken(token);
            Usuario usuario = this.usuarioMapper.toUsuario(
                    this.usuarioRepository.findByEmail(login).orElse(null));

            UserDetail userDetail = new UserDetail(usuario);

            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
