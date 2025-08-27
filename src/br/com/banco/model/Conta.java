package br.com.banco.model;

public class Conta {

    private String numero;
    private String titular;
    private double saldo;

    public Conta(){
        this.numero = null;
        this.titular = null;
        this.saldo = 0.0;
    }

    public Conta(String numero, String titular, double saldo){
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString(){
        return "\n- Conta - \nNúmero: " + numero + "\nTitular: " + titular + "\nSaldo: " + saldo;
    }
}
