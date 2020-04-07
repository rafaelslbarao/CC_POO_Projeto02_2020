package br.com.rafaelbarao.dominio;

public class ContaPoupanca extends Conta{
    public boolean efetuaSaque(Double valorSaque) {
        if (valorSaque <= getSaldo()) {
            setSaldo(getSaldo() - valorSaque);
            return true;
        }
        return false;
    }
}
