package com.amates.desafiospoo.nivel2zControledeestoque;

public class Produto {

    private String nome;
    private Double preco;
    private Integer quantidade;


    public void adicionarEstoque(int qtd) {
        this.quantidade += qtd;
    }

    public void removerEstoque(int qtd) {
        this.quantidade -= qtd;
    }

    public double valorTotalEmEstoque() {
        return (preco * quantidade);
    }

    @Override
    public String toString() {
        return String.format("%s %nPreço: R$%.2f %nQuantidade: %d %nTotal: R$%.2f%n", nome, preco, quantidade, valorTotalEmEstoque());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
