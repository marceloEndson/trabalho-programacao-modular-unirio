/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.model;

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

  
}
