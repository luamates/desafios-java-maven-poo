package com.amates.desafiospoo.nivel4gestaodedelivery;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Produto> produtos = new ArrayList<>();
    static ArrayList<Pedido> pedidos = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("%n===== SISTEMA DE PEDIDOS =====");

        boolean continuar = true;

        while (continuar) {
            continuar = mainMenu(scanner);
        }

        scanner.close();
    }

    public static boolean mainMenu(Scanner scanner) {

        System.out.printf("%n-> Menu principal");
        System.out.printf("%n1 - Cadastrar produto");
        System.out.printf("%n2 - Cadastrar cliente");
        System.out.printf("%n3 - Criar pedido");
        System.out.printf("%n4 - Modificar pedido");
        System.out.printf("%n5 - Sair");
        System.out.printf("%nSua seleção: ");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                cadastrarProduto(scanner);
                break;
            case 2:
                cadastrarCliente(scanner);
                break;
            case 3:
                criarPedido(scanner);
                break;
            case 4:
                selecionarPedido(scanner); // fazer um outro metodo seletor e, do seletor, mandar para o modificar pedido com o indice do arrayList
                break;
            case 5:
                return false;
            default:
                System.out.printf("%n%nOpção inválida!");
                break;
        }
        return true;
    }

    public static void cadastrarProduto(Scanner scanner) {
        System.out.printf("%n%n===== CADASTRO DE PRODUTO ===== %nDigite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.printf("%nDigite o preço do produto: ");
        Double preco = scanner.nextDouble();
        scanner.nextLine();

        Produto produto = new Produto(nome, preco);
        produtos.add(produto);

        System.out.printf("%nO produto %s foi criado com sucesso!%n", produto.getNome());
    }

    public static void cadastrarCliente(Scanner scanner) {

        System.out.printf("%n%n===== CADASTRO DE CLIENTE ===== %nDigite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.printf("%nDigite o endereço: ");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente(nome, endereco);
        clientes.add(cliente);

        System.out.printf("%nO cliente %s foi criado com sucesso!%n", cliente.getNome());
    }


    public static void criarPedido(Scanner scanner) {
        System.out.printf("%n%n===== CRIAÇÃO DE PEDIDO ===== %n");

        for(int i = 0 ; i < clientes.size() ; i++){
            System.out.printf("%nID: %d | Nome: %s", i, clientes.get(i).getNome());
        }

        System.out.printf("%nDigite o ID do cliente: ");
        int id = scanner.nextInt();

        System.out.printf("%nDigite a taxa de entrega: ");
        double taxa = scanner.nextDouble();

        System.out.printf("%nForma de pagamento: %n1 - Cartão %n2 - Pix%n3 - Dinheiro %nSua seleção: ");
        int pagamento = scanner.nextInt();
        scanner.nextLine();

        System.out.printf("%nIndique o valor de desconto. Caso não se aplique, digite 0: ");
        double desconto = scanner.nextDouble();

        Pedido pedido = new Pedido(clientes.get(id), taxa, pagamento, desconto);
        pedidos.add(pedido);

        System.out.printf("%nPedido (ID %d) criado com sucesso! %nDeseja adicionar mais informações? %n1 - Sim %n2 - Não %nSua seleção: ", produtos.size());

        int option = scanner.nextInt();
        scanner.nextLine();
        if(option == 1) modificarPedido(scanner, pedidos.size(), 1); //chamar o modificar pedido para o úlitimo adicionado, que é o que acabou de fazer no met. criarPedido.

    }


    public static void selecionarPedido(Scanner scanner){
        for(int i = 0 ; i < pedidos.size() ; i++){
            System.out.printf("%n%naqui terá os pedidos!%n%n");


        }

    }


    public static void modificarPedido(Scanner scanner, int idPedido, int fonteDaSolicitacao) {
        int posicaoPedido = idPedido - 1;

Pedido p = pedidos.get(posicaoPedido);

        if(p.calcularTotalBruto() == 0 && fonteDaSolicitacao != 1){
            System.out.printf("%nAinda não há itens nesse pedido!");

        } else {
            p.mostrarPedido();
        }

        while(true){
            System.out.printf("%nMenu do pedido %n1 - Adicionar item %n2 - Remover item %n3 - Extrato do pedido %n4 - Voltar ao menu principal%nSua seleção: ");
            int selection = scanner.nextInt();
            scanner.nextLine();

            switch(selection){
                case 1:
                    System.out.printf("%nADICIONAR ITEM DO MENU:");
                    mostrarMenu();
                    System.out.printf("%nDigite o ID do item a adicionar: ");
                    int idItem = scanner.nextInt();

                    System.out.printf("%nDigite a quantidade: ");
                    int qtdItem = scanner.nextInt();

                    p.adicionaritem(produtos.get(idItem), qtdItem);
                    System.out.printf("%n%nItem foi adicionado!");
                    break;
                case 2:
                    System.out.printf("%nREMOVER ITEM DO PEDIDO:");
                    p.mostrarPedido();
                    System.out.printf("%nDigite o nome do item a ser retirado:");
                    String itemretirar = scanner.nextLine();
                    p.removerItem(itemretirar);
                    break;
                case 3:
                    p.mostrarPedido();
                    System.out.println(p);
                    break;
                case 4:
                    return;
                default:
                    System.out.printf("%n%nOpção inválida!");
                    break;
            }



        }











    }

    public static void mostrarMenu(){
        for(int i = 0 ; i < produtos.size() ; i++){
            System.out.printf("%nID %d | Produto: %s | Preço: R$ %.2f", i, produtos.get(i).getNome(), produtos.get(i).getPreco());
        }




    }









}
