/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.service;

/**
 *
 * @author Felipe
 */
public class MesEscolhido {
    private int ano;
    private int mes;

    public MesEscolhido() {
    }

    public MesEscolhido(int ano, int mes) {
        this.ano = ano;
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
    
    public int obterQuantidadeDeDiasDoMes(){
        if (mes == 2 && ano % 4 == 0) // Anos bissextos são múltiplos de 4.
            return 29;
        else if (mes == 2)
            return 28;
        else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || 
                mes == 10 || mes == 12)
            return 31;
        return 30;
    }
    
}
