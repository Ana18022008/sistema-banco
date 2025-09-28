package br.com.banco.view;


import java.util.InputMismatchException;
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


    // ======================
    // MÉTODOS AUXILIARES
    // ======================
    private int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int valor = sc.nextInt();
                sc.nextLine(); // consumir \n
                return valor;
            } catch (InputMismatchException e) {
                sc.nextLine(); // limpar buffer
                mensagemErro();
            }
        }
    }


    private double lerDoublePositivo(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                double valor = sc.nextDouble();
                sc.nextLine();
                if (valor <= 0) {
                    System.out.println("| Valor deve ser maior que zero!");
                    continue;
                }
                return valor;
            } catch (InputMismatchException e) {
                sc.nextLine(); // limpar buffer
                mensagemErro();
            }
        }
    }


    // já valida intervalo (min..max)
    private int lerOpcaoMenu(String mensagem, int min, int max) {
        int opcao;
        do {
            opcao = lerInteiro(mensagem);
            if (opcao < min || opcao > max) {
                mensagemErro();
            }
        } while (opcao < min || opcao > max);
        return opcao;
    }


    private String lerStringNaoVazia(String mensagem) {
        String valor;
        do {
            System.out.print(mensagem);
            valor = sc.nextLine().trim();
            if (valor.isEmpty()) {
                System.out.println("|Entrada inválida! Tente novamente.|");
            }
        } while (valor.isEmpty());
        return valor;
    }


    // ======================
    // MENUS
    // ======================
    public int escolhaAcao() {
        System.out.println("\n -------- MENU --------");
        System.out.println("|1. Cadastrar Conta");
        System.out.println("|2. Depositar");
        System.out.println("|3. Sacar");
        System.out.println("|4. Transferir");
        System.out.println("|5. Listar Contas");
        System.out.println("|6. Excluir conta");
        System.out.println("|7. Pesquisar por número");
        System.out.println("|0. Voltar");
        System.out.println("|-----------------------");
        return lerOpcaoMenu("> ", 0,7);
    }


    public int escolhaAcaoUsuario(){
        System.out.println("\n -------- MENU --------");
        System.out.println("|1. Cadastrar Conta");
        System.out.println("|2. Transferir ");
        System.out.println("|0. Voltar");
        System.out.println("|-----------------------");
        return lerOpcaoMenu("> ", 0,2);
    }


    public int escolhaConta() {
        System.out.println("\n ------- CONTAS -------");
        System.out.println("|1. Conta Corrente");
        System.out.println("|2. Conta Poupança");
        System.out.println("|3. Outras");
        System.out.println("|0. Voltar");
        return lerOpcaoMenu("> ",0,3);
    }
    public int login(){
        System.out.println("\n|---- LOGIN ----");
        System.out.println("|1.Criar conta");
        System.out.println("|2.Fazer login");
        System.out.println("|0. Sair");
        return lerOpcaoMenu("> ",0,2);
    }


    // ======================
    // LOGIN E CADASTRO
    // ======================
    public String user() {
        System.out.println("\n|---- USUÁRIO ----");
        System.out.println("|Insira seu user:");
        return lerStringNaoVazia("> ");
    }


    public String password() {
        System.out.println("\n|Insira sua senha:");
        return lerStringNaoVazia("> ");
    }


    public String numero() {
        System.out.println("\nNúmero da conta:");
        return lerStringNaoVazia("> ");
    }


    public String titular() {
        System.out.println("\nNome do titular:");
        return lerStringNaoVazia("> ");
    }


    public double saldo() {
        return lerDoublePositivo("\nSaldo da conta:\n> ");
    }


    public double limite() {
        return lerDoublePositivo("\nSaldo limite:\n> ");
    }


    public double taxaRendimento() {
        return lerDoublePositivo("\nTaxa de rendimento mensal:\n> ");
    }


    // ======================
    // FUNCIONALIDADES
    // ======================
    public String deposito() {
        System.out.println("\n|---- DEPÓSITO ----");
        System.out.println("|Número da Conta:");
        return lerStringNaoVazia("> ");
    }


    public double valorDeposito() {
        return lerDoublePositivo("|Valor a depositar:\n> ");
    }


    public String saque() {
        System.out.println("\n|------ SAQUE ------");
        System.out.println("|Número da Conta:");
        return lerStringNaoVazia("> ");
    }


    public double valorSaque() {
        return lerDoublePositivo("|Valor a sacar:\n> ");
    }


    public String enviartransferencia() {
        System.out.println("\n|---- TRANSFERÊNCIA ----");
        System.out.println("|Número da sua Conta:");
        return lerStringNaoVazia("> ");
    }


    public String receberTransferencia() {
        System.out.println("\n|Conta destinatária:");
        return lerStringNaoVazia("> ");
    }


    public double valorTransferencia() {
        return lerDoublePositivo("|Valor:\n> ");
    }


    public String pesquisa() {
        System.out.println("\n| ----- PESQUISA -----");
        System.out.println("|Número da Conta:");
        return lerStringNaoVazia("> ");
    }


    public String excluir() {
        System.out.println("\n| ----- EXCLUSÃO -----");
        System.out.println("|Número da Conta:");
        return lerStringNaoVazia("> ");
    }


    // ======================
    // LISTAGENS
    // ======================
    public void visualizarConta(Conta conta) {
        System.out.println("|------------------------------------------------------");
        System.out.println(conta);
        System.out.println("|------------------------------------------------------");
    }


    public void visualizarCC(ContaCorrente cc) {
        System.out.println("|------------------------------------------------------");
        System.out.println(cc);
        System.out.println("|------------------------------------------------------");
    }


    public void visualizarCP(ContaPoupanca cp) {
        System.out.println("|------------------------------------------------------");
        System.out.println(cp);
        System.out.println("|------------------------------------------------------");
    }


    public void itemPesquisa(Conta c) {
        System.out.println("|------------------------------------------------------");
        System.out.println(c);
        System.out.println("|------------------------------------------------------");
    }


    // ======================
    // MENSAGENS
    // ======================
    public void naoEncontrado() {
        System.out.println("\n|Conta não encontrada! Tente novamente.|");
    }


    public void mensagemErro() {
        System.out.println("\n|Entrada inválida! Tente novamente.|");
    }


    public void sucessoCadastro() {
        System.out.println("\n|Conta cadastrada com sucesso!|");
    }


    public void sucessoExclusao() {
        System.out.println("\n|Conta removida com sucesso!|");
    }


    public void sucessoDeposito() {
        System.out.println("\n|Depósito feito com sucesso!|");
    }


    public void sucessoSaque() {
        System.out.println("\n|Saque feito com sucesso!|");
    }


    public void sucessoTransferencia() {
        System.out.println("\n|Transferência feita com sucesso!|");
    }


    public void saldoInsuficiente() {
        System.out.println("\n|Saldo insuficiente!|");
    }


    public void sair() {
        System.out.println("\nSaindo...");
    }


    public void usuarioExistente() {
        System.out.println("\n|Nome de usuário indisponível!|");
    }


    public void erroLogin(){
        System.out.println("\n|Usuário ou senha incorretos!|");
    }


    public void numeroMaximo(){
        System.out.println("\n|Você criou o número máximo de contas!|");
    }
}