package br.com.postechfiap.carrinhocompra_pagamento.application.dto.response;

import br.com.postechfiap.carrinhocompra_pagamento.domain.carrinho.entity.StatusPagamento;
import br.com.postechfiap.carrinhocompra_pagamento.domain.pagamento.MeioPagamento;
import lombok.Data;

import java.math.BigDecimal;

public record PagamentoResponseDto (
    BigDecimal valor,
    MeioPagamento meioPagamento,
    StatusPagamento status,
    Integer parcela,
    BigDecimal valorParcela
){
}
