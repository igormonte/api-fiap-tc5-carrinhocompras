package br.com.postechfiap.carrinhocompra_login.infrastructure.security.service;

import br.com.postechfiap.carrinhocompra_login.domain.entity.Usuario;
import br.com.postechfiap.carrinhocompra_login.infrastructure.db.repository.UsuarioRepository;
import br.com.postechfiap.carrinhocompra_login.infrastructure.mapstruct.mapper.UsuarioMapper;
import br.com.postechfiap.carrinhocompra_login.infrastructure.security.entity.UserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final UsuarioRepository userRepository;
    private final UsuarioMapper usuarioMapper;

    public CustomUserDetailsService(UsuarioRepository userRepository, UsuarioMapper usuarioMapper) {
        this.userRepository = userRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        Usuario usuario = this.usuarioMapper.toUsuario(
                this.userRepository.findByEmail(email).orElse(null));
        if (usuario == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserDetail(usuario);
    }
}
