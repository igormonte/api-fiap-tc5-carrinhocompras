package br.com.postechfiap.carrinhocompra_login.domain.entity;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Usuario {
        private UUID id;
        private String cpf;
        private String nome;
        private String email;
        private String senha;
        private Role role;

        public Usuario() {
               this.role = Role.COMUM;
        }
}
