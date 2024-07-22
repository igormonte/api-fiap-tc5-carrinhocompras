package br.com.postechfiap.carrinhocompra_pagamento.domain.carrinho.entity;

import br.com.postechfiap.carrinhocompra_pagamento.domain.pagamento.Pagamento;
import lombok.Data;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class CarrinhoCompra {
    private UUID id;
    private UUID idUsuario;
    private List<Item> itens;
    private BigDecimal total;
    private StatusPagamento status;
    private Pagamento pagamento;

    public CarrinhoCompra() {
        this.pagamento = new Pagamento();
    }

    public void calcularTotal() {

        this.total = this.itens.stream()
                .map(i-> {
                    i.calculaTotal();
                    return i.getTotal();
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }
}
