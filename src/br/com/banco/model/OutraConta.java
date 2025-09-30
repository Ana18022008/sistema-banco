package br.com.banco.model;


public class OutraConta extends Conta{


    public OutraConta(String numero, String titular, double saldo) {
        super(numero, titular, saldo);
    }


    @Override
    public void mostrarDetalhes() {
        System.out.println("=== Outra Conta ===");
        System.out.println("Número: " + getNumero());
        System.out.println("Titular: " + getTitular());
        System.out.println("Saldo: R$ " + getSaldo());
    }
}
