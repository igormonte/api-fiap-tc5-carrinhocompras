package br.com.postechfiap.carrinhocompra_login.domain.usecases;

import br.com.postechfiap.carrinhocompra_login.domain.entity.Usuario;
import br.com.postechfiap.carrinhocompra_login.domain.usecases.repository.RegistrarUsuarioRepository;

public class RegistrarUsuarioUseCaseImpl implements RegistrarUsuarioUseCase {

    private final RegistrarUsuarioRepository registrarUsuarioRepository;

    public RegistrarUsuarioUseCaseImpl(RegistrarUsuarioRepository registrarUsuarioRepository) {
        this.registrarUsuarioRepository = registrarUsuarioRepository;
    }

    @Override
    public Usuario executar(Usuario usuario) {
        return this.registrarUsuarioRepository.executar(usuario);
    }

}
