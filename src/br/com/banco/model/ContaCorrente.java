package br.com.banco.model;
import br.com.banco.model.Conta;


public class ContaCorrente extends Conta {


    private double limite;


    public ContaCorrente() {
        super();
        this.limite = 0.0;
    }


    public ContaCorrente(String numero, String titular, double saldo, double limite) {
        super(numero, titular, saldo);
        this.limite = limite;
    }


    public double getLimite() {
        return limite;
    }


    public void setLimite(double limite) {
        this.limite = limite;
    }


    @Override
    public void mostrarDetalhes() {
        System.out.println("=== Conta Corrente ===");
        System.out.println("Número: " + getNumero());
        System.out.println("Titular: " + getTitular());
        System.out.println("Saldo: R$ " + getSaldo());
        System.out.println("Limite: R$ " + limite);
    }
}