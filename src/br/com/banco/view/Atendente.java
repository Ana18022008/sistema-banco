package br.com.banco.view;
import java.util.Scanner;
import br.com.banco.model.Conta;
import br.com.banco.model.ContaPoupanca;
import br.com.banco.model.ContaCorrente;
import br.com.banco.service.Banco;

public class Atendente {
    Scanner sc = new Scanner(System.in);

    public int escolhaAcao() { //para escolher a ação inicial
        System.out.println("\n -------- MENU --------");
        System.out.println("|1. Cadastrar Conta");//feito
        System.out.println("|2. Depositar");//feito
        System.out.println("|3. Sacar");//feito
        System.out.println("|4. Transferir"); //feito
        System.out.println("|5. Listar Contas");
        System.out.println("|6. Excluir conta");//feito
        System.out.println("|7. Pesquisar por número");//feito
        System.out.println("| -----------------------");
        System.out.println("|0. Sair");
        System.out.println("| -----------------------");
        System.out.println("\n > ");
        int escolhaAcao = sc.nextInt();
        return escolhaAcao;
    }

    public int escolhaConta() { //para escolher a conta
        System.out.println("\n ------- CONTAS -------");
        System.out.println("|1. Conta Corrente");
        System.out.println("|2. Conta Poupança");
        System.out.println("|3. Outras");
        System.out.println("| -----------------------");
        System.out.println("\n > ");
        int escolhaConta = sc.nextInt();
        return escolhaConta;
    }

    public String numero() { //métodos para o cadastro geral
        System.out.println("\n Número da conta: ");
        System.out.println("> ");
        String numero = sc.nextLine();
        return numero;
    }

    public String titular() {
        System.out.println("\nNome do titular: ");
        System.out.println("> ");
        String titular = sc.nextLine();
        return titular;
    }

    public double saldo() {
        System.out.println("\nSaldo da conta: ");
        System.out.println("> ");
        double saldo = sc.nextDouble();
        return saldo;
    }

    public double limite() { //extra da conta corrente
        System.out.println("\nSaldo limite: ");
        System.out.println("> ");
        double limite = sc.nextDouble();
        return limite;
    }

    public double taxaRendimento() { //extra da conta poupança
        System.out.println("\nTaxa de rendimento mensal: ");
        System.out.println("> ");
        double taxaRendimento = sc.nextDouble();
        return taxaRendimento;
    }

    public String deposito() { //conta escolhida para depositar
        System.out.println("\n|---- DEPOSITO ----");
        System.out.println("|Número da Conta:");
        System.out.println("|-----------------");
        System.out.println("> ");
        String numeroDeposito = sc.nextLine();
        return numeroDeposito;
    }

    public double valorDeposito() { //valor a depositar
        System.out.println("|------------------");
        System.out.println("|Valor a depositar:");
        System.out.println("|------------------");
        System.out.println("> ");
        double valorDeposito = sc.nextDouble();
        return valorDeposito;
    }

    public String Saque() { //para saber a conta que fará o saque
        System.out.println("\n|------ SAQUE ------");
        System.out.println("|Número da Conta:");
        System.out.println("|------------------");
        System.out.println("> ");
        String numeroSaque = sc.nextLine();
        return numeroSaque;
    }

    public double valorSaque() { //para saber o valor do saque
        System.out.println("| -----------------");
        System.out.println("|Valor a sacar:");
        System.out.println("| -----------------");
        System.out.println("> ");
        double valorSaque = sc.nextDouble();
        return valorSaque;
    }

    public String enviartransferencia() {
        System.out.println("\n|----- DEPÓSITO -----");
        System.out.println("|Número da sua Conta:");
        System.out.println("|--------------------");
        System.out.println("> ");
        String enviartransferencia = sc.nextLine();
        return enviartransferencia;
    }

    public String receberTransferencia() {
        System.out.println("\n| -----------------");
        System.out.println("|Conta destinatária:");
        System.out.println("| -----------------");
        System.out.println("> ");
        String receberTransferencia = sc.nextLine();
        return receberTransferencia;
    }

    public double valorTransferencia() {
        System.out.println("\n| -----------------");
        System.out.println("|Valor:");
        System.out.println("| -----------------");
        System.out.println("> ");
        double valorTransferencia = sc.nextDouble();
        return valorTransferencia;
    }

    public String pesquisa() { //para pesquisar uma conta pelo número
        System.out.println("\n| ----- PESQUISA -----");
        System.out.println("|Número da Conta:");
        System.out.println("| --------------------");
        System.out.println("> ");
        String numeroPesquisa = sc.nextLine();
        return numeroPesquisa;
    }

    public void visualizarConta(Conta conta) { //visualizar contas
        System.out.println("|------------------------------------------------------");
        System.out.println(conta);
        System.out.println("\n|------------------------------------------------------");
    }

    public void visualizarCC(ContaCorrente cc) {
        System.out.println("|------------------------------------------------------");
        System.out.println(cc);
        System.out.println("\n|------------------------------------------------------");
    }

    public void visualizarCp(ContaPoupanca cp) {
        System.out.println("|------------------------------------------------------");
        System.out.println(cp);
        System.out.println("\n|------------------------------------------------------");
    }

    public String excluir() { //Para excluir uma conta pelo número
        System.out.println("\n| ----- EXCLUSÃO -----");
        System.out.println("|Número da Conta:");
        System.out.println("| --------------------");
        System.out.println("> ");
        String numeroExcluir = sc.nextLine();
        return numeroExcluir;
    }

    public void naoEncontrado() { //Caso o sistema não encontre a conta/ número
        System.out.println("\n|--------------------------------------");
        System.out.println("|Conta não encontrada! tente novamente|");
        System.out.println("|--------------------------------------");
    }

    public void mensagemErro() { //mensagens para caso de erro
        System.out.println("\n|-----------------------------------");
        System.out.println("|Entrada inválida! Tente novamente.|");
        System.out.println("|-----------------------------------");
    }

    public void sair() {
        System.out.println("\n Saindo...");
    }
}