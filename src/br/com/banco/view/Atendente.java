package br.com.banco.view;
import java.util.Scanner;

public class Atendente {
    Scanner sc = new Scanner(System.in);

    public int escolhaAcao(){ //para escolher a ação inicial
        System.out.println("\n -------- MENU --------");
        System.out.println("|1. Cadastrar Conta");
        System.out.println("|2. Depositar");
        System.out.println("|3. Sacar");
        System.out.println("|4. Transferir");
        System.out.println("|5. Listar Contas");
        System.out.println("|6. Excluir conta");
        System.out.println("|7. Pesquisar por número");
        System.out.println("| -----------------------");
        System.out.println("|0. Sair");
        System.out.println("| -----------------------");
        System.out.println("\n > ");
        int escolhaAcao = sc.nextInt();
        return escolhaAcao;
    }

    public int escolhaConta(){ //para escolher a conta
        System.out.println("\n ------- CONTAS -------");
        System.out.println("|1. Conta Corrente");
        System.out.println("|2. Conta Poupança");
        System.out.println("|3. Outras");
        System.out.println("| -----------------------");
        System.out.println("\n > ");
        int escolhaConta = sc.nextInt();
        return escolhaConta;
    }

    public String numero(){ //métodos para o cadastro geral
        System.out.println("\n Número da conta: ");
        System.out.println("> ");
        String numero = sc.nextLine();
        return numero;
    }

    public String titular(){
        System.out.println("\nNome do titular: ");
        System.out.println("> ");
        String titular = sc.nextLine();
        return titular;
    }

    public double saldo(){
        System.out.println("\nSaldo da conta: ");
        System.out.println("> ");
        double saldo = sc.nextDouble();
        return saldo;
    }

    public double limite(){ //extra da conta corrente
        System.out.println("\nSaldo limite: ");
        System.out.println("> ");
        double limite = sc.nextDouble();
        return limite;
    }

    public double taxaRendimento(){ //extra da conta poupança
        System.out.println("\nTaxa de rendimento mensal: ");
        System.out.println("> ");
        double taxaRendimento = sc.nextDouble();
        return taxaRendimento;
    }

    public String Saque(){ //para saber a conta que fará o saque
        System.out.println("\n| ----- SAQUE -----");
        System.out.println("|Número da Conta:");
        System.out.println("| -----------------");
        System.out.println("> ");
        String numeroSaque = sc.nextLine();
        return numeroSaque;
    }

    public double valorSaque(){ //para saber o valor do saque
        System.out.println("| -----------------");
        System.out.println("|Valor a sacar:");
        System.out.println("| -----------------");
        System.out.println("> ");
        double valorSaque = sc.nextDouble();
        return valorSaque;
    }

    public String pesquisa(){ //para pesquisar uma conta pelo número
        System.out.println("\n| ----- PESQUISA -----");
        System.out.println("|Número da Conta:");
        System.out.println("| --------------------");
        System.out.println("> ");
        String numeroPesquisa = sc.nextLine();
        return numeroPesquisa;
    }

    public String excluir(){ //Para excluir uma conta pelo número
        System.out.println("\n| ----- EXCLUSÃO -----");
        System.out.println("|Número da Conta:");
        System.out.println("| --------------------");
        System.out.println("> ");
        String numeroExcluir = sc.nextLine();
        return numeroExcluir;
    }

    public void naoEncontrado(){ //Caso o sistema não encontre a conta/ número
        System.out.println("\n|--------------------------------------");
        System.out.println("|Conta não encontrada! tente novamente|");
        System.out.println("|--------------------------------------");
    }

    public void mensagemErro(){ //mensagens para caso de erro
        System.out.println("\n|-----------------------------------");
        System.out.println("|Entrada inválida! Tente novamente.|");
        System.out.println("|-----------------------------------");
    }

    public void sair(){
        System.out.println("\n Saindo...");
    }





}
