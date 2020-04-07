package br.com.rafaelbarao.dominio;

public abstract class Conta {
    private Agencia agencia;
    private Integer numero;
    private Double saldo;
    private Pessoa titular;

    public Conta() {
        this.saldo = 0.0;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public void efetuaDeposito(Double valorDeposito) {
        saldo = saldo + valorDeposito;
    }

    protected void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public abstract boolean efetuaSaque(Double valorSaque);
}
