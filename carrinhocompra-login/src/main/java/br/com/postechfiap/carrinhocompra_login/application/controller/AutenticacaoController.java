package br.com.postechfiap.carrinhocompra_login.application.controller;

import br.com.postechfiap.carrinhocompra_login.application.dto.request.CriarUsuarioDto;
import br.com.postechfiap.carrinhocompra_login.application.dto.response.AccessDto;
import br.com.postechfiap.carrinhocompra_login.application.dto.response.CheckDto;
import br.com.postechfiap.carrinhocompra_login.application.dto.response.UsuarioDto;
import br.com.postechfiap.carrinhocompra_login.domain.entity.Usuario;
import br.com.postechfiap.carrinhocompra_login.domain.usecases.LoginUsuarioUseCase;
import br.com.postechfiap.carrinhocompra_login.domain.usecases.RegistrarUsuarioUseCase;
import br.com.postechfiap.carrinhocompra_login.infrastructure.mapstruct.mapper.UsuarioMapper;
import br.com.postechfiap.carrinhocompra_login.infrastructure.security.entity.UserDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    private final RegistrarUsuarioUseCase registrarUsuarioUseCase;
    private final LoginUsuarioUseCase loginUsuarioUseCase;
    private final UsuarioMapper usuarioMapper;

    public AutenticacaoController(
            RegistrarUsuarioUseCase registrarUsuarioUseCase,
            LoginUsuarioUseCase loginUsuarioUseCase, UsuarioMapper usuarioMapper) {
        this.registrarUsuarioUseCase = registrarUsuarioUseCase;
        this.loginUsuarioUseCase = loginUsuarioUseCase;
        this.usuarioMapper = usuarioMapper;
    }
    @GetMapping("/me")
    public ResponseEntity<?> me() {
        UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(
                this.usuarioMapper.toUsuarioDto(
                        user.getUsuario()));
    }

    @GetMapping("/checkMe")
    public ResponseEntity<?> checkMe() {
        return ResponseEntity.ok(new CheckDto("Authorized", true));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestPart String email, @RequestPart String senha) {
        return ResponseEntity.ok(
                new AccessDto(
                        this.loginUsuarioUseCase.executar(email, senha)));
    }

    @PostMapping("/criarConta")
    public ResponseEntity<UsuarioDto> criarConta(@RequestBody CriarUsuarioDto usuario) {
        return ResponseEntity.ok(
                this.usuarioMapper.toUsuarioDto(
                        this.registrarUsuarioUseCase.executar(
                                this.usuarioMapper.toUsuario(usuario))));
    }


}
