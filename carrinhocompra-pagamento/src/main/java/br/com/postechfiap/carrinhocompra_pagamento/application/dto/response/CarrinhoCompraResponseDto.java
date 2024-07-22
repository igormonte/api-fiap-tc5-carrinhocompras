package br.com.postechfiap.carrinhocompra_pagamento.application.dto.response;

import br.com.postechfiap.carrinhocompra_pagamento.domain.carrinho.entity.StatusPagamento;
import br.com.postechfiap.carrinhocompra_pagamento.domain.pagamento.MeioPagamento;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public record CarrinhoCompraResponseDto (
    UUID id,
    UUID idUsuario,
    List<ItemResponseDto> itens,
    BigDecimal total,
    PagamentoResponseDto pagamento
) {
}
