package br.com.postechfiap.carrinhocompra_login.application.dto.request;

import br.com.postechfiap.carrinhocompra_login.domain.entity.Role;

import java.util.UUID;

public record CriarUsuarioDto(
        String cpf,
        String nome,
        String senha,
        String email,
        Role role) {
}
