package com.amates.desafiospoo.nivel2gerenciadordeproduto;

public class Produto {

    private String nome;
    private Double preco;
    private Integer quantidade;

    public Double valorEmEstoque(){
        return preco * quantidade;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + " | Preço: " + preco + " | Quantidade: " + quantidade;
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
