package br.com.postechfiap.carrinhocompra_login.application.gateway;

import br.com.postechfiap.carrinhocompra_login.application.gateway.exception.EmailJaCadastradoException;
import br.com.postechfiap.carrinhocompra_login.domain.entity.Usuario;
import br.com.postechfiap.carrinhocompra_login.domain.usecases.repository.RegistrarUsuarioRepository;
import br.com.postechfiap.carrinhocompra_login.infrastructure.db.repository.UsuarioRepository;
import br.com.postechfiap.carrinhocompra_login.infrastructure.mapstruct.mapper.UsuarioMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
public class RegistrarUsuarioDbGateway implements RegistrarUsuarioRepository {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public RegistrarUsuarioDbGateway(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuario executar(Usuario usuario) {
        if (this.usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new EmailJaCadastradoException("Email já está em uso");
        }

        log.info(usuario.toString());

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return this.usuarioMapper.toUsuario(
                this.usuarioRepository.save(
                        this.usuarioMapper.toUsuarioDbEntity(usuario)));
    }

}
