package br.com.rafaelbarao.dominio;

public class ContaPoupanca extends Conta{
    private static final Double VALOR_RENDIMENTO_POUPANCA = 10.0;

    public boolean efetuaSaque(Double valorSaque) {
        if (valorSaque <= getSaldo()) {
            setSaldo(getSaldo() - valorSaque);
            return true;
        }
        return false;
    }

    public void atualizaSaldoRendimento()
    {
        setSaldo(getSaldo() + VALOR_RENDIMENTO_POUPANCA);
    }
}
