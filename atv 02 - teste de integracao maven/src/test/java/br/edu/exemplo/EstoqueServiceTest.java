package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstoqueServiceTest {
    @Test
    void deveInformarQuandoExisteEstoque() {
        ProdutoEntity produto = new ProdutoEntity("Caderno", 10);
        EstoqueService estoque = new EstoqueService(List.of(produto));

        assertTrue(estoque.temEstoque(new ProdutoEntity("Caderno", 3)));
    }

    @Test
    void deveRetirarQuantidadeDoProduto() {
        EstoqueService estoque = new EstoqueService(
                List.of(new ProdutoEntity("Caderno", 10)));

        estoque.retirar(new ProdutoEntity("Caderno", 3));

        assertEquals(7, estoque.getProdutos().get(0).getQuantidade());
    }

    @Test
    void naoDeveInformarEstoqueParaProdutoDesconhecidoOuNulo() {
        EstoqueService estoque = new EstoqueService(
                List.of(new ProdutoEntity("Caderno", 10)));

        assertFalse(estoque.temEstoque(new ProdutoEntity("Caneta", 1)));
        assertFalse(estoque.temEstoque(null));
    }

    @Test
    void deveImpedirRetiradaSemEstoqueSuficiente() {
        EstoqueService estoque = new EstoqueService(
                List.of(new ProdutoEntity("Caderno", 2)));

        assertThrows(IllegalArgumentException.class,
                () -> estoque.retirar(new ProdutoEntity("Caderno", 3)));
    }
}
