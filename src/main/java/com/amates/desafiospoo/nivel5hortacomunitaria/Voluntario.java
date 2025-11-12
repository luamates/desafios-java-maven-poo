package com.amates.desafiospoo.nivel5hortacomunitaria;

public class Voluntario {
    private String nome;
    private String funcao;
    private Integer horasTrabalhadas;

    @Override
    public String toString() {
        return String.format("%nNome: %s | Função: %s | Trabalhou %d horas.", this.nome, this.funcao, this.horasTrabalhadas);
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void adicionarHoras(int horas){
        this.horasTrabalhadas += horas;
    }

    public Integer getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Integer horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
