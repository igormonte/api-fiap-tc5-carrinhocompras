package br.com.postechfiap.carrinhocompra_login.domain.usecases;

import br.com.postechfiap.carrinhocompra_login.domain.entity.Usuario;
import br.com.postechfiap.carrinhocompra_login.domain.usecases.repository.LoginUsuarioRepository;

public class LoginUsuarioUseCaseImpl implements LoginUsuarioUseCase {

    private final LoginUsuarioRepository loginUsuarioRepository;

    public LoginUsuarioUseCaseImpl(LoginUsuarioRepository loginUsuarioRepository) {
        this.loginUsuarioRepository = loginUsuarioRepository;
    }

    @Override
    public String executar(String email, String senha) {
        return this.loginUsuarioRepository.executar(email, senha);
    }

}
