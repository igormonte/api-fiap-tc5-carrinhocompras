package br.com.postechfiap.carrinhocompra_itens.infrastructure.mapstruct.mapper;

import br.com.postechfiap.carrinhocompra_itens.application.dto.CriarItemDto;
import br.com.postechfiap.carrinhocompra_itens.domain.entity.Item;
import br.com.postechfiap.carrinhocompra_itens.infrastructure.db.entity.ItemDbEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface ItemMapper {

    Item toItem(ItemDbEntity itemDbEntity);
    Item toItem(CriarItemDto criarItemDto);
    ItemDbEntity toItemDbEntity(Item item);
    List<Item> toItemList(List<ItemDbEntity> itemDbEntityList);
    List<ItemDbEntity> toItemDbEntityList(List<Item> itemList);

}
