package br.edu.exemplo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EstoqueService {
    private final List<ProdutoEntity> produtos;

    public EstoqueService(List<ProdutoEntity> produtos) {
        if (produtos == null) {
            throw new IllegalArgumentException("A lista de produtos e obrigatoria");
        }
        this.produtos = new ArrayList<>(produtos);
    }

    public boolean temEstoque(ProdutoEntity produtoSolicitado) {
        if (produtoSolicitado == null) {
            return false;
        }
        return produtos.stream()
                .anyMatch(produto -> produto.equals(produtoSolicitado)
                        && produto.getQuantidade() >= produtoSolicitado.getQuantidade());
    }

    public void retirar(ProdutoEntity produtoSolicitado) {
        if (!temEstoque(produtoSolicitado)) {
            throw new IllegalArgumentException("Produto sem estoque suficiente");
        }
        for (int indice = 0; indice < produtos.size(); indice++) {
            ProdutoEntity produto = produtos.get(indice);
            if (produto.equals(produtoSolicitado)) {
                produtos.set(indice, new ProdutoEntity(
                        produto.getNome(),
                        produto.getQuantidade() - produtoSolicitado.getQuantidade()));
                return;
            }
        }
    }

    public List<ProdutoEntity> getProdutos() {
        return Collections.unmodifiableList(new ArrayList<>(produtos));
    }
}
