package br.com.postechfiap.carrinhocompra.domain.usecases;

import br.com.postechfiap.carrinhocompra.domain.entity.CarrinhoCompra;
import br.com.postechfiap.carrinhocompra.domain.usecases.repository.VisualizarCarrinhoRepository;

import java.util.UUID;

public class VisualizarCarrinhoUseCaseImpl implements VisualizarCarrinhoUseCase {
    private final VisualizarCarrinhoRepository visualizarCarrinhoRepository;

    public VisualizarCarrinhoUseCaseImpl(VisualizarCarrinhoRepository visualizarCarrinhoRepository) {
        this.visualizarCarrinhoRepository = visualizarCarrinhoRepository;
    }

    @Override
    public CarrinhoCompra executar(UUID idUsuario) {
        return this.visualizarCarrinhoRepository.executar(idUsuario);
    }
}