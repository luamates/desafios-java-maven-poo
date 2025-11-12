package com.amates.desafiospoo.nivel5hortacomunitaria;

public class Planta {
    private String nome;
    private Integer quantidadeEstocada;
    private String status;

    @Override
    public String toString() {
        return String.format("%nNome: %s | Há %dKg em estoque | Atualmente, a planta está %s.", this.nome, this.quantidadeEstocada, this.status);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeEstocada() {
        return quantidadeEstocada;
    }

    public void setQuantidadeEstocada(Integer quantidadeEstocada) {
        this.quantidadeEstocada = quantidadeEstocada;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
