package br.com.rafaelbarao.dominio;

public class PessoaFisica extends Pessoa{
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getIdentificadorReceitaFederal() {
        return cpf;
    }
}
