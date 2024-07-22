package br.com.postechfiap.carrinhocompra_pagamento.application.controller;

import br.com.postechfiap.carrinhocompra_pagamento.application.dto.request.PagamentoDto;
import br.com.postechfiap.carrinhocompra_pagamento.application.dto.response.CarrinhoCompraResponseDto;
import br.com.postechfiap.carrinhocompra_pagamento.domain.carrinho.entity.CarrinhoCompra;
import br.com.postechfiap.carrinhocompra_pagamento.domain.usecases.SimularTransacaoCarrinhoUseCase;
import br.com.postechfiap.carrinhocompra_pagamento.domain.usecases.VisualizarResumoCarrinhoUseCase;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.login.dto.UsuarioDto;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.mapstruct.mapper.CarrinhoCompraMapper;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.mapstruct.mapper.PagamentoMapper;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.security.RemoteSecurityContextService;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.security.exception.UsuarioLogadoNaoEncontradoException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController()
@RequestMapping("/pagamento")
public class PagamentoController {

    private final SimularTransacaoCarrinhoUseCase simularTransacaoCarrinhoUseCase;
    private final VisualizarResumoCarrinhoUseCase visualizarResumoCarrinhoUseCase;
    private final RemoteSecurityContextService<UsuarioDto> remoteSecurityContextService;
    private final PagamentoMapper pagamentoMapper;
    private final CarrinhoCompraMapper carrinhoCompraMapper;

    public PagamentoController(SimularTransacaoCarrinhoUseCase simularTransacaoCarrinhoUseCase,
                               VisualizarResumoCarrinhoUseCase visualizarResumoCarrinhoUseCase,
                               RemoteSecurityContextService<UsuarioDto> remoteSecurityContextService,
                               PagamentoMapper pagamentoMapper,
                               CarrinhoCompraMapper carrinhoCompraMapper) {
        this.simularTransacaoCarrinhoUseCase = simularTransacaoCarrinhoUseCase;
        this.visualizarResumoCarrinhoUseCase = visualizarResumoCarrinhoUseCase;
        this.remoteSecurityContextService = remoteSecurityContextService;
        this.pagamentoMapper = pagamentoMapper;
        this.carrinhoCompraMapper = carrinhoCompraMapper;
    }

    @GetMapping("/visualizarCarrinho")
    public ResponseEntity<?> visualizarCarrinho(
            @RequestHeader("Authorization") String authotization) {

        CarrinhoCompra carrinhoCompra = this.visualizarResumoCarrinhoUseCase.executar(authotization);

        return ResponseEntity.ok(carrinhoCompra);
    }

    @PostMapping("/finalizarCompra")
    public ResponseEntity<CarrinhoCompraResponseDto> finalizarCompra(
            @RequestHeader("Authorization") String authotization,
            @Valid @RequestBody PagamentoDto pagamentoDto) {

        CarrinhoCompraResponseDto carrinhoCompraResponseDto =
                this.carrinhoCompraMapper.toCarrinhoCompraResponseDto(
                        this.simularTransacaoCarrinhoUseCase.executar(
                                authotization, this.pagamentoMapper.toPagamento(pagamentoDto)));

        return ResponseEntity.ok(carrinhoCompraResponseDto);
    }

    private UUID getUsuarioLogadoId(String authotization) {
        Optional<UsuarioDto> usuario = this.remoteSecurityContextService.getPrincipal(authotization);

        if(usuario.isEmpty()) {
            throw new UsuarioLogadoNaoEncontradoException("Não foi possível encontrar o usuário logado.");
        }

        return usuario.get().id();

    }
}
