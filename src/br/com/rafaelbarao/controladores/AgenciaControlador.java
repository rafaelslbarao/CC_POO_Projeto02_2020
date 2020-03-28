package br.com.rafaelbarao.controladores;

import br.com.rafaelbarao.dominio.Agencia;
import br.com.rafaelbarao.interface_usuario.Console;

import java.util.ArrayList;

public class AgenciaControlador {
    private Console console;
    private ArrayList<Agencia> listaAgencias;

    public AgenciaControlador(Console console) {
        this.console = console;
        listaAgencias = new ArrayList<>();
    }

    public void cadastraNovaAgencia() {
        console.escreveConsole("Informe código agência");
        Integer novoNumeroAgencia = console.leNumeroInteiro();

        do {
            if (verificaCodigoExistente(novoNumeroAgencia)) {
                console.escreveConsole("Código já existe, informe um novo");
                novoNumeroAgencia = console.leNumeroInteiro();
            } else
                break;
        } while (true);

        console.escreveConsole("Informe nome agência");
        String novoNomeAgencia = console.leLinhaTexto();
        criaAgencia(novoNumeroAgencia, novoNomeAgencia);
        console.escreveConsole("Agência cadastrada com sucesso");
    }

    private boolean verificaCodigoExistente(Integer novoNumeroAgencia) {
        for (Agencia agencia : listaAgencias) {
            if (agencia.getNumero().equals(novoNumeroAgencia))
                return true;
        }
        return false;
    }


    private void criaAgencia(Integer nroAgencia, String nomeAgencia) {
        Agencia novaAgencia = new Agencia(nroAgencia, nomeAgencia);
        //Uma alternativa seria settar os valores através dos métodos set
        //novaAgencia.setNumero(nroAgencia);
        //novaAgencia.setNome(nomeAgencia);
        //
        listaAgencias.add(novaAgencia);
    }

    public Agencia getAgenciaPorCodigo(Integer numeroAgencia) {
        for (Agencia agencia : listaAgencias) {
            if (agencia.getNumero().equals(numeroAgencia))
                return agencia;
        }
        return null;
    }
}
