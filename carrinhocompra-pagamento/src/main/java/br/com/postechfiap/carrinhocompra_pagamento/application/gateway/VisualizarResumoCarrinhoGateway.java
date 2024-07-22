package br.com.postechfiap.carrinhocompra_pagamento.application.gateway;

import br.com.postechfiap.carrinhocompra_pagamento.application.gateway.exception.CarrinhoNaoEncontradoException;
import br.com.postechfiap.carrinhocompra_pagamento.domain.carrinho.entity.CarrinhoCompra;
import br.com.postechfiap.carrinhocompra_pagamento.domain.usecases.repository.VisualizarResumoCarrinhoRepository;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.carrinhocompra.CarrinhoCompraMessagingGateway;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.carrinhocompra.dto.CarrinhoCompraDto;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.mapstruct.mapper.CarrinhoCompraMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;

import java.util.UUID;

public class VisualizarResumoCarrinhoGateway implements VisualizarResumoCarrinhoRepository {

    private final CarrinhoCompraMessagingGateway carrinhoCompraMessagingGateway;
    private final CarrinhoCompraMapper carrinhoCompraMapper;

    public VisualizarResumoCarrinhoGateway(
            CarrinhoCompraMessagingGateway carrinhoCompraMessagingGateway,
            CarrinhoCompraMapper carrinhoCompraMapper) {
        this.carrinhoCompraMessagingGateway = carrinhoCompraMessagingGateway;
        this.carrinhoCompraMapper = carrinhoCompraMapper;
    }

    @Override
    public CarrinhoCompra executar(String autorizacao) {
        ResponseEntity<CarrinhoCompraDto> carrinhoCompraDto = null;

        try {
            carrinhoCompraDto = this.carrinhoCompraMessagingGateway
                    .visualizarCarrinho(
                            autorizacao,
                            MessageBuilder.withPayload("")
                                    .build());
        } catch (Exception e) {
            throw new CarrinhoNaoEncontradoException("Carrinho não encontrado!");
        }

        if(carrinhoCompraDto.getBody() == null) {
            throw new CarrinhoNaoEncontradoException("Carrinho não encontrado!");
        }

        return this.carrinhoCompraMapper.toCarrinhoCompra(carrinhoCompraDto.getBody());
    }
}
