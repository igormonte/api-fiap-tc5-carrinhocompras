package br.com.postechfiap.carrinhocompra_login.infrastructure.db.entity;

import br.com.postechfiap.carrinhocompra_login.domain.entity.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "usuario")
public class UsuarioDbEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        private String cpf;
        private String nome;
        private String email;
        private String senha;
        private Role role;
}
