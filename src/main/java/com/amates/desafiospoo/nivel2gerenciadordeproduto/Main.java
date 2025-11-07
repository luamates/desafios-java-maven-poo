package com.amates.desafiospoo.nivel2gerenciadordeproduto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Produto> produtos = new ArrayList<>(3);


    public void main() {
        Scanner scanner = new Scanner(System.in);

        for(int i = 0 ; i < 3 ; i++){
            System.out.printf("%n%n%n=== CADASTRO DE PRODUTOS ===");
            System.out.printf("%n%nProduto %d", (i+1));
            Produto p = new Produto();

            System.out.printf("%nNome: ");
            p.setNome(scanner.nextLine());
            scanner.nextLine();

            System.out.printf("%nPreço: ");
            p.setPreco(scanner.nextDouble());

            System.out.printf("%nQuantidade: ");
            p.setQuantidade(scanner.nextInt());

            produtos.add(p);
        }

        System.out.printf("%n%n%nPRODUTOS CADASTRADOS%n");

        for (Produto produto : produtos){
            System.out.println(produto);
            System.out.printf("Valor total em estoque: R$ %.2f%n%n", produto.valorEmEstoque());
        }


    }

}
