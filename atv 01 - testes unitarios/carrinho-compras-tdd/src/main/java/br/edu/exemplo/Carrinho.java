package br.edu.exemplo;

public class Carrinho {

    private double valor;

    public Carrinho(){
        this.valor = 0;
    }
    public double getValor() {
        return this.valor;
    }

    public void adicionarProduto(Produto produto) {
        if(produto.getPreco() < 0)
            return;

        this.valor += produto.getPreco();

        if(this.valor >= 500.00)
            this.valor *= 0.90;
    }

    public void removerProduto(Produto produto2) {
        this.valor -= produto2.getPreco();
    }

    // Implemente esta classe seguindo a sequência de requisitos
    // apresentada em REQUISITOS.md e utilizando TDD.

}
