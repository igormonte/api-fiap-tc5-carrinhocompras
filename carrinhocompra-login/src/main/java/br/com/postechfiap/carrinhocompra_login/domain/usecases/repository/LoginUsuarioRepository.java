package br.com.postechfiap.carrinhocompra_login.domain.usecases.repository;

import br.com.postechfiap.carrinhocompra_login.domain.entity.Usuario;

public interface LoginUsuarioRepository {
    String executar(String email, String senha);
}
