package br.com.postechfiap.carrinhocompra.infrastructure.login.dto;

import java.util.UUID;

public record UsuarioDto(
        UUID id,
        String nome,
        String email) {
}
