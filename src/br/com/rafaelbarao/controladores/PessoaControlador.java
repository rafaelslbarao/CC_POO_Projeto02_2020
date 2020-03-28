package br.com.rafaelbarao.controladores;

import br.com.rafaelbarao.dominio.Pessoa;

import java.util.ArrayList;

public class PessoaControlador {
    private ArrayList<Pessoa> listaPessoas;

    public PessoaControlador() {
        this.listaPessoas = new ArrayList<>();
    }

    public Pessoa criaBuscaPessoa(String cpf, String nome) {
        for (int i = 0; i < listaPessoas.size(); i++) {
            Pessoa pessoa = listaPessoas.get(i);
            if (pessoa.getCpf().equals(cpf))
                return pessoa;
        }
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setCpf(cpf);
        novaPessoa.setNome(nome);
        listaPessoas.add(novaPessoa);
        return novaPessoa;
    }

    public Pessoa buscaPessoa(String cpf) {
        for (int i = 0; i < listaPessoas.size(); i++) {
            Pessoa pessoa = listaPessoas.get(i);
            if (pessoa.getCpf().equals(cpf))
                return pessoa;
        }
        return null;
    }

    public Pessoa criaPessoa(String cpf, String nome) {
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setCpf(cpf);
        novaPessoa.setNome(nome);
        listaPessoas.add(novaPessoa);
        return novaPessoa;
    }
}
