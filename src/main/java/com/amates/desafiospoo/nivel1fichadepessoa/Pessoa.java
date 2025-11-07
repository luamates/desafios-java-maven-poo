package com.amates.desafiospoo.nivel1fichadepessoa;

public class Pessoa {

    private String nome;
    private String cidade;
    private Integer idade;

    public void exibirFicha() {
        System.out.printf("%n%nFICHA CADASTRAL");
        System.out.printf("%nNome: %s %nIdade: %d %nCidade: %s %n%n", getNome(), getIdade(), getCidade());
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

}
