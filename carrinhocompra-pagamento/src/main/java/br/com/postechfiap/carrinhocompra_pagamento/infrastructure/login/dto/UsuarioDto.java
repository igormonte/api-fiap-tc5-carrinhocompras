package br.com.postechfiap.carrinhocompra_pagamento.infrastructure.login.dto;

import java.util.UUID;

public record UsuarioDto(
        UUID id,
        String nome,
        String cpf,
        String email) {
}
