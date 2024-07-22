package br.com.postechfiap.carrinhocompra.domain.usecases;

import br.com.postechfiap.carrinhocompra.domain.entity.CarrinhoCompra;
import br.com.postechfiap.carrinhocompra.domain.usecases.repository.AdicionarItemAoCarrinhoRepository;

import java.util.UUID;

public class AdicionarItemAoCarrinhoUseCaseImpl implements AdicionarItemAoCarrinhoUseCase {

    private final AdicionarItemAoCarrinhoRepository adicionarItemAoCarrinhoRepository;

    public AdicionarItemAoCarrinhoUseCaseImpl(
            AdicionarItemAoCarrinhoRepository adicionarItemAoCarrinhoRepository) {
        this.adicionarItemAoCarrinhoRepository = adicionarItemAoCarrinhoRepository;
    }

    @Override
    public CarrinhoCompra executar(UUID idCarrinho, UUID idItem, Integer quantidade) {
        return this.adicionarItemAoCarrinhoRepository.executar(idCarrinho, idItem, quantidade);
    }
}
