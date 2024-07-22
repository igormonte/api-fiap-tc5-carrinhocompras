package br.com.postechfiap.carrinhocompra_pagamento.infrastructure.mapstruct.mapper;

import br.com.postechfiap.carrinhocompra_pagamento.application.dto.response.CarrinhoCompraResponseDto;
import br.com.postechfiap.carrinhocompra_pagamento.domain.carrinho.entity.CarrinhoCompra;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.carrinhocompra.dto.CarrinhoCompraDto;
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

    CarrinhoCompra toCarrinhoCompra(CarrinhoCompraDto carrinhoCompraDto);

    CarrinhoCompraResponseDto toCarrinhoCompraResponseDto(CarrinhoCompra carrinhoCompra);

}
