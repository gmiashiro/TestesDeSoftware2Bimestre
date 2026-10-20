package br.edu.exemplo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PedidoService {
    private final EstoqueService estoqueService;
    private final List<ProdutoEntity> pedidos;

    public PedidoService(EstoqueService estoqueService) {
        if (estoqueService == null) {
            throw new IllegalArgumentException("O estoque e obrigatorio");
        }
        this.estoqueService = estoqueService;
        this.pedidos = new ArrayList<>();
    }

    public boolean realizarPedido(ProdutoEntity pedido) {
        if (!estoqueService.temEstoque(pedido)) {
            return false;
        }
        estoqueService.retirar(pedido);
        pedidos.add(pedido);
        return true;
    }

    public List<ProdutoEntity> getPedidos() {
        return Collections.unmodifiableList(new ArrayList<>(pedidos));
    }
}
