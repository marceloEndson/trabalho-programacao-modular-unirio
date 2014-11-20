/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.model;

import org.joda.time.LocalDate;

/**
 *
 * @author Felipe
 */
public class Produto {
    private long codigo;
    private String nome;
    private double preco;
    private LocalDate inicioVigenciaPreco;

    public Produto(long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Produto(long codigo, double preco, LocalDate inicioVigenciaPreco) {
        this.codigo = codigo;
        this.preco = preco;
        this.inicioVigenciaPreco = inicioVigenciaPreco;
    }

    public Produto() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDate getInicioVigenciaPreco() {
        return inicioVigenciaPreco;
    }

    public void setInicioVigenciaPreco(LocalDate inicioVigenciaPreco) {
        this.inicioVigenciaPreco = inicioVigenciaPreco;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }   
}
