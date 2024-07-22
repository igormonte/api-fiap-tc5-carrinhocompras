package br.com.postechfiap.carrinhocompra.application.gateway;

import br.com.postechfiap.carrinhocompra.application.gateway.exception.CarrinhoNaoEncontradoException;
import br.com.postechfiap.carrinhocompra.domain.entity.CarrinhoCompra;
import br.com.postechfiap.carrinhocompra.domain.usecases.repository.FinalizarCompraRepository;
import br.com.postechfiap.carrinhocompra.infrastructure.db.mongo.repository.CarrinhoCompraRepository;
import br.com.postechfiap.carrinhocompra.infrastructure.mapper.CarrinhoCompraMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

public class FinalizarCompraDbGateway implements FinalizarCompraRepository {
    private final CarrinhoCompraRepository carrinhoCompraRepository;
    private final CarrinhoCompraMapper carrinhoCompraMapper;

    public FinalizarCompraDbGateway(CarrinhoCompraRepository carrinhoCompraRepository, CarrinhoCompraMapper carrinhoCompraMapper) {
        this.carrinhoCompraRepository = carrinhoCompraRepository;
        this.carrinhoCompraMapper = carrinhoCompraMapper;
    }

    @Override
    public CarrinhoCompra executar(UUID idCarrinho) {
        CarrinhoCompra carrinho = this.carrinhoCompraMapper.toCarrinhoCompra(
                carrinhoCompraRepository.findById(idCarrinho)
                .orElseThrow(() -> new CarrinhoNaoEncontradoException("Carrinho não encontrado")));

        return this.carrinhoCompraMapper.toCarrinhoCompra(
                this.carrinhoCompraRepository.save(
                        this.carrinhoCompraMapper.toCarrinhoCompraDbEntity(carrinho)));
    }
}
