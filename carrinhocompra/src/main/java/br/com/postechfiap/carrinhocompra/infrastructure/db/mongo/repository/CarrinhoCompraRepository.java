package br.com.postechfiap.carrinhocompra.infrastructure.db.mongo.repository;

import br.com.postechfiap.carrinhocompra.infrastructure.db.mongo.entity.CarrinhoCompraDbEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarrinhoCompraRepository extends MongoRepository<CarrinhoCompraDbEntity, UUID> {
    Optional<CarrinhoCompraDbEntity> findByIdUsuario(UUID idUsuario);
}
