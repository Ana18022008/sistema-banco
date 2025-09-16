package br.com.banco.main;

import br.com.banco.service.Banco;
import br.com.banco.view.Atendente;

public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco();
        Atendente atendente = new Atendente(banco);

        int escolhaAcao = 1;

        do {
            banco.gerenciarBanco(atendente);
        } while (escolhaAcao != 0);

    }
}
