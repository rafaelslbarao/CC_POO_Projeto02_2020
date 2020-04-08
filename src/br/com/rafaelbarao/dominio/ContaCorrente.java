package br.com.rafaelbarao.dominio;

public class ContaCorrente extends Conta {
    public static final Double TAXA_MANUTENCAO = 1.0;
    public static final Double TAXA_SAQUE = 2.0;
    public static final Double TAXA_DEPOSITO = 1.0;

    public boolean efetuaSaque(Double valorSaque) {
        if ((valorSaque + TAXA_SAQUE) <= getSaldo()) {
            setSaldo(getSaldo() - valorSaque - TAXA_SAQUE);
            return true;
        }
        return false;
    }

    public void efetuaDeposito(Double valorDeposito) {
        setSaldo(getSaldo() + valorDeposito - TAXA_DEPOSITO);
    }

    public void cobraTaxaManutencao()
    {
        setSaldo(getSaldo() - TAXA_MANUTENCAO);
    }
}
