package br.com.postechfiap.carrinhocompra.application.controller;

import br.com.postechfiap.carrinhocompra.application.dto.AdicionarItemDto;
import br.com.postechfiap.carrinhocompra.domain.usecases.AdicionarItemAoCarrinhoUseCase;
import br.com.postechfiap.carrinhocompra.domain.usecases.RemoverItemDoCarrinhoUseCase;
import br.com.postechfiap.carrinhocompra.domain.usecases.VisualizarCarrinhoUseCase;
import br.com.postechfiap.carrinhocompra.infrastructure.login.dto.UsuarioDto;
import br.com.postechfiap.carrinhocompra.infrastructure.security.RemoteSecurityContextService;
import br.com.postechfiap.carrinhocompra.infrastructure.security.exception.UsuarioLogadoNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/carrinhocompra")
public class CarrinhoCompraController {
    private final AdicionarItemAoCarrinhoUseCase adicionarItemAoCarrinhoUseCase;
    private final RemoverItemDoCarrinhoUseCase removerItemDoCarrinhoUseCase;
    private final VisualizarCarrinhoUseCase visualizarCarrinhoUseCase;
    private final RemoteSecurityContextService<UsuarioDto> remoteSecurityContextService;
    public CarrinhoCompraController(
            AdicionarItemAoCarrinhoUseCase adicionarItemAoCarrinhoUseCase,
            RemoverItemDoCarrinhoUseCase removerItemDoCarrinhoUseCase,
            VisualizarCarrinhoUseCase visualizarCarrinhoUseCase,
            RemoteSecurityContextService<UsuarioDto> remoteSecurityContextService) {
        this.adicionarItemAoCarrinhoUseCase = adicionarItemAoCarrinhoUseCase;
        this.removerItemDoCarrinhoUseCase = removerItemDoCarrinhoUseCase;
        this.visualizarCarrinhoUseCase = visualizarCarrinhoUseCase;
        this.remoteSecurityContextService = remoteSecurityContextService;
    }

    @GetMapping("")
    public ResponseEntity<?> visualizarCarrinho(
            @RequestHeader("Authorization") String authotization) {
        UUID id = this.getUsuarioLogadoId(authotization);

        return ResponseEntity.ok(
                this.visualizarCarrinhoUseCase.executar(id));
    }

    @PostMapping("/adicionarItem")
    public ResponseEntity<?> cadastrarItem(
            @RequestHeader("Authorization") String authotization,
           @RequestBody AdicionarItemDto item) {
        UUID id = this.getUsuarioLogadoId(authotization);
        return ResponseEntity.ok(
                this.adicionarItemAoCarrinhoUseCase.executar(id, item.idItem(), item.quantidade()));
    }

    @DeleteMapping("/removerItem/{id}")
    public ResponseEntity<?> removerItem(
            @RequestHeader("Authorization") String authotization,
            @PathVariable UUID id) {
        UUID usuarioId = this.getUsuarioLogadoId(authotization);
        return ResponseEntity.ok(this.removerItemDoCarrinhoUseCase.executar(usuarioId, id));
    }

    private UUID getUsuarioLogadoId(String authotization) {
        Optional<UsuarioDto> usuario = this.remoteSecurityContextService.getPrincipal(authotization);

        if(usuario.isEmpty()) {
            throw new UsuarioLogadoNaoEncontradoException("Não foi possível encontrar o usuário logado.");
        }

        return usuario.get().id();

    }


}
