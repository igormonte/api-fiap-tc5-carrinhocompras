package br.com.postechfiap.carrinhocompra_itens.infrastructure.db.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;


@Data
@Entity
@Table(name = "item")
public class ItemDbEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String descricao;
    private String categoria;
    private BigDecimal preco;
    private String urlImagem;
}
