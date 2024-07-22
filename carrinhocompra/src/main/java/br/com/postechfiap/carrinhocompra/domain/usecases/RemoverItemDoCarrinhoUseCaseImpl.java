package br.com.postechfiap.carrinhocompra.domain.usecases;


import br.com.postechfiap.carrinhocompra.domain.entity.CarrinhoCompra;
import br.com.postechfiap.carrinhocompra.domain.usecases.repository.RemoverItemDoCarrinhoRepository;

import java.util.UUID;

public class RemoverItemDoCarrinhoUseCaseImpl implements RemoverItemDoCarrinhoUseCase {

    private final RemoverItemDoCarrinhoRepository removerItemDoCarrinhoRepository;

    public RemoverItemDoCarrinhoUseCaseImpl(RemoverItemDoCarrinhoRepository removerItemDoCarrinhoRepository) {
        this.removerItemDoCarrinhoRepository = removerItemDoCarrinhoRepository;
    }

    @Override
    public CarrinhoCompra executar(UUID idUsuario, UUID idItem) {
        return this.removerItemDoCarrinhoRepository.executar(idUsuario, idItem);
    }

}
