package br.com.rafaelbarao.dominio;

public abstract class Pessoa {

    private Integer codigo;
    private String nome;

    public Pessoa() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract String getIdentificadorReceitaFederal();
}
