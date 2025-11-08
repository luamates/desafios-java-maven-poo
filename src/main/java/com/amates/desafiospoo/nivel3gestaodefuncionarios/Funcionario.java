package com.amates.desafiospoo.nivel3gestaodefuncionarios;

public class Funcionario {
    private String nome;
    private String cargo;
    private Double salario;

    public void aumentarSalario(double percentual){
        this.salario *= 1 + (percentual / 100);
    }

    @Override
    public String toString() {
        return String.format("%n%nDADOS DO FUNCIONÁRIO %nNome: %s %nCargo: %s %nSalário: %.2f", getNome(), getCargo(), getSalario());
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
