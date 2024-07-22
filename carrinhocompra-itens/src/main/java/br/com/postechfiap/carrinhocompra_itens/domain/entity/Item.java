package br.com.postechfiap.carrinhocompra_itens.domain.entity;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Item {
    private UUID id;
    private String nome;
    private String descricao;
    private String categoria;
    private BigDecimal preco;
    private String urlImagem;
}
