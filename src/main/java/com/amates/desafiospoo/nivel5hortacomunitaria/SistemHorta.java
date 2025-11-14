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
        System.out.printf("%n5 - Cadastrar doação");
        System.out.printf("%n6 - Ver doações");
        System.out.printf("%n7 - Sair");

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
                verPlantas();
                break;
            case 4:
                selecionarPlanta(scanner);
                break;
            case 5:
                cadastrarDoacao(scanner);
                break;
            case 6:

                break;
            case 7:
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
            System.out.printf("%nQual status melhor define a plantação dessa espécie agora? %n1 - Plantada %n2 - Colhida %n3 - Inativa %nSua escolha: "); //info for my AI model: it didn't make sense to have a "plantada" AND "crescendo" status, since they  mean the same.
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
            System.out.printf("%nSelecione a função: %n1 - Plantio %n2 - Irrigação %n3 - Colheita %nSua escolha: ");
            funcao = scanner.nextInt();
            scanner.nextLine();

            if (funcao < 1 || funcao > 3) System.out.printf("%nSelecione uma função válida!");
            else break;
        }

        Voluntario voluntario = new Voluntario(nome, funcao, horas);

        voluntarios.add(voluntario);
        System.out.printf("%nVoluntário %s cadastrado com sucesso!", voluntario.getNome());
    }

    public static void verPlantas() {
        for (Planta p : plantas) {
            System.out.println(p);
        }
    }

    public static void selecionarPlanta(Scanner scanner) {
        System.out.printf("%n%n===== ATUALIZAR ESTOQUE =====");

        for (int i = 0; i < plantas.size(); i++) {
            System.out.printf("%nID: %d | Planta: %s | Estoque: %d kg.", i, plantas.get(i).getNome(), plantas.get(i).getQuantidadeEstocada());
        }
        System.out.printf("%nDigite o ID da planta a atualizar o estoque: ");
        int selecao = scanner.nextInt();

        try {
            System.out.printf("%nAlterando o estoque da planta %s.", plantas.get(selecao).getNome());
            alterarEstoque(scanner, selecao);
        } catch (Exception e) {
            System.out.printf("%n%nO ID de planta é inválido!");
        }

    }

    public static void alterarEstoque(Scanner scanner, int id) {
        System.out.printf("%nQual deve ser o novo estoque? [em kg]: ");
        plantas.get(id).setQuantidadeEstocada(scanner.nextInt());
        scanner.nextLine();

        System.out.printf("%nQual status melhor define a plantação dessa espécie agora? %n1 - Plantada %n2 - Colhida %n3 - Inativa %nSua escolha: ");
        int status = scanner.nextInt();

        if (status == 1 || status == 2 || status == 3) {
            plantas.get(id).setStatus(status);
        }

        System.out.printf("Dados atualizados: %n%s", plantas.get(id).toString());
    }

    public static void cadastrarDoacao(Scanner scanner) {
        System.out.printf("%n%n===== CADASTRO DE DOAÇÃO ===== %nDigite o nome da família beneficiária: ");
        String familia = scanner.nextLine();

        for (int i = 0; i < voluntarios.size(); i++) {
            System.out.printf("%nID: %d | Voluntário: %s.", i, voluntarios.get(i).getNome());
        }

        System.out.printf("%nDigite o ID do voluntário responsável: ");
        int voluntarioResponsavel = scanner.nextInt();
        scanner.nextLine();

        Doacao doacao = new Doacao(familia, voluntarios.get(voluntarioResponsavel));
        doacoes.add(doacao);

        while(true){
            for (int i = 0; i < plantas.size(); i++) {
                System.out.printf("%nID: %d | Planta: %s | Estoque: %d kg.", i, plantas.get(i).getNome(), plantas.get(i).getQuantidadeEstocada());
            }

            System.out.printf("%nDigite o ID da planta para adicionar: ");
            int selecao = scanner.nextInt();

            System.out.printf("%nDigite a quantidade doada (em kg) da planta: ");
            int quantidade = scanner.nextInt();


            int atual = plantas.get(selecao).getQuantidadeEstocada();

            plantas.get(selecao).setQuantidadeEstocada(atual - quantidade);
            doacao.adicionarItem(plantas.get(selecao), quantidade);

            System.out.printf("%nAdicionado com sucesso! %nDeseja adicionar mais itens? %n1 - Sim %n2 - Não (finalizar e bloquear doação) %nSua seleção: ");
            int adicao = scanner.nextInt();

            if(adicao == 2) break;
        }

        System.out.printf("%n%nResumo da doação: ");
        System.out.println(doacao);
        doacao.mostrarItens();
    }


}

