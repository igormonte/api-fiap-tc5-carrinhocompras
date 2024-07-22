package br.com.postechfiap.carrinhocompra_pagamento.infrastructure.mapstruct.mapper;

import br.com.postechfiap.carrinhocompra_pagamento.application.dto.request.PagamentoDto;
import br.com.postechfiap.carrinhocompra_pagamento.domain.pagamento.Pagamento;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface PagamentoMapper {

    Pagamento toPagamento(PagamentoDto pagamentoDto);
    
}
