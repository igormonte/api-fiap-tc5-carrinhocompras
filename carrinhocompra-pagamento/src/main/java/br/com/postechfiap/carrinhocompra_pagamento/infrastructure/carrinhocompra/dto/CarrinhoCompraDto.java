package br.com.postechfiap.carrinhocompra_pagamento.infrastructure.carrinhocompra.dto;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record CarrinhoCompraDto (
    UUID id,
    UUID idUsuario,
    List<ItemDto> itens,
    BigDecimal total

) {

}
