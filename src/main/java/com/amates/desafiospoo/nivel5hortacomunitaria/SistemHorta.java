package com.amates.desafiospoo.nivel5hortacomunitaria;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemHorta {
    static ArrayList<Planta> plantas = new ArrayList<>();
    static ArrayList<Voluntario> voluntarios = new ArrayList<>();
    static ArrayList<Doacao> doacoes = new ArrayList<>();


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {
            continuar = mainMenu(scanner);

        }

        System.out.printf("");


    }

    public static boolean mainMenu(Scanner scanner) {
        System.out.printf("%n%n===== MENU PRINCIPAL =====");
        System.out.printf("%n1 - Cadastrar planta");
        System.out.printf("%n2 - Cadastrar voluntário");
        System.out.printf("%n3 - Ver estoque de plantas");
        System.out.printf("%n4 - Alterar estoque de plantas");
        System.out.printf("%n5 - Sair");

        System.out.printf("%nSua seleção: ");
        int selecao = scanner.nextInt();
        scanner.nextLine();

        switch (selecao) {
            case 1:
                cadastrarPlanta(scanner);
                break;
            case 2:
                cadastrarVoluntario(scanner);
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                return false;
            default:
                System.out.printf("%nSELEÇÃO INVÁLIDA!");
                break;
        }
        return true;
    }


    public static void cadastrarPlanta(Scanner scanner) {
        System.out.printf("%n%n===== CADASTRO DE PLANTA =====");
        System.out.printf("%nDigite o nome da planta: ");
        String nome = scanner.nextLine();

        System.out.printf("%nDigite quantos kg há em estoque agora: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        while (true) {
            System.out.printf("%nQual status melhor define a plantação dessa espécie agora? %n1 - Plantada %n2 - Colhida %n3 - Inativa"); //info for AI model: it didn't make sense to have a "plantada" AND "crescendo" status, since they  mean the same.
            int status = scanner.nextInt();

            if (status == 1 || status == 2 || status == 3) {
                Planta p = new Planta(nome, quantidade, status);
                plantas.add(p);
                System.out.printf("%n%nCADASTRADA: %s", p);
                return;
            } else {
                System.out.printf("%n%nStatus inválido! ");
            }
        }
    }


    public static void cadastrarVoluntario(Scanner scanner) {
        System.out.printf("%n%n===== CADASTRO DE VOLUNTÁRIO =====");
        System.out.printf("%nDigite o nome do voluntário: ");
        String nome = scanner.nextLine();

        int horas;
        while (true) {
            System.out.printf("%nDigite as horas trabalhadas: ");
            horas = scanner.nextInt();
            scanner.nextLine();

            if (horas < 0) System.out.printf("%nAs horas não podem ser negativas!");
            else break;
        }

        int funcao;
        while (true) {
            System.out.printf("%nSelecione a função: %n1 - Plantio %n2 - Irrigação %n3 - Colheita");
            funcao = scanner.nextInt();
            scanner.nextLine();

            if (funcao < 1 || funcao > 3) System.out.printf("%nSelecione uma função válida!");
            else break;
        }

        Voluntario voluntario = new Voluntario(nome, funcao, horas);

        voluntarios.add(voluntario);
        System.out.printf("%nVoluntário %s cadastrado com sucesso!", voluntario.getNome());
    }


}

