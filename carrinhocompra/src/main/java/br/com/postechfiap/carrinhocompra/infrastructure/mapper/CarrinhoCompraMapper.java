package br.com.postechfiap.carrinhocompra.infrastructure.mapper;

import br.com.postechfiap.carrinhocompra.domain.entity.CarrinhoCompra;
import br.com.postechfiap.carrinhocompra.infrastructure.db.mongo.entity.CarrinhoCompraDbEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface CarrinhoCompraMapper {

    CarrinhoCompra toCarrinhoCompra(CarrinhoCompraDbEntity CarrinhoCompraDbEntity);
    CarrinhoCompraDbEntity toCarrinhoCompraDbEntity(CarrinhoCompra CarrinhoCompra);
    List<CarrinhoCompra> toCarrinhoCompraList(List<CarrinhoCompraDbEntity> CarrinhoCompraDbEntityList);
    List<CarrinhoCompraDbEntity> toCarrinhoCompraDbEntityList(List<CarrinhoCompra> CarrinhoCompraList);

}
