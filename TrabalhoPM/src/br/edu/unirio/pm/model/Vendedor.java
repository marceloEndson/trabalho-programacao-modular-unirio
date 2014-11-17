/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.model;

/**
 *
 * @author Rogerio
 */
public class Vendedor {
    private long codigo;
    private String nome;
    private int categoria;

    public Vendedor(long codigo, String nome, int categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
    }

    public Vendedor() {
        this.codigo = -1;
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
    
    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vendedor other = (Vendedor) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
 
    
}
