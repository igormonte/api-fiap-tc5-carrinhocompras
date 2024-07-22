package br.com.postechfiap.carrinhocompra.application.gateway;


import br.com.postechfiap.carrinhocompra.application.gateway.exception.CarrinhoNaoEncontradoException;
import br.com.postechfiap.carrinhocompra.domain.entity.CarrinhoCompra;
import br.com.postechfiap.carrinhocompra.domain.usecases.repository.RemoverItemDoCarrinhoRepository;
import br.com.postechfiap.carrinhocompra.infrastructure.db.mongo.repository.CarrinhoCompraRepository;
import br.com.postechfiap.carrinhocompra.infrastructure.mapper.CarrinhoCompraMapper;

import java.util.UUID;

public class RemoverItemDoCarrinhoDbGateway implements RemoverItemDoCarrinhoRepository {

    private final CarrinhoCompraRepository carrinhoCompraRepository;
    private final CarrinhoCompraMapper carrinhoCompraMapper;

    public RemoverItemDoCarrinhoDbGateway(
            CarrinhoCompraRepository carrinhoCompraRepository,
            CarrinhoCompraMapper carrinhoCompraMapper) {
        this.carrinhoCompraRepository = carrinhoCompraRepository;
        this.carrinhoCompraMapper = carrinhoCompraMapper;
    }

    @Override
    public CarrinhoCompra executar(UUID idUsuario, UUID idItem) {
        CarrinhoCompra carrinho = this.carrinhoCompraMapper.toCarrinhoCompra(
                this.carrinhoCompraRepository.findByIdUsuario(idUsuario)
                        .orElseThrow(() -> new CarrinhoNaoEncontradoException("Carrinho não encontrado")));

        carrinho.removerItem(idItem);
        return this.carrinhoCompraMapper.toCarrinhoCompra(
                this.carrinhoCompraRepository.save(
                        this.carrinhoCompraMapper.toCarrinhoCompraDbEntity(carrinho)));
    }

}
