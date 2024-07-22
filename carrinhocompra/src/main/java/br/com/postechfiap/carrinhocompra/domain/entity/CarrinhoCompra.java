package br.com.postechfiap.carrinhocompra.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class CarrinhoCompra {
    private UUID id;
    private UUID idUsuario;
    private List<Item> itens;
    private BigDecimal total;

    public void adicionarItem(Item item) {
        if(this.itens == null) {
            this.itens = new LinkedList<>();
        }

        Optional<Item> itemSalvo =
                this.itens.stream()
                        .filter(i->i.getIdItem().equals(item.getIdItem()))
                        .findAny();

        if(itemSalvo.isPresent()) {
            itemSalvo.get().setQuantidade(
                    itemSalvo.get().getQuantidade() + item.getQuantidade());
        } else {
            this.itens.add(item);

        }


    }

    public void removerItem(UUID idItem) {

        if(this.itens == null) {
            return;
        }

        this.itens = this.itens.stream()
                .filter(item -> !item.getIdItem().equals(idItem))
                .collect(Collectors.toList());

    }
}
