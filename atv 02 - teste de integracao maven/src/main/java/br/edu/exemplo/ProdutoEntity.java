package br.edu.exemplo;

import java.util.Objects;

public final class ProdutoEntity {
    private final String nome;
    private final int quantidade;

    public ProdutoEntity(String nome) {
        this(nome, 1);
    }

    public ProdutoEntity(String nome, int quantidade) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do produto e obrigatorio");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade nao pode ser negativa");
        }
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (!(objeto instanceof ProdutoEntity produto)) {
            return false;
        }
        return nome.equals(produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
