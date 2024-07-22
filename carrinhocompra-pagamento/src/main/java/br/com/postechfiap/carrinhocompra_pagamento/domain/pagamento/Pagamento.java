package br.com.postechfiap.carrinhocompra_pagamento.domain.pagamento;

import br.com.postechfiap.carrinhocompra_pagamento.domain.carrinho.entity.StatusPagamento;
import br.com.postechfiap.carrinhocompra_pagamento.domain.exception.NumeroParcelasNaoPodeSerNuloException;
import br.com.postechfiap.carrinhocompra_pagamento.domain.exception.ValorNaoPodeSerNuloException;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Pagamento {
    private BigDecimal valor;
    private BigDecimal valorParcela;
    private MeioPagamento meioPagamento;
    private StatusPagamento status;
    private Integer parcela;
    private String cpf;
    private String numeroCartao;
    private String vencimento;
    private String nomeTitular;
    private String codigoVerificador;

    public Pagamento() {
        this.status = StatusPagamento.PENDENTE;
    }

    public void calculaParcelas() {
        if(this.valor == null) {
            throw new ValorNaoPodeSerNuloException("Valor não pode ser nulo.");
        }

        if(this.parcela == null) {
            throw new NumeroParcelasNaoPodeSerNuloException("Parcela não pode ser nula.");
        }

        this.valorParcela = this.valor.divide(BigDecimal.valueOf(this.parcela));

    }

}
