package br.com.rafaelbarao.controladores;

import br.com.rafaelbarao.dominio.Pessoa;
import br.com.rafaelbarao.dominio.PessoaFisica;
import br.com.rafaelbarao.dominio.PessoaJuridica;
import br.com.rafaelbarao.interface_usuario.Console;

import java.util.ArrayList;

public class PessoaControlador {
    private ArrayList<Pessoa> listaPessoas;
    private Console console;

    public PessoaControlador(Console console) {
        this.listaPessoas = new ArrayList<>();
        this.console = console;
    }

    public Pessoa criaBuscaPessoa(String identificador, String nome) {
        for (int i = 0; i < listaPessoas.size(); i++) {
            Pessoa pessoa = listaPessoas.get(i);
            if (pessoa.getIdentificadorReceitaFederal().equals(identificador))
                return pessoa;
        }
        //Cria a pessoa física quando os digitos do identificador for de tamanho 11 (CPF)
        if (identificador.length() == 11) {
            PessoaFisica novaPessoaFisica = new PessoaFisica();
            novaPessoaFisica.setCpf(identificador);
            novaPessoaFisica.setNome(nome);
            novaPessoaFisica.setCodigo(getProximoCodigoPessoa());
            //
            listaPessoas.add(novaPessoaFisica);
            //
            return novaPessoaFisica;
        }
        //Cria a pessoa física quando os digitos do identificador for de tamanho 14 (CNPJ)
        else {
            PessoaJuridica novaPessoaJuridica = new PessoaJuridica();
            novaPessoaJuridica.setCnpj(identificador);
            novaPessoaJuridica.setNome(nome);
            novaPessoaJuridica.setCodigo(getProximoCodigoPessoa());
            //
            listaPessoas.add(novaPessoaJuridica);
            //
            return novaPessoaJuridica;
        }
    }

    private Integer getProximoCodigoPessoa() {
        Integer novoCodigoPessoa = 1;
        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getCodigo() >= novoCodigoPessoa)
                novoCodigoPessoa = pessoa.getCodigo() + 1;
        }
        return novoCodigoPessoa;
    }

    public Pessoa buscaPessoa(String identificador) {
        for (int i = 0; i < listaPessoas.size(); i++) {
            Pessoa pessoa = listaPessoas.get(i);
            if (pessoa.getIdentificadorReceitaFederal().equals(identificador))
                return pessoa;
        }
        return null;
    }

    public Pessoa criaPessoa(String identificador, String nome) {
        //Cria a pessoa física quando os digitos do identificador for de tamanho 11 (CPF)
        if (identificador.length() == 11) {
            PessoaFisica novaPessoaFisica = new PessoaFisica();
            novaPessoaFisica.setCpf(identificador);
            novaPessoaFisica.setNome(nome);
            novaPessoaFisica.setCodigo(getProximoCodigoPessoa());
            //
            listaPessoas.add(novaPessoaFisica);
            //
            return novaPessoaFisica;
        }
        //Cria a pessoa física quando os digitos do identificador for de tamanho 14 (CNPJ)
        else {
            PessoaJuridica novaPessoaJuridica = new PessoaJuridica();
            novaPessoaJuridica.setCnpj(identificador);
            novaPessoaJuridica.setNome(nome);
            novaPessoaJuridica.setCodigo(getProximoCodigoPessoa());
            //
            listaPessoas.add(novaPessoaJuridica);
            //
            return novaPessoaJuridica;
        }
    }

    public void imprimeCadastroPessoas() {
        for (Pessoa pessoa : listaPessoas) {
            if (pessoa instanceof PessoaFisica) {
                console.escreveConsole("Pessoa Física CPF:" + pessoa.getIdentificadorReceitaFederal() + " Nome: "
                        + pessoa.getNome() + " Código Gerado: " + pessoa.getCodigo());
            } else
                console.escreveConsole("Pessoa Jurídica CPNJ:" + pessoa.getIdentificadorReceitaFederal() + " Nome Fantasia: "
                        + pessoa.getNome() + " Código Gerado: " + pessoa.getCodigo());
        }
    }
}
