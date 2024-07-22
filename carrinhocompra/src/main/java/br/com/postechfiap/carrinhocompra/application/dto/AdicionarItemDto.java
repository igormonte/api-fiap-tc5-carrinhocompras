package br.com.postechfiap.carrinhocompra.application.dto;

import java.util.UUID;

public record AdicionarItemDto(UUID idItem, Integer quantidade) {
}
