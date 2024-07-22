package br.com.postechfiap.carrinhocompra_itens.application.controller;

import br.com.postechfiap.carrinhocompra_itens.application.dto.CriarItemDto;
import br.com.postechfiap.carrinhocompra_itens.domain.entity.Item;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.CadastrarItemUseCase;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.EditarItemUseCase;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.ListarItensUseCase;
import br.com.postechfiap.carrinhocompra_itens.domain.usecases.RemoverItemUseCase;
import br.com.postechfiap.carrinhocompra_itens.infrastructure.mapstruct.mapper.ItemMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/itens")
public class ItemController {

    private final EditarItemUseCase editarItemUseCase;
    private final CadastrarItemUseCase cadastrarItemUseCase;
    private final ListarItensUseCase listarItensUseCase;
    private final RemoverItemUseCase removerItemUseCase;
    private final ItemMapper itemMapper;

    public ItemController(EditarItemUseCase editarItemUseCase,
                          CadastrarItemUseCase cadastrarItemUseCase,
                          ListarItensUseCase listarItensUseCase,
                          RemoverItemUseCase removerItemUseCase, ItemMapper itemMapper) {
        this.editarItemUseCase = editarItemUseCase;
        this.cadastrarItemUseCase = cadastrarItemUseCase;
        this.listarItensUseCase = listarItensUseCase;
        this.removerItemUseCase = removerItemUseCase;
        this.itemMapper = itemMapper;
    }

    @GetMapping("")
    public ResponseEntity<?> listarItens() {
        return ResponseEntity.ok(
                this.listarItensUseCase.todos());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> listarItens(@PathVariable UUID id) {
        return ResponseEntity.ok(
                this.listarItensUseCase.porId(id));
    }

    @PostMapping("/cadastrarItem")
    public ResponseEntity<?> cadastrarItem(@RequestBody CriarItemDto item) {
        log.info(item.toString());

        return ResponseEntity.ok(
                this.cadastrarItemUseCase.executar(
                        this.itemMapper.toItem(item)));
    }

    @PutMapping("/editarItem")
    public ResponseEntity<?> editarItem(@RequestBody Item item) {
        return ResponseEntity.ok(
                this.editarItemUseCase.executar(item));
    }

    @DeleteMapping("/removerItem/{id}")
    public ResponseEntity<?> removerItem(@PathVariable UUID id) {
        this.removerItemUseCase.executar(id);
        return ResponseEntity.ok(Optional.empty());
    }


}
