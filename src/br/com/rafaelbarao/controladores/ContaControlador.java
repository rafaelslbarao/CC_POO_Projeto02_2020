package br.com.rafaelbarao.controladores;

import br.com.rafaelbarao.dominio.Agencia;
import br.com.rafaelbarao.dominio.Conta;
import br.com.rafaelbarao.dominio.Pessoa;
import br.com.rafaelbarao.interface_usuario.Console;
import br.com.rafaelbarao.interface_usuario.Menu;
import br.com.rafaelbarao.interface_usuario.OpcaoMenu;

import java.util.ArrayList;

public class ContaControlador {

    //Menus
    private static ArrayList<OpcaoMenu> menuMovimentacoes;
    //
    private final AgenciaControlador agenciaControlador;
    private final Console console;
    private final PessoaControlador pessoaControlador;
    //

    public ContaControlador(Console console, PessoaControlador pessoaControlador, AgenciaControlador agenciaControlador) {
        this.console = console;
        this.pessoaControlador = pessoaControlador;
        this.agenciaControlador = agenciaControlador;
        inicializaMenu();
    }

    private void inicializaMenu() {
        menuMovimentacoes = new ArrayList<>();
        menuMovimentacoes.add(new OpcaoMenu(1, "Saque"));
        menuMovimentacoes.add(new OpcaoMenu(2, "Depósito"));
        menuMovimentacoes.add(new OpcaoMenu(99, "Voltar"));
    }

    private Conta criaNovaConta(Agencia agencia, int tipoConta, Pessoa pessoa) {
        Conta novaConta = new Conta();
        novaConta.setAgencia(agencia);
        novaConta.setNumero(getProximoNumeroConta(agencia.getListaContas()));
        novaConta.setTitular(pessoa);
        novaConta.setTipoConta(tipoConta);
        agencia.adicionaNovaConta(novaConta);
        return novaConta;
    }

    private Integer getProximoNumeroConta(ArrayList<Conta> listaContas) {
        Integer novoCodigoConta = 1;
        for (Conta conta : listaContas) {
            if (conta.getNumero() >= novoCodigoConta)
                novoCodigoConta = conta.getNumero() + 1;
        }
        return novoCodigoConta;
    }

    public void cadastraNovaConta() {
        console.escreveConsole("Informe código agência");
        Integer numeroAgencia = console.leNumeroInteiro();
        Agencia agencia = agenciaControlador.getAgenciaPorCodigo(numeroAgencia);
        while (agencia == null) {
            console.escreveConsole("Agência não existe. Informe um novo número");
            numeroAgencia = console.leNumeroInteiro();
            agencia = agenciaControlador.getAgenciaPorCodigo(numeroAgencia);
        }
        //
        console.escreveConsole("Informe o tipo da conta 1 = Corrente / 2 = Poupança");
        Integer tipoConta = console.leNumeroInteiro();
        while (tipoConta != Conta.TIPO_CONTA_CORRENTE && tipoConta != Conta.TIPO_CONTA_POUPANCA) {
            console.escreveConsole("Tipo inválido, informe novamente");
            tipoConta = console.leNumeroInteiro();
        }
        //
        console.escreveConsole("Informe o CPF da pessoa");
        String cpf = console.leLinhaTexto();
        Pessoa pessoa = pessoaControlador.buscaPessoa(cpf);
        if (pessoa == null) {
            console.escreveConsole("Informe o nome da pessoa");
            String nome = console.leLinhaTexto();
            pessoa = pessoaControlador.criaPessoa(cpf, nome);
        } else {
            console.escreveConsole("Cadastro encontrado: " + pessoa.getNome());
        }

        //
        Conta contaCriada = criaNovaConta(agencia, tipoConta, pessoa);
        //
        console.escreveConsole("Conta cadastrada com sucesso. Seu número é: " + contaCriada.getNumero().toString());
    }

    public void exibeMenuMovimentacoes(Menu menu) {
        Conta conta = buscaConta();
        //
        OpcaoMenu opcaoSelecionada;
        do {
            opcaoSelecionada = menu.imprimeMenuLeOpcaoValida(menuMovimentacoes);
            switch (opcaoSelecionada.getOpcao()) {
                case 1:
                    realizaSaque(conta);
                    break;
                case 2:
                    realizaDeposito(conta);
                    break;
            }
        } while (!opcaoSelecionada.getOpcao().equals(99));
    }

    private void realizaSaque(Conta conta) {
        console.escreveConsole("Informe o valor para saque");
        Double valor = console.leNumeroDouble();
        if (conta.efetuaSaque(valor)) {
            console.escreveConsole("Saque efetuado com sucesso. Saldo restante: " + conta.getSaldo().toString());
        } else {
            console.escreveConsole("Saldo insuficiente para o saque");
        }
    }

    private void realizaDeposito(Conta conta) {
        console.escreveConsole("Informe o valor para saque");
        Double valor = console.leNumeroDouble();
        conta.efetuaDeposito(valor);
        console.escreveConsole("Depósito efetuado com sucesso. Saldo atual: " + conta.getSaldo().toString());
    }

    private Conta buscaConta() {
        console.escreveConsole("Informe código agência");
        Integer numeroAgencia = console.leNumeroInteiro();
        Agencia agencia = agenciaControlador.getAgenciaPorCodigo(numeroAgencia);
        while (agencia == null) {
            console.escreveConsole("Agência não existe. Informe um novo número");
            numeroAgencia = console.leNumeroInteiro();
            agencia = agenciaControlador.getAgenciaPorCodigo(numeroAgencia);
        }
        //
        console.escreveConsole("Informe número da conta");
        Integer numeroConta = console.leNumeroInteiro();
        Conta conta = agencia.getContaPorNumero(numeroConta);
        while (conta == null) {
            console.escreveConsole("Conta não existe. Informe um novo número");
            numeroConta = console.leNumeroInteiro();
            conta = agencia.getContaPorNumero(numeroConta);
        }
        return conta;
    }
}
