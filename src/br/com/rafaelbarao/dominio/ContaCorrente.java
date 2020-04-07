package br.com.rafaelbarao.dominio;

public class ContaCorrente extends Conta {
    public static final Double TAXA_SAQUE = 2.0;

    public boolean efetuaSaque(Double valorSaque) {
        if ((valorSaque + TAXA_SAQUE) <= getSaldo()) {
            setSaldo(getSaldo() - valorSaque - TAXA_SAQUE);
            return true;
        }
        return false;
    }
}