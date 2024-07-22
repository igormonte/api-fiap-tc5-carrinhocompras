package br.com.postechfiap.carrinhocompra_login.domain.usecases;

import br.com.postechfiap.carrinhocompra_login.domain.entity.Usuario;

public interface RegistrarUsuarioUseCase {
    Usuario executar(Usuario usuario);
}
