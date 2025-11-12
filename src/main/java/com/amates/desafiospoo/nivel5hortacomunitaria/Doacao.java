package com.amates.desafiospoo.nivel5hortacomunitaria;

import java.util.HashMap;

public class Doacao {
    private String nomeDaFamilia;
    private HashMap<Planta, Integer> listaDeItens;
    private Voluntario voluntario;

    public Doacao(String nome,Voluntario voluntario){
        this.nomeDaFamilia = nome;
        this.voluntario = voluntario;

    }

    public void adicionarItem(Planta planta, int quantidade){
        listaDeItens.put(planta, quantidade);
    }

    public void mostrarItens(){
        System.out.printf("%n%nItens adicionados nessa doação: %n");
        for(Planta p : listaDeItens.keySet()){
            System.out.printf("%nNome: %s | Quantidade: %d", p, listaDeItens.get(p));
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
