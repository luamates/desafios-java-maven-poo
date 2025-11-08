package com.amates.desafiospoo.nivel3gestaodefuncionarios;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxFuncionarios = startApp(scanner);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        for (int i = 0; i < maxFuncionarios; i++) {
            scanner.nextLine(); //consumir enter
            cadastrarFuncionarios(scanner, funcionarios);
        }

        listarFuncionarios(funcionarios);

        boolean continuar = true;
        while (continuar) {
            continuar = selecionarFuncionario(scanner, funcionarios);
            listarFuncionarios(funcionarios);
        }
    }

    public static int startApp(Scanner scanner) {
        System.out.printf("%nQuantos funcionários deseja cadastrar no sistema? ");
        return scanner.nextInt();
    }

    public static void cadastrarFuncionarios(Scanner scanner, ArrayList<Funcionario> funcionarios) {
        Funcionario funcionario = new Funcionario();
        funcionarios.add(funcionario);

        System.out.printf("%n%nCADASTRO DE FUNCIONÁRIO (Matrícula %d) %nDigite o nome: ", (funcionarios.size()));
        funcionario.setNome(scanner.nextLine());

        System.out.printf("%nDigite o cargo: ");
        funcionario.setCargo(scanner.nextLine());

        System.out.printf("%nDigite o salário: R$ ");
        funcionario.setSalario(scanner.nextDouble());
        scanner.nextLine();

        System.out.printf("%n%nFuncionário %s cadastrado com sucesso!", funcionario.getNome());
    }

    public static void listarFuncionarios(ArrayList<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.toString());
        }
    }

    public static boolean selecionarFuncionario(Scanner scanner, ArrayList<Funcionario> funcionarios) {
        System.out.printf("%nDeseja dar aumento salarial para qual colaborador? (para sair, digite 'sair') ");
        String nome = scanner.nextLine();

        if (nome.equalsIgnoreCase("Sair")) {
            return false;
        }

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                aumentarSalario(scanner, funcionario);
                scanner.nextLine();
                return true;
            }
        }
        System.out.printf("%n%nNENHUM COLABORADOR COM ESTE NOME!");
        return true;
    }

    public static void aumentarSalario(Scanner scanner, Funcionario funcionario) {
        System.out.printf("%nMUDAR O SALÁRIO %nDigite o número do percentual (ex. 30): ");
        funcionario.aumentarSalario(scanner.nextDouble());

        System.out.printf("%nFeito com sucesso!");
    }
}









