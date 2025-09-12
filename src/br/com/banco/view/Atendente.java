package br.com.banco.view;

import java.util.Scanner;
import br.com.banco.model.Conta;
import br.com.banco.model.ContaPoupanca;
import br.com.banco.model.ContaCorrente;
import br.com.banco.service.Banco;

public class Atendente {
    Scanner sc = new Scanner(System.in);
    private Banco banco;

    public Atendente(Banco banco) {
        this.banco = banco;
    }

    public int escolhaAcao() {
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
        System.out.print("> ");
        return sc.nextInt();
    }

    public int escolhaConta() {
        System.out.println("\n ------- CONTAS -------");
        System.out.println("|1. Conta Corrente");
        System.out.println("|2. Conta Poupança");
        System.out.println("|3. Outras");
        System.out.println("| -----------------------");
        System.out.print("> ");
        int escolhaConta = sc.nextInt();
        sc.nextLine();
        return escolhaConta;
    }

    //cadastrar

    public String numero() {
        System.out.println("\n Número da conta: ");
        System.out.print("> ");
        return sc.nextLine();
    }

    public String titular() {
        System.out.println("\nNome do titular: ");
        System.out.print("> ");
        return sc.nextLine();
    }

    public double saldo() {
        System.out.println("\nSaldo da conta: ");
        System.out.print("> ");
        return sc.nextDouble();
    }

    public double limite() {
        System.out.println("\nSaldo limite: ");
        System.out.print("> ");
        return sc.nextDouble();
    }

    public double taxaRendimento() {
        System.out.println("\nTaxa de rendimento mensal: ");
        System.out.print("> ");
        return sc.nextDouble();
    }

    //funcionalidades

    public String deposito() {
        System.out.println("\n|---- DEPOSITO ----");
        System.out.println("|Número da Conta:");
        System.out.println("|-----------------");
        System.out.print("> ");
        return sc.nextLine();
    }

    public double valorDeposito() {
        System.out.println("|------------------");
        System.out.println("|Valor a depositar:");
        System.out.println("|------------------");
        System.out.print("> ");
        return sc.nextDouble();
    }

    public String saque() {
        System.out.println("\n|------ SAQUE ------");
        System.out.println("|Número da Conta:");
        System.out.println("|------------------");
        System.out.print("> ");
        return sc.nextLine();
    }

    public double valorSaque() {
        System.out.println("| -----------------");
        System.out.println("|Valor a sacar:");
        System.out.println("| -----------------");
        System.out.print("> ");
        return sc.nextDouble();
    }

    public String enviartransferencia() {
        System.out.println("\n|---- TRANSFERÊNCIA ----");
        System.out.println("|Número da sua Conta:  |");
        System.out.println("|-----------------------");
        System.out.print("> ");
        return sc.nextLine();
    }

    public String receberTransferencia() {
        System.out.println("\n| -----------------");
        System.out.println("|Conta destinatária:");
        System.out.println("| -----------------");
        System.out.print("> ");
        return sc.nextLine();
    }

    public double valorTransferencia() {
        System.out.println("\n| -----------------");
        System.out.println("|Valor:");
        System.out.println("| -----------------");
        System.out.print("> ");
        return sc.nextDouble();
    }

    public String pesquisa() {
        System.out.println("\n| ----- PESQUISA -----");
        System.out.println("|Número da Conta:");
        System.out.println("| --------------------");
        System.out.print("> ");
        return sc.nextLine();
    }

    public String excluir() {
        System.out.println("\n| ----- EXCLUSÃO -----");
        System.out.println("|Número da Conta:");
        System.out.println("| --------------------");
        System.out.println("> ");
        return sc.nextLine();
    }

   //listagem das contas

    public void visualizarConta(Conta conta) {
        System.out.println("|------------------------------------------------------");
        System.out.println(conta);
        System.out.println("\n|------------------------------------------------------");
    }

    public void visualizarCC(ContaCorrente cc) {
        System.out.println("|------------------------------------------------------");
        System.out.println(cc);
        System.out.println("\n|------------------------------------------------------");
    }

    public void visualizarCP(ContaPoupanca cp) {
        System.out.println("|------------------------------------------------------");
        System.out.println(cp);
        System.out.println("\n|------------------------------------------------------");
    }

    public void itemPesquisa(ContaCorrente cc) {
        System.out.println("|------------------------------------------------------");
        System.out.println(cc);
        System.out.println("\n|------------------------------------------------------");
    }

    public void itemPesquisa(ContaPoupanca cp) {
        System.out.println("|------------------------------------------------------");
        System.out.println(cp);
        System.out.println("\n|------------------------------------------------------");
    }

    public void itemPesquisa(Conta c) {
        System.out.println("|------------------------------------------------------");
        System.out.println(c);
        System.out.println("\n|------------------------------------------------------");
    }

    //mensagens

    public void naoEncontrado() {
        System.out.println("\n|--------------------------------------");
        System.out.println("|Conta não encontrada! tente novamente.|");
        System.out.println("|--------------------------------------");
    }

    public void mensagemErro() {
        System.out.println("\n|-----------------------------------");
        System.out.println("|Entrada inválida! Tente novamente.|");
        System.out.println("|-----------------------------------");
    }

    public void sucessoCadastro() {
        System.out.println("\n|-----------------------------------");
        System.out.println("|   Conta cadastrada com sucesso!  |");
        System.out.println("|-----------------------------------");
    }

    public void sucessoExclusao() {
        System.out.println("\n|-----------------------------------");
        System.out.println("|    Conta removida com sucesso!   |");
        System.out.println("|-----------------------------------");
    }

    public void sucessoDeposito() {
        System.out.println("\n|-----------------------------------");
        System.out.println("|   Depósito feito com sucesso!    |");
        System.out.println("|-----------------------------------");
    }

    public void sucessoSaque() {
        System.out.println("\n|--------------------------------");
        System.out.println("|   Saque feito com sucesso!    |");
        System.out.println("|--------------------------------");
    }

    public void sucessoTransferencia(){
        System.out.println("\n|-----------------------------------");
        System.out.println("| Transferência feito com sucesso! |");
        System.out.println("|-----------------------------------");
    }

    public void saldoInsuficiente(){
        System.out.println("\n|-----------------------------------");
        System.out.println("|        Saldo insuficiente!       |");
        System.out.println("|-----------------------------------");
    }

    public void sair() {
        System.out.println("\n Saindo...");
    }
}
