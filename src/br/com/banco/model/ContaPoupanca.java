package br.com.banco.model;
import br.com.banco.model.Conta;


public class ContaPoupanca extends Conta{


    private double taxaRendimento;


    public ContaPoupanca(){
        super();
        this.taxaRendimento = 0.0;
    }


    public ContaPoupanca (String numero, String titular, double saldo, double taxaRendimento){
        super(numero, titular, saldo) ;
        this.taxaRendimento = taxaRendimento;
    }


    public double getTaxaRendimento() {
        return taxaRendimento;
    }


    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }


    @Override
    public void mostrarDetalhes() {
        System.out.println("=== Conta Poupança ===");
        System.out.println("Número: " + getNumero());
        System.out.println("Titular: " + getTitular());
        System.out.println("Saldo: R$ " + getSaldo());
        System.out.println("Taxa de rendimento: " + taxaRendimento + "%");
    }
}