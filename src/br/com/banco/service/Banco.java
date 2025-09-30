package br.com.banco.service;


import java.util.List;
import java.util.ArrayList;


import br.com.banco.main.Main;
import br.com.banco.model.*;


import br.com.banco.view.Atendente;


public class Banco {


    private List<Conta> contas = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();


    public void gerenciarBanco(Atendente atendente) {


        Usuario usuario = null;
        int escolhaLogin = atendente.login();


        switch (escolhaLogin) {


            case 1 -> {
                String user = atendente.user();
                String senha = atendente.password();


                boolean usuarioExistente = usuarios.stream()
                        .anyMatch(u -> u.getNome().equalsIgnoreCase(user)); // verifica se o usuario existe ou não


                if (usuarioExistente) {
                    atendente.usuarioExistente();
                    return;
                } else {
                    usuario = new Usuario(user, senha);
                    usuarios.add(usuario);
                }
                return;
            }


            case 2 -> {
                String user = atendente.user();
                String senha = atendente.password();


                usuario = usuarios.stream()
                        .filter(u -> u.getNome().equalsIgnoreCase(user) && u.getSenha().equals(senha))
                        .findFirst()
                        .orElse(null); //utilizei para conferir o usuario e a senha


                if (usuario == null) {
                    atendente.erroLogin();
                    return;
                }
            }


            case 0 ->{
                atendente.sair();
                System.exit(0);
            }
        }


        boolean admin = usuario.isAdmin();


        if (admin){
            int escolhaAcao = atendente.escolhaAcao();
            if(escolhaAcao != 0) {
                int escolhaConta = atendente.escolhaConta();


                switch (escolhaAcao) {
                    case 1 -> {
                        switch (escolhaConta) {
                            case 1 -> {
                                String numeroCC = atendente.numero();
                                String titularCC = atendente.titular();
                                double saldoCC = atendente.saldo();
                                double limite = atendente.limite();


                                Conta contaCorrente = new ContaCorrente(numeroCC, titularCC, saldoCC, limite);
                                contas.add(contaCorrente);
                                atendente.sucessoCadastro();
                            }
                            case 2 -> {
                                String numeroCP = atendente.numero();
                                String titularCP = atendente.titular();
                                double saldoCP = atendente.saldo();
                                double taxaRendimento = atendente.taxaRendimento();


                                Conta contaPoupanca = new ContaPoupanca(numeroCP, titularCP, saldoCP, taxaRendimento);
                                contas.add(contaPoupanca);
                                atendente.sucessoCadastro();
                            }
                            case 3 -> {
                                String numero = atendente.numero();
                                String titular = atendente.titular();
                                double saldo = atendente.saldo();


                                Conta conta = new OutraConta(numero, titular, saldo); // só se Conta não for abstrata
                                contas.add(conta);
                                atendente.sucessoCadastro();
                            }
                            default -> atendente.mensagemErro();
                        }
                    } // criar conta adm - feito


                    case 2 -> {
                        switch (escolhaConta) {
                            case 1 -> {
                                String numeroDeposito = atendente.deposito();
                                ContaCorrente contaEncontrada = null;


                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof ContaCorrente contaCorrente) {
                                        if (contaCorrente.getNumero().equalsIgnoreCase(numeroDeposito)) {
                                            contaEncontrada = contaCorrente;
                                            break;
                                        }
                                    }
                                }


                                if (contaEncontrada == null) {
                                    atendente.mensagemErro();
                                } else {
                                    double valorDeposito = atendente.valorDeposito();


                                    contaEncontrada.setSaldo(contaEncontrada.getSaldo() + valorDeposito);


                                    atendente.sucessoDeposito();
                                }
                            }
                            case 2 -> {
                                String numeroDeposito = atendente.deposito();
                                ContaPoupanca contaEncontrada = null;


                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof ContaPoupanca contaPoupanca) {
                                        if (contaPoupanca.getNumero().equalsIgnoreCase(numeroDeposito)) {
                                            contaEncontrada = contaPoupanca;
                                            break;
                                        }
                                    }
                                }


                                if (contaEncontrada == null) {
                                    atendente.mensagemErro();
                                } else {
                                    double valorDeposito = atendente.valorDeposito();


                                    contaEncontrada.setSaldo(contaEncontrada.getSaldo() + valorDeposito);


                                    atendente.sucessoDeposito();
                                }
                            }
                            case 3 -> {
                                String numeroDeposito = atendente.deposito();
                                Conta contaEncontrada = null;


                                for (Conta listaContas : contas) {
                                    if (!(listaContas instanceof ContaCorrente) && !(listaContas instanceof ContaPoupanca) && listaContas instanceof Conta conta) {
                                        if (conta.getNumero().equalsIgnoreCase(numeroDeposito)) {
                                            contaEncontrada = conta;
                                            break;
                                        }
                                    }
                                }


                                if (contaEncontrada == null) {
                                    atendente.mensagemErro();
                                } else {
                                    double valorDeposito = atendente.valorDeposito();


                                    contaEncontrada.setSaldo(contaEncontrada.getSaldo() + valorDeposito);


                                    atendente.sucessoDeposito();
                                }
                            }


                            default -> atendente.mensagemErro();
                        }
                    } // depositar adm - feito


                    case 3 -> { // sacar
                        switch (escolhaConta) {
                            case 1 -> {
                                String numeroSaque = atendente.saque();
                                ContaCorrente contaEncontrada = null;


                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof ContaCorrente contaCorrente) {
                                        if (contaCorrente.getNumero().equalsIgnoreCase(numeroSaque)) {
                                            contaEncontrada = contaCorrente;
                                            break;
                                        }
                                    }
                                }


                                if (contaEncontrada == null) {
                                    atendente.mensagemErro();
                                } else {
                                    double valorSaque = atendente.valorSaque();


                                    contaEncontrada.setSaldo(contaEncontrada.getSaldo() - valorSaque);


                                    atendente.sucessoSaque();
                                }
                            }


                            case 2 -> {
                                String numeroSaque = atendente.saque();
                                ContaPoupanca contaEncontrada = null;


                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof ContaPoupanca contaPoupanca) {
                                        if (contaPoupanca.getNumero().equalsIgnoreCase(numeroSaque)) {
                                            contaEncontrada = contaPoupanca;
                                            break;
                                        }
                                    }
                                }


                                if (contaEncontrada == null) {
                                    atendente.mensagemErro();
                                } else {
                                    double valorSaque = atendente.valorSaque();


                                    contaEncontrada.setSaldo(contaEncontrada.getSaldo() - valorSaque);


                                    atendente.sucessoSaque();
                                }
                            }


                            case 3 -> {
                                String numeroSaque = atendente.saque();
                                Conta contaEncontrada = null;


                                for (Conta listaContas : contas) {
                                    if (!(listaContas instanceof ContaCorrente) && !(listaContas instanceof ContaPoupanca) && listaContas instanceof Conta conta) {
                                        if (conta.getNumero().equalsIgnoreCase(numeroSaque)) {
                                            contaEncontrada = conta;
                                            break;
                                        }
                                    }
                                }


                                if (contaEncontrada == null) {
                                    atendente.mensagemErro();
                                } else {
                                    double valorSaque = atendente.valorSaque();


                                    contaEncontrada.setSaldo(contaEncontrada.getSaldo() - valorSaque);


                                    atendente.sucessoSaque();
                                }
                            }


                            default -> atendente.mensagemErro();
                        }
                    } // sacar adm - feito


                    case 4 -> { // transferir
                        switch (escolhaConta) {
                            case 1 -> {
                                String enviar = atendente.enviartransferencia();
                                String receber = atendente.receberTransferencia();
                                double valor = atendente.valorTransferencia();


                                ContaCorrente contaEnviar = null;
                                ContaCorrente contaReceber = null;




                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof ContaCorrente contaCorrente) {
                                        if (contaCorrente.getNumero().equalsIgnoreCase(enviar)) {
                                            contaEnviar = contaCorrente;
                                        }
                                    }
                                }




                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof ContaCorrente contaCorrente) {
                                        if (contaCorrente.getNumero().equalsIgnoreCase(receber)) {
                                            contaReceber = contaCorrente;
                                        }
                                    }
                                }


                                if (contaEnviar == null || contaReceber == null) {
                                    atendente.mensagemErro();
                                } else {
                                    if (contaEnviar.getSaldo() >= valor) {
                                        contaEnviar.setSaldo(contaEnviar.getSaldo() - valor);
                                        contaReceber.setSaldo(contaReceber.getSaldo() + valor);
                                        atendente.sucessoTransferencia();
                                    } else {
                                        atendente.saldoInsuficiente();
                                    }
                                }
                            }
                            case 2 -> {
                                String enviar = atendente.enviartransferencia();
                                String receber = atendente.receberTransferencia();
                                double valor = atendente.valorTransferencia();


                                ContaPoupanca contaEnviar = null;
                                ContaPoupanca contaReceber = null;




                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof ContaPoupanca contaPoupanca) {
                                        if (contaPoupanca.getNumero().equalsIgnoreCase(enviar)) {
                                            contaEnviar = contaPoupanca;
                                        }
                                    }
                                }




                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof ContaPoupanca contaPoupanca) {
                                        if (contaPoupanca.getNumero().equalsIgnoreCase(receber)) {
                                            contaReceber = contaPoupanca;
                                        }
                                    }
                                }


                                if (contaEnviar == null || contaReceber == null) {
                                    atendente.mensagemErro();
                                } else {
                                    if (contaEnviar.getSaldo() >= valor) {
                                        contaEnviar.setSaldo(contaEnviar.getSaldo() - valor);
                                        contaReceber.setSaldo(contaReceber.getSaldo() + valor);
                                        atendente.sucessoTransferencia();
                                    } else {
                                        atendente.saldoInsuficiente();
                                    }
                                }
                            }


                            case 3 -> {


                                String enviar = atendente.enviartransferencia();
                                String receber = atendente.receberTransferencia();
                                double valor = atendente.valorTransferencia();


                                Conta contaEnviar = null;
                                Conta contaReceber = null;




                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof Conta conta) {
                                        if (conta.getNumero().equalsIgnoreCase(enviar)) {
                                            contaEnviar = conta;
                                        }
                                    }
                                }




                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof Conta conta) {
                                        if (conta.getNumero().equalsIgnoreCase(receber)) {
                                            contaReceber = conta;
                                        }
                                    }
                                }


                                if (contaEnviar == null || contaReceber == null) {
                                    atendente.mensagemErro();
                                } else {
                                    if (contaEnviar.getSaldo() >= valor) {
                                        contaEnviar.setSaldo(contaEnviar.getSaldo() - valor);
                                        contaReceber.setSaldo(contaReceber.getSaldo() + valor);
                                        atendente.sucessoTransferencia();
                                    } else {
                                        atendente.saldoInsuficiente();
                                    }
                                }
                            }


                            default -> atendente.mensagemErro();
                        }
                    } // transferir adm - feito


                    case 5 -> {
                        switch (escolhaConta) {
                            case 1 -> {
                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof ContaCorrente contaCorrente) {
                                        atendente.visualizarCC(contaCorrente);
                                    }
                                }
                            }
                            case 2 -> {
                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof ContaPoupanca contaPoupanca) {
                                        atendente.visualizarCP(contaPoupanca);
                                    }
                                }
                            }
                            case 3 -> {
                                for (Conta listaContas : contas) {
                                    if (!(listaContas instanceof ContaCorrente) && !(listaContas instanceof ContaPoupanca) && listaContas instanceof Conta conta) {
                                        atendente.visualizarConta(listaContas);
                                    }
                                }
                            }
                            default -> atendente.mensagemErro();
                        }
                    }// listar contas adm - feito


                    case 6 -> {
                        switch (escolhaConta) {
                            case 1 -> {
                                boolean removido = false;


                                while (!removido) {
                                    String contaExcluir = atendente.excluir();
                                    for (int i = 0; i < contas.size(); i++) {
                                        Conta conta = contas.get(i);


                                        if (conta instanceof ContaCorrente cc && cc.getNumero().equalsIgnoreCase(contaExcluir)) {
                                            contas.remove(i);
                                            removido = true;
                                            atendente.sucessoExclusao();
                                            break;
                                        }
                                    }
                                    if (!removido) {
                                        atendente.mensagemErro();
                                    }
                                }
                            }


                            //Inserir funcionalidade de voltar para o menu


                            case 2 -> {
                                boolean removido = false;


                                while (!removido) {
                                    String contaExcluir = atendente.excluir();


                                    for (int i = 0; i < contas.size(); i++) {
                                        Conta conta = contas.get(i);


                                        if (conta instanceof ContaPoupanca cp && cp.getNumero().equalsIgnoreCase(contaExcluir)) {
                                            contas.remove(i);
                                            removido = true;
                                            atendente.sucessoExclusao();
                                            break;
                                        }
                                    }
                                    if (!removido) {
                                        atendente.mensagemErro();


                                    }
                                }
                            }
                            case 3 -> {
                                boolean removido = false;


                                while (!removido) {
                                    String contaExcluir = atendente.excluir();


                                    for (int i = 0; i < contas.size(); i++) {
                                        Conta conta = contas.get(i);


                                        if (!(conta instanceof ContaCorrente) && !(conta instanceof ContaPoupanca) && conta instanceof Conta c && c.getNumero().equalsIgnoreCase(contaExcluir)) {
                                            contas.remove(i);
                                            removido = true;
                                            atendente.sucessoExclusao();
                                            break;
                                        }
                                    }
                                    if (!removido) {
                                        atendente.mensagemErro();
                                    }
                                }
                            }
                            default -> atendente.mensagemErro();
                        }
                    } //remover as contas adm - feito


                    case 7 -> {
                        switch (escolhaConta) {
                            case 1 -> {
                                boolean encontrado = false;


                                while (!encontrado) {


                                    String numeroPesquisa = atendente.pesquisa();




                                    for (Conta listaContas : contas) {
                                        if (listaContas instanceof ContaCorrente contaCorrente) {


                                            if (contaCorrente.getNumero().equalsIgnoreCase(numeroPesquisa)) {


                                                atendente.itemPesquisa(contaCorrente);
                                                encontrado = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (!encontrado) {
                                        atendente.mensagemErro();
                                    }
                                }
                            }
                            case 2 -> {


                                boolean encontrado = false;


                                while (!encontrado) {
                                    String numeroPesquisa = atendente.pesquisa();


                                    for (Conta listaContas : contas) {
                                        if (listaContas instanceof ContaPoupanca contaPoupanca) {


                                            if (contaPoupanca.getNumero().equalsIgnoreCase(numeroPesquisa)) {


                                                atendente.itemPesquisa(contaPoupanca);
                                                encontrado = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (!encontrado) {
                                        atendente.mensagemErro();
                                    }
                                }
                            }


                            case 3 -> {


                                boolean encontrado = false;


                                while (!encontrado) {
                                    String numeroPesquisa = atendente.pesquisa();


                                    for (Conta listaContas : contas) {
                                        if (listaContas instanceof Conta conta) {


                                            if (conta.getNumero().equalsIgnoreCase(numeroPesquisa)) {


                                                atendente.itemPesquisa(conta);
                                                encontrado = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (!encontrado) {
                                        atendente.mensagemErro();
                                    }
                                }
                            }
                            default -> atendente.mensagemErro();
                        }
                    } // pesquisar por número adm - feito


                    default -> atendente.mensagemErro();
                }
            }
        }else{


            int escolhaAcao = atendente.escolhaAcaoUsuario();
            if (escolhaAcao != 0){
                int escolhaConta = atendente.escolhaConta();
                switch (escolhaAcao) {


                    //fiz ate aqui!


                    case 1 -> {
                        switch (escolhaConta) {
                            case 1 -> {
                                String numeroCC = atendente.numero();
                                String titularCC = atendente.titular();
                                double saldoCC = atendente.saldo();
                                double limite = atendente.limite();


                                Conta contaCorrente = new ContaCorrente(numeroCC, titularCC, saldoCC, limite);
                                contas.add(contaCorrente);
                                atendente.sucessoCadastro();
                            }
                            case 2 -> {
                                String numeroCP = atendente.numero();
                                String titularCP = atendente.titular();
                                double saldoCP = atendente.saldo();
                                double taxaRendimento = atendente.taxaRendimento();


                                Conta contaPoupanca = new ContaPoupanca(numeroCP, titularCP, saldoCP, taxaRendimento);
                                contas.add(contaPoupanca);
                                atendente.sucessoCadastro();
                            }
                            case 3 -> {
                                String numero = atendente.numero();
                                String titular = atendente.titular();
                                double saldo = atendente.saldo();


                                Conta conta = new OutraConta(numero, titular, saldo); // só se Conta não for abstrata
                                contas.add(conta);
                                atendente.sucessoCadastro();
                            }


                            default -> atendente.mensagemErro();
                        }
                    } // criar conta user máx 3


                    case 2 -> { // transferir
                        switch (escolhaConta) {
                            case 1 -> {
                                String enviar = atendente.enviartransferencia();
                                String receber = atendente.receberTransferencia();
                                double valor = atendente.valorTransferencia();


                                ContaCorrente contaEnviar = null;
                                ContaCorrente contaReceber = null;




                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof ContaCorrente contaCorrente) {
                                        if (contaCorrente.getNumero().equalsIgnoreCase(enviar)) {
                                            contaEnviar = contaCorrente;
                                        }
                                    }
                                }




                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof ContaCorrente contaCorrente) {
                                        if (contaCorrente.getNumero().equalsIgnoreCase(receber)) {
                                            contaReceber = contaCorrente;
                                        }
                                    }
                                }


                                if (contaEnviar == null || contaReceber == null) {
                                    atendente.mensagemErro();
                                } else {
                                    if (contaEnviar.getSaldo() >= valor) {
                                        contaEnviar.setSaldo(contaEnviar.getSaldo() - valor);
                                        contaReceber.setSaldo(contaReceber.getSaldo() + valor);
                                        atendente.sucessoTransferencia();
                                    } else {
                                        atendente.saldoInsuficiente();
                                    }
                                }
                            }
                            case 2 -> {
                                String enviar = atendente.enviartransferencia();
                                String receber = atendente.receberTransferencia();
                                double valor = atendente.valorTransferencia();


                                ContaPoupanca contaEnviar = null;
                                ContaPoupanca contaReceber = null;




                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof ContaPoupanca contaPoupanca) {
                                        if (contaPoupanca.getNumero().equalsIgnoreCase(enviar)) {
                                            contaEnviar = contaPoupanca;
                                        }
                                    }
                                }




                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof ContaPoupanca contaPoupanca) {
                                        if (contaPoupanca.getNumero().equalsIgnoreCase(receber)) {
                                            contaReceber = contaPoupanca;
                                        }
                                    }
                                }


                                if (contaEnviar == null || contaReceber == null) {
                                    atendente.mensagemErro();
                                } else {
                                    if (contaEnviar.getSaldo() >= valor) {
                                        contaEnviar.setSaldo(contaEnviar.getSaldo() - valor);
                                        contaReceber.setSaldo(contaReceber.getSaldo() + valor);
                                        atendente.sucessoTransferencia();
                                    } else {
                                        atendente.saldoInsuficiente();
                                    }
                                }
                            }


                            case 3 -> {


                                String enviar = atendente.enviartransferencia();
                                String receber = atendente.receberTransferencia();
                                double valor = atendente.valorTransferencia();


                                Conta contaEnviar = null;
                                Conta contaReceber = null;




                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof Conta conta) {
                                        if (conta.getNumero().equalsIgnoreCase(enviar)) {
                                            contaEnviar = conta;
                                        }
                                    }
                                }




                                for (Conta listaContas : contas) {
                                    if (listaContas instanceof Conta conta) {
                                        if (conta.getNumero().equalsIgnoreCase(receber)) {
                                            contaReceber = conta;
                                        }
                                    }
                                }


                                if (contaEnviar == null || contaReceber == null) {
                                    atendente.mensagemErro();
                                } else {
                                    if (contaEnviar.getSaldo() >= valor) {
                                        contaEnviar.setSaldo(contaEnviar.getSaldo() - valor);
                                        contaReceber.setSaldo(contaReceber.getSaldo() + valor);
                                        atendente.sucessoTransferencia();
                                    } else {
                                        atendente.saldoInsuficiente();
                                    }
                                }
                            }


                            default -> atendente.mensagemErro();
                        }
                    } // transferir user - feito (verificar se a conta que vai transferir é a do usuário)


                    default -> atendente.mensagemErro();
                }
            }
        }
    }
}
