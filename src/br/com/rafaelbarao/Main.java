package br.com.rafaelbarao;

import br.com.rafaelbarao.controladores.AgenciaControlador;
import br.com.rafaelbarao.controladores.ContaControlador;
import br.com.rafaelbarao.controladores.PessoaControlador;
import br.com.rafaelbarao.interface_usuario.Console;
import br.com.rafaelbarao.interface_usuario.Menu;
import br.com.rafaelbarao.interface_usuario.OpcaoMenu;

import java.util.ArrayList;

public class Main {

    // Objetos de controle da interface do usuário
    private static ArrayList<OpcaoMenu> menuPrincipal;
    private static Console console;
    private static Menu menu;

    //Objetos dos controladores
    private static AgenciaControlador agenciaControlador;
    private static ContaControlador contaControlador;
    private static PessoaControlador pessoaControlador;

    public static void main(String[] args) {
        iniciaConsole();
        iniciaMenu();
        inicializaMenus();
        inicializaControladores();
        exibeMenuPrincipal();
    }

    private static void iniciaConsole() {
        console = new Console();
    }

    private static void iniciaMenu() {
        menu = new Menu(console);
    }

    private static void inicializaMenus() {
        menuPrincipal = new ArrayList<>();
        menuPrincipal.add(new OpcaoMenu(1, "Cadastrar Agência"));
        menuPrincipal.add(new OpcaoMenu(2, "Cadastrar Conta"));
        menuPrincipal.add(new OpcaoMenu(3, "Movimentar Conta"));
        menuPrincipal.add(new OpcaoMenu(4, "Imprime cadastro pessoas"));
        menuPrincipal.add(new OpcaoMenu(5, "Atualiza Saldo Contas Poupança"));
        menuPrincipal.add(new OpcaoMenu(99, "Sair"));
    }

    private static void inicializaControladores() {
        pessoaControlador = new PessoaControlador(console);
        agenciaControlador = new AgenciaControlador(console);
        contaControlador = new ContaControlador(console, pessoaControlador, agenciaControlador);
    }

    private static void exibeMenuPrincipal() {
        OpcaoMenu opcaoSelecionada;
        do {
            opcaoSelecionada = menu.imprimeMenuLeOpcaoValida(menuPrincipal);
            switch (opcaoSelecionada.getOpcao()) {
                case 1:
                    agenciaControlador.cadastraNovaAgencia();
                    break;
                case 2:
                    contaControlador.cadastraNovaConta();
                    break;
                case 3:
                    contaControlador.exibeMenuMovimentacoes(menu);
                    break;
                case 4:
                    pessoaControlador.imprimeCadastroPessoas();
                    break;
                case 5:
                    agenciaControlador.atualizaSaldoContasRendimentoEManutencao();
                    break;
            }
        } while (!opcaoSelecionada.getOpcao().equals(99));
    }
}
