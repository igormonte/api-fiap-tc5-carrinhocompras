package br.com.postechfiap.carrinhocompra_itens.infrastructure.db.repository;

import br.com.postechfiap.carrinhocompra_itens.infrastructure.db.entity.ItemDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<ItemDbEntity, UUID> {
}
