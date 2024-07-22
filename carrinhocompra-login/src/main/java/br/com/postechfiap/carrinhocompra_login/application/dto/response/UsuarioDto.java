package br.com.postechfiap.carrinhocompra_login.application.dto.response;

import br.com.postechfiap.carrinhocompra_login.domain.entity.Role;
import lombok.Data;

import java.util.List;
import java.util.UUID;

public record UsuarioDto (
        UUID id,
        String cpf,
        String nome,
        String email,
        Role role) {
}
