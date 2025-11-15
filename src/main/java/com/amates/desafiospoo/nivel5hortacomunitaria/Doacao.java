package com.amates.desafiospoo.nivel5hortacomunitaria;

import java.util.HashMap;

public class Doacao {
    private String nomeDaFamilia;
    private HashMap<Planta, Integer> listaDeItens = new HashMap<>();
    private Voluntario voluntario;

    public Doacao(String nome, Voluntario voluntario) {
        this.nomeDaFamilia = nome;
        this.voluntario = voluntario;
    }

    @Override
    public String toString() {
        return String.format("%n%nDoação à família: %s | Voluntário responsável: %s", nomeDaFamilia, voluntario.getNome());
    }

    public void adicionarItem(Planta planta, int quantidade) {


        listaDeItens.put(planta, quantidade);
    }

    public void mostrarItens() {
        System.out.printf("%nItens adicionados nessa doação:");
        for (Planta p : listaDeItens.keySet()) {
            System.out.printf("%nNome: %s | Quantidade: %d Kg", p.getNome(), listaDeItens.get(p));
        }
    }

    public HashMap<Planta, Integer> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(HashMap<Planta, Integer> listaDeItens) {
        this.listaDeItens = listaDeItens;
    }

    public String getNomeDaFamilia() {
        return nomeDaFamilia;
    }

    public void setNomeDaFamilia(String nomeDaFamilia) {
        this.nomeDaFamilia = nomeDaFamilia;
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
    }
}
