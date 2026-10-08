package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Os testes NÃO estão implementados.
 *
 * Para cada requisito apresentado em REQUISITOS.md:
 *
 * 1. escreva primeiro o teste;
 * 2. execute e observe a falha (RED);
 * 3. implemente somente o necessário em Carrinho;
 * 4. execute novamente até o teste passar (GREEN);
 * 5. refatore, se necessário;
 * 6. avance para o próximo requisito.
 */
class CarrinhoTest {

    @Test
    void criarCarrinho(){
        Carrinho carrinho = new Carrinho();
        assertEquals(carrinho.getValor(), 0.00);
    }

    @Test
    void adicionarProduto(){
        Carrinho carrinho = new Carrinho();
        Produto produto = new Produto("Teclado", 100.00);

        carrinho.adicionarProduto(produto);
        assertEquals(100.00,carrinho.getValor());
    }

    @Test
    void adicionarVariosProdutos(){
        Carrinho carrinho = new Carrinho();
        Produto produto1 = new Produto("Teclado", 100.00);
        Produto produto2 = new Produto("Mouse", 50.00);

        carrinho.adicionarProduto(produto1);
        carrinho.adicionarProduto(produto2);
        assertEquals(150.00,carrinho.getValor());
    }

    @Test
    void removerProdutoDoCarrinho(){
        Carrinho carrinho = new Carrinho();
        Produto produto1 = new Produto("Teclado", 100.00);
        Produto produto2 = new Produto("Mouse", 50.00);

        carrinho.adicionarProduto(produto1);
        carrinho.adicionarProduto(produto2);
        carrinho.removerProduto(produto2);
        assertEquals(100.00,carrinho.getValor());
    }

    @Test
    void naoDeveInserirProdutoNegativo(){
        Carrinho carrinho = new Carrinho();
        Produto produto = new Produto("Teclado", -100.00);

        carrinho.adicionarProduto(produto);
        assertEquals(0.00,carrinho.getValor());
    }

    @Test
    void calcularDesconto(){
        Carrinho carrinho = new Carrinho();
        Produto produto = new Produto("Teclado", 600.00);

        carrinho.adicionarProduto(produto);
        assertEquals(540.00,carrinho.getValor());
    }
}
