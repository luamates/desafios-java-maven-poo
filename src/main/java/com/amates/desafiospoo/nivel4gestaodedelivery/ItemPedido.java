package com.amates.desafiospoo.nivel4gestaodedelivery;

import java.util.SplittableRandom;

public class ItemPedido {
    private Produto produto;
    private Integer quantidade;
    private Double subtotal;

    public ItemPedido(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = produto.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return String.format("%nProduto: %s | Qtd.: %d | R$ %.2f", this.produto.getNome(), this.quantidade, this.subtotal);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
