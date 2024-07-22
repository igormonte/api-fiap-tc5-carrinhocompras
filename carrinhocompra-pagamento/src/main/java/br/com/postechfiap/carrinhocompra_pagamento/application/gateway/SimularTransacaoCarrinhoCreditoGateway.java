package br.com.postechfiap.carrinhocompra_pagamento.application.gateway;

import br.com.postechfiap.carrinhocompra_pagamento.application.gateway.exception.*;
import br.com.postechfiap.carrinhocompra_pagamento.domain.carrinho.entity.CarrinhoCompra;
import br.com.postechfiap.carrinhocompra_pagamento.domain.carrinho.entity.StatusPagamento;
import br.com.postechfiap.carrinhocompra_pagamento.domain.pagamento.Pagamento;
import br.com.postechfiap.carrinhocompra_pagamento.domain.usecases.repository.SimularTransacaoCarrinhoCreditoRepository;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.carrinhocompra.CarrinhoCompraMessagingGateway;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.carrinhocompra.dto.CarrinhoCompraDto;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.login.LoginMessagingGateway;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.login.dto.UsuarioDto;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.mapstruct.mapper.CarrinhoCompraMapper;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.security.exception.UsuarioLogadoNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;

import java.util.Objects;

public class SimularTransacaoCarrinhoCreditoGateway implements SimularTransacaoCarrinhoCreditoRepository {

    private final CarrinhoCompraMessagingGateway carrinhoCompraMessagingGateway;
    private final CarrinhoCompraMapper carrinhoCompraMapper;
    private final LoginMessagingGateway loginMessagingGateway;

    public SimularTransacaoCarrinhoCreditoGateway(
            CarrinhoCompraMessagingGateway carrinhoCompraMessagingGateway,
            CarrinhoCompraMapper carrinhoCompraMapper, LoginMessagingGateway loginMessagingGateway) {
        this.carrinhoCompraMessagingGateway = carrinhoCompraMessagingGateway;
        this.carrinhoCompraMapper = carrinhoCompraMapper;
        this.loginMessagingGateway = loginMessagingGateway;
    }

    @Override
    public CarrinhoCompra executar(String autorizacao, Pagamento pagamento) {

        ResponseEntity<UsuarioDto> usuarioDto =
                this.loginMessagingGateway.me(
                        autorizacao,
                        MessageBuilder.withPayload("").build());

        if(usuarioDto.getStatusCode().isError()) {
            throw new UsuarioLogadoNaoEncontradoException("Usuário não encontrado!");
        }

        pagamento.setCpf(Objects.requireNonNull(usuarioDto.getBody()).cpf());
        pagamento.setNomeTitular(usuarioDto.getBody().nome());

        if(pagamento.getParcela()==null || pagamento.getParcela() <=0) {
            throw new NumeroParcelasInvalidasException("Número de parcelas inválidas!");
        }

        if(pagamento.getNumeroCartao()==null || pagamento.getNumeroCartao().isEmpty()) {
            throw new NumeroCartaoNaoPodeSerNuloException("Número do Cartao não pode ser nulo!");
        }

        if(pagamento.getVencimento()==null || pagamento.getVencimento().isEmpty()) {
            throw new VencimentoNaoPodeSerNuloException("Vencimento não pode ser nulo!");
        }

        if(pagamento.getCodigoVerificador()==null || pagamento.getCodigoVerificador().isEmpty()) {
            throw new CodigoVerificadorNaoPodeSerNuloException("Codigo Verificador não pode ser nulo!");
        }

        ResponseEntity<CarrinhoCompraDto> carrinhoCompraDto = null;

        try {
            carrinhoCompraDto =
                this.carrinhoCompraMessagingGateway.visualizarCarrinho(autorizacao,
                        MessageBuilder.withPayload("").build());
        } catch (Exception e) {
            throw new CarrinhoNaoEncontradoException("Carrinho não encontrado!");
        }

        if(carrinhoCompraDto.getBody() == null) {
            throw new CarrinhoNaoEncontradoException("Carrinho não encontrado!");
        }

        CarrinhoCompra carrinhoCompra =
                this.carrinhoCompraMapper.toCarrinhoCompra(carrinhoCompraDto.getBody());

        carrinhoCompra.calcularTotal();

        pagamento.setValor(carrinhoCompra.getTotal());
        pagamento.calculaParcelas();
        pagamento.setStatus(StatusPagamento.APROVADO);


        carrinhoCompra.setPagamento(pagamento);


        return carrinhoCompra;

    }
}
