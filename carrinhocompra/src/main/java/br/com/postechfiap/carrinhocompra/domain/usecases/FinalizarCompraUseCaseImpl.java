package br.com.postechfiap.carrinhocompra.domain.usecases;

import br.com.postechfiap.carrinhocompra.domain.entity.CarrinhoCompra;
import br.com.postechfiap.carrinhocompra.domain.usecases.repository.FinalizarCompraRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

public class FinalizarCompraUseCaseImpl implements FinalizarCompraUseCase {
    private final FinalizarCompraRepository finalizarCompraRepository;

    public FinalizarCompraUseCaseImpl(FinalizarCompraRepository finalizarCompraRepository) {
        this.finalizarCompraRepository = finalizarCompraRepository;
    }

    @Override
    public CarrinhoCompra executar(UUID idCarrinho) {
        return this.finalizarCompraRepository.executar(idCarrinho);
    }
}
