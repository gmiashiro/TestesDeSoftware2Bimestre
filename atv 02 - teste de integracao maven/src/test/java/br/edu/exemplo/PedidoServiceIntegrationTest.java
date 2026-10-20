package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceIntegrationTest {
    @Test
    void deveRealizarPedidoRetirarProdutoERegistrarPedido() {
        EstoqueService estoque = new EstoqueService(
                List.of(new ProdutoEntity("Caderno", 10)));
        PedidoService pedidoService = new PedidoService(estoque);

        assertTrue(pedidoService.realizarPedido(new ProdutoEntity("Caderno", 3)));

        assertEquals(7, estoque.getProdutos().get(0).getQuantidade());
        assertEquals(List.of(new ProdutoEntity("Caderno", 3)),
                pedidoService.getPedidos());
    }

    @Test
    void naoDeveRealizarPedidoSemEstoqueSuficiente() {
        EstoqueService estoque = new EstoqueService(
                List.of(new ProdutoEntity("Caderno", 2)));
        PedidoService pedidoService = new PedidoService(estoque);

        assertFalse(pedidoService.realizarPedido(new ProdutoEntity("Caderno", 3)));

        assertEquals(2, estoque.getProdutos().get(0).getQuantidade());
        assertTrue(pedidoService.getPedidos().isEmpty());
    }

    @Test
    void naoDeveRealizarPedidoNulo() {
        PedidoService pedidoService = new PedidoService(
                new EstoqueService(List.of(new ProdutoEntity("Caderno", 2))));

        assertFalse(pedidoService.realizarPedido(null));
    }
}
