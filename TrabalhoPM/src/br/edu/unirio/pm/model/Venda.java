/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.model;

import java.util.Objects;
import org.joda.time.LocalDate;

/**
 *
 * @author MCE
 */
public class Venda {
    private LocalDate dataVenda;
    private int quantidadeVendida;
    private Produto produto;
    private Vendedor vendedor;

    public Venda(){
        
    }
    
    public Venda(LocalDate dataVenda,int quantidadeVendida , Produto produto, Vendedor vendedor) {
        this.dataVenda = dataVenda;
        this.vendedor = vendedor;
        this.produto = produto;
        this.quantidadeVendida = quantidadeVendida;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.dataVenda, other.dataVenda)) {
            return false;
        }
        if (this.quantidadeVendida != other.quantidadeVendida) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.vendedor, other.vendedor)) {
            return false;
        }
        return true;
    } 
}
