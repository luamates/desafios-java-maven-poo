package com.amates.desafiospoo.nivel1fichadepessoa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();

        System.out.printf("%nDigite o nome da pessoa: ");
        pessoa.setNome(scanner.nextLine());

        System.out.printf("%nDigite a idade da pessoa: ");
        pessoa.setIdade(scanner.nextInt());
        scanner.nextLine();

        System.out.printf("%nDigite a cidade da pessoa: ");
        pessoa.setCidade(scanner.nextLine());

        pessoa.exibirFicha();
    }
}
