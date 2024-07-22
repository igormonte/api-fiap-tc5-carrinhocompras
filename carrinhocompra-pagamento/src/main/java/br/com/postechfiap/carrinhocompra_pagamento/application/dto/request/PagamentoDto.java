package br.com.postechfiap.carrinhocompra_pagamento.application.dto.request;

import br.com.postechfiap.carrinhocompra_pagamento.domain.pagamento.MeioPagamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Validated
public record PagamentoDto(
    @NotNull MeioPagamento meioPagamento,
    String numeroCartao,
    String vencimento,
    Integer parcela,
    String nomeTitular,
    String codigoVerificador)
{
}
