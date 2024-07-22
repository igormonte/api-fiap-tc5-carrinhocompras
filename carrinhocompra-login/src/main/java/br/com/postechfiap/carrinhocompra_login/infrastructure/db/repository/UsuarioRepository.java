package br.com.postechfiap.carrinhocompra_login.infrastructure.db.repository;

import br.com.postechfiap.carrinhocompra_login.domain.entity.Usuario;
import br.com.postechfiap.carrinhocompra_login.infrastructure.db.entity.UsuarioDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioDbEntity, UUID> {

    Optional<UsuarioDbEntity> findByEmail(String email);

    boolean existsByEmail(String email);
}
