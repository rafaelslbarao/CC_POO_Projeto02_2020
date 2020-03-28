package br.com.rafaelbarao.dominio;

public class Conta {
    public static final int TIPO_CONTA_CORRENTE = 1;
    public static final int TIPO_CONTA_POUPANCA = 2;

    private Agencia agencia;
    private Integer numero;
    private Double saldo;
    private int tipoConta;
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

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    public void efetuaDeposito(Double valorDeposito) {
        saldo = saldo + valorDeposito;
    }

    public boolean efetuaSaque(Double valorSaque) {
        if (valorSaque <= saldo) {
            saldo = saldo - valorSaque;
            return true;
        }
        return false;
    }
}
