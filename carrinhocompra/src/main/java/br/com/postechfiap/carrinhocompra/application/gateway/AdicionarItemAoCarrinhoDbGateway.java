package br.com.postechfiap.carrinhocompra.application.gateway;

import br.com.postechfiap.carrinhocompra.application.gateway.exception.ItemNaoEncontradoException;
import br.com.postechfiap.carrinhocompra.domain.entity.CarrinhoCompra;
import br.com.postechfiap.carrinhocompra.domain.entity.Item;
import br.com.postechfiap.carrinhocompra.domain.usecases.repository.AdicionarItemAoCarrinhoRepository;
import br.com.postechfiap.carrinhocompra.infrastructure.db.mongo.repository.CarrinhoCompraRepository;
import br.com.postechfiap.carrinhocompra.infrastructure.itens.login.ItensMessagingGateway;
import br.com.postechfiap.carrinhocompra.infrastructure.itens.login.dto.ItemDto;
import br.com.postechfiap.carrinhocompra.infrastructure.mapper.CarrinhoCompraMapper;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class AdicionarItemAoCarrinhoDbGateway implements AdicionarItemAoCarrinhoRepository {

    private final CarrinhoCompraRepository carrinhoCompraRepository;

    private final CarrinhoCompraMapper carrinhoCompraMapper;

    private final ItensMessagingGateway itensMessagingGateway;

    public AdicionarItemAoCarrinhoDbGateway(
            CarrinhoCompraRepository carrinhoCompraRepository,
            CarrinhoCompraMapper carrinhoCompraMapper, ItensMessagingGateway itensMessagingGateway) {
        this.carrinhoCompraRepository = carrinhoCompraRepository;
        this.carrinhoCompraMapper = carrinhoCompraMapper;
        this.itensMessagingGateway = itensMessagingGateway;
    }

    @Override
    public CarrinhoCompra executar(UUID idUsuario, UUID idItem, Integer quantidade) {
        CarrinhoCompra carrinho =
                this.carrinhoCompraMapper.toCarrinhoCompra(
                        this.carrinhoCompraRepository.findByIdUsuario(idUsuario)
                                .orElse(null));

        ItemDto itemDto = this.buscarProduto(idItem);

        if( carrinho == null ) {
            carrinho = new CarrinhoCompra();
            carrinho.setIdUsuario(idUsuario);
        }

        Item item = new Item(idItem, quantidade, itemDto.preco());
        carrinho.adicionarItem(item);
        return this.carrinhoCompraMapper.toCarrinhoCompra(
                this.carrinhoCompraRepository.save(
                        this.carrinhoCompraMapper.toCarrinhoCompraDbEntity(carrinho)));
    }

    ItemDto buscarProduto(UUID idItem) {
        ResponseEntity<ItemDto> item = null;

        try {

            item = this.itensMessagingGateway.consultaItemPorId(idItem);

        } catch (Exception e) {
            throw new ItemNaoEncontradoException("Item não encontrado!");
        }

        if(item == null) {
            throw new ItemNaoEncontradoException("Item não encontrado!");
        }

        return item.getBody();

    }
}
