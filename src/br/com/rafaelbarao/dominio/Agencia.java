package br.com.rafaelbarao.dominio;

import java.util.ArrayList;

public class Agencia {
    private Integer numero;
    private String nome;
    private ArrayList<Conta> listaContas;

    public Agencia() {
        listaContas = new ArrayList<>();
    }

    public Agencia(Integer numero, String nome) {
        this.numero = numero;
        this.nome = nome;
        listaContas = new ArrayList<>();
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Conta> getListaContas() {
        return listaContas;
    }

    public void adicionaNovaConta(Conta novaConta) {
        listaContas.add(novaConta);
    }

    public Conta getContaPorNumero(Integer numeroConta) {
        for(Conta conta : listaContas)
        {
            if(conta.getNumero().equals(numeroConta))
                return conta;
        }
        return null;
    }
}
