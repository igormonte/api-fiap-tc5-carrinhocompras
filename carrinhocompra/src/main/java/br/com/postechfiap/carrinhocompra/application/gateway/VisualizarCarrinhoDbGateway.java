package br.com.postechfiap.carrinhocompra.application.gateway;

import br.com.postechfiap.carrinhocompra.domain.entity.CarrinhoCompra;
import br.com.postechfiap.carrinhocompra.domain.usecases.repository.VisualizarCarrinhoRepository;
import br.com.postechfiap.carrinhocompra.infrastructure.db.mongo.repository.CarrinhoCompraRepository;
import br.com.postechfiap.carrinhocompra.infrastructure.mapper.CarrinhoCompraMapper;

import java.util.UUID;

public class VisualizarCarrinhoDbGateway implements VisualizarCarrinhoRepository {

    private final CarrinhoCompraRepository carrinhoCompraRepository;
    private final CarrinhoCompraMapper carrinhoCompraMapper;

    public VisualizarCarrinhoDbGateway(
            CarrinhoCompraRepository carrinhoCompraRepository,
            CarrinhoCompraMapper carrinhoCompraMapper) {
        this.carrinhoCompraRepository = carrinhoCompraRepository;
        this.carrinhoCompraMapper = carrinhoCompraMapper;
    }

    @Override
    public CarrinhoCompra executar(UUID idUsuario) {
        return this.carrinhoCompraMapper.toCarrinhoCompra(
                this.carrinhoCompraRepository.findByIdUsuario(idUsuario)
                        .orElse(null));
    }
}