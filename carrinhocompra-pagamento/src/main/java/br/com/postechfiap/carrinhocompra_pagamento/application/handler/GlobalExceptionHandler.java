package br.com.postechfiap.carrinhocompra_pagamento.application.handler;

import br.com.postechfiap.carrinhocompra_pagamento.application.gateway.exception.*;
import br.com.postechfiap.carrinhocompra_pagamento.domain.exception.MeioPagamentoNaoEncontradoException;
import br.com.postechfiap.carrinhocompra_pagamento.domain.exception.NumeroParcelasNaoPodeSerNuloException;
import br.com.postechfiap.carrinhocompra_pagamento.domain.exception.ValorNaoPodeSerNuloException;
import br.com.postechfiap.carrinhocompra_pagamento.infrastructure.security.exception.UsuarioLogadoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HandlerDto> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getDefaultMessage());
        }
        Collections.sort(errors);
        HandlerDto errorResponse =
                new HandlerDto("Validation error", errors);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorResponse);
    }

    @ExceptionHandler(UsuarioLogadoNaoEncontradoException.class)
    public ResponseEntity<HandlerDto> handleUsuarioLogadoNaoEncontradoException(
            UsuarioLogadoNaoEncontradoException e
    ) {
        HandlerDto errorResponse =
                new HandlerDto("Runtime error", List.of(e.getMessage()));
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorResponse);
    }
    @ExceptionHandler(ValorNaoPodeSerNuloException.class)
    public ResponseEntity<HandlerDto> handleValorNaoPodeSerNuloException(
            ValorNaoPodeSerNuloException e
    ) {
        HandlerDto errorResponse =
                new HandlerDto("Runtime error", List.of(e.getMessage()));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorResponse);
    }
    @ExceptionHandler(NumeroParcelasNaoPodeSerNuloException.class)
    public ResponseEntity<HandlerDto> handleNumeroParcelasNaoPodeSerNuloException(
            NumeroParcelasNaoPodeSerNuloException e
    ) {
        HandlerDto errorResponse =
                new HandlerDto("Runtime error", List.of(e.getMessage()));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorResponse);
    }
    @ExceptionHandler(MeioPagamentoNaoEncontradoException.class)
    public ResponseEntity<HandlerDto> handleMeioPagamentoNaoEncontradoException(
            MeioPagamentoNaoEncontradoException e
    ) {
        HandlerDto errorResponse =
                new HandlerDto("Runtime error", List.of(e.getMessage()));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorResponse);
    }
    @ExceptionHandler(VencimentoNaoPodeSerNuloException.class)
    public ResponseEntity<HandlerDto> handleVencimentoNaoPodeSerNuloException(
            VencimentoNaoPodeSerNuloException e
    ) {
        HandlerDto errorResponse =
                new HandlerDto("Runtime error", List.of(e.getMessage()));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorResponse);
    }
    @ExceptionHandler(NumeroParcelasInvalidasException.class)
    public ResponseEntity<HandlerDto> handleNumeroParcelasInvalidasException(
            NumeroParcelasInvalidasException e
    ) {
        HandlerDto errorResponse =
                new HandlerDto("Runtime error", List.of(e.getMessage()));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorResponse);
    }
    @ExceptionHandler(NumeroCartaoNaoPodeSerNuloException.class)
    public ResponseEntity<HandlerDto> handleNumeroCartaoNaoPodeSerNuloException(
            NumeroCartaoNaoPodeSerNuloException e
    ) {
        HandlerDto errorResponse =
                new HandlerDto("Runtime error", List.of(e.getMessage()));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorResponse);
    }
    @ExceptionHandler(CodigoVerificadorNaoPodeSerNuloException.class)
    public ResponseEntity<HandlerDto> handleCodigoVerificadorNaoPodeSerNuloException(
            CodigoVerificadorNaoPodeSerNuloException e
    ) {
        HandlerDto errorResponse =
                new HandlerDto("Runtime error", List.of(e.getMessage()));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorResponse);
    }
    @ExceptionHandler(CarrinhoNaoEncontradoException.class)
    public ResponseEntity<HandlerDto> handleCarrinhoNaoEncontradoException(
            CarrinhoNaoEncontradoException e
    ) {
        HandlerDto errorResponse =
                new HandlerDto("Runtime error", List.of(e.getMessage()));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorResponse);
    }
}
