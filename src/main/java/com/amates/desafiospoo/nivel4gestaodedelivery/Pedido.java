package com.amates.desafiospoo.nivel4gestaodedelivery;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<ItemPedido> itens = new ArrayList<>();

    private final Cliente cliente;
    private final Double taxaEntrega;
    private final Double desconto;

    public Pedido(Cliente cliente, Double taxaentrega, Integer metodo) {
        this.cliente = cliente;
        this.taxaEntrega = taxaentrega;

        if(metodo == 1) this.desconto = 1.05;
        else if (metodo == 2) this.desconto = 0.97;
        else this.desconto = (double) 1;

    }

    @Override
    public String toString() { //no main, chamar primeiro o mostrar pedido e dps o toString
        return String.format("%nSubtotal: R$ %.2f %nDesconto: R$ %.2f %nEntrega: %.2f %nTotal final: R$ %.2f%n", calcularTotalBruto(), this.desconto, this.taxaEntrega, calcularTotalFinal());
    }

    public void adicionaritem(Produto produto, int quantidade) {
        for (ItemPedido item : itens) {
            if (produto.getNome().equalsIgnoreCase(item.getProduto().getNome())) {
                System.out.printf("%n%no produto já foi cadastrado.");
                return;
            }
        }
        ItemPedido item = new ItemPedido(produto, quantidade);
        itens.add(item);
    }

    public void removerItem(String nomeProduto) {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getProduto().getNome().equalsIgnoreCase(nomeProduto)) {
                itens.remove(i);
                System.out.printf("%nProduto removido com sucesso!");
                return;
            }
        }
        System.out.printf("%nProduto não localizado no pedido.");
    }

    public void mostrarPedido() {
        System.out.printf("%n%nRESUMO DO PEDIDO: %nCliente: %s%nItens: ", cliente.getNome());

        for(int x = 0 ; x < itens.size() ; x++){
            System.out.println("%nID " + x + " | " + itens.get(x).toString());
        }
    }

    public double calcularTotalBruto() {
        double totalBruto = 0;

        for (ItemPedido item : itens) {
            totalBruto += item.getSubtotal();
        }
        return totalBruto;
    }

    public double calcularTotalFinal() {
        return (calcularTotalBruto() + this.taxaEntrega) * this.desconto;
    }

}

