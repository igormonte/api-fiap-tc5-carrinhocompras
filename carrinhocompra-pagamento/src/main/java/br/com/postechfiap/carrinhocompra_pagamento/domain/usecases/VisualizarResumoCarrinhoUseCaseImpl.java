package br.com.postechfiap.carrinhocompra_pagamento.domain.usecases;

import br.com.postechfiap.carrinhocompra_pagamento.domain.carrinho.entity.CarrinhoCompra;
import br.com.postechfiap.carrinhocompra_pagamento.domain.usecases.repository.VisualizarResumoCarrinhoRepository;

import java.util.UUID;

public class VisualizarResumoCarrinhoUseCaseImpl implements VisualizarResumoCarrinhoUseCase {

    private final VisualizarResumoCarrinhoRepository visualizarResumoCarrinhoRepository;

    public VisualizarResumoCarrinhoUseCaseImpl(
            VisualizarResumoCarrinhoRepository visualizarResumoCarrinhoRepository) {
        this.visualizarResumoCarrinhoRepository = visualizarResumoCarrinhoRepository;
    }

    @Override
    public CarrinhoCompra executar(String autorizacao) {

        CarrinhoCompra carrinhoCompra =
                this.visualizarResumoCarrinhoRepository.executar(autorizacao);

        carrinhoCompra.calcularTotal();

        return carrinhoCompra;

    }

}
