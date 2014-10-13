/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Felipe
 */
public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private Date inicioVigenciaPreco;

    public Produto(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Produto() {
        this.codigo = -1;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public Date getInicioVigenciaPreco() {
        return inicioVigenciaPreco;
    }

    public void setInicioVigenciaPreco(Date inicioVigenciaPreco) {
        this.inicioVigenciaPreco = inicioVigenciaPreco;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + Objects.hashCode(this.nome);
        return hash;
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
