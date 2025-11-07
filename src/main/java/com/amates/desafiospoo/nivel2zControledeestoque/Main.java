package com.amates.desafiospoo.nivel2zControledeestoque;

//Crie uma classe Produto, com:
//nome (String)
//preco (double)
//quantidade (int)
//
//Métodos:
//adicionarEstoque(int qtd)
//removerEstoque(int qtd)
//valorTotalEmEstoque() → retorna preco * quantidade
//toString() para exibir os dados formatados
//
//Na classe Main:
//Peça ao usuário os dados de um produto.
//Mostre o produto cadastrado.
//Pergunte quantas unidades deseja adicionar ao estoque, atualize e mostre o resultado.
//Depois pergunte quantas unidades deseja remover, atualize e mostre o resultado final.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto produto = new Produto();
        setInformation(scanner, produto);

        System.out.printf("%n%nProduto cadastrado: " + produto.toString());

        System.out.printf("%nDeseja adicionar quantas unidades? ");
        produto.adicionarEstoque(scanner.nextInt());
        System.out.println("Novo estoque: " + produto.toString());


        System.out.printf("%nDeseja remover quantas unidades? ");
        produto.removerEstoque(scanner.nextInt());
        System.out.println("Estoque atualizado: " + produto.toString());
    }

    public static void setInformation(Scanner scanner, Produto produto) {
        System.out.printf("%n%nDigite os dados do produto: ");

        System.out.printf("%nNome: ");
        produto.setNome(scanner.next());

        System.out.printf("%nPreço: ");
        produto.setPreco(scanner.nextDouble());

        System.out.printf("%nQuantidade: ");
        produto.setQuantidade(scanner.nextInt());
    }
}
