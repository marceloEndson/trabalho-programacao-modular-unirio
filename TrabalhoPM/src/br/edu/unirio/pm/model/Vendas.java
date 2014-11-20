/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.model;

import org.joda.time.LocalDate;

/**
 *
 * @author Luiz Carlos
 */
public class Vendas {
	private long dataVenda;
	private int  quantidade;
    private long codigoProduto;
    private long codigoVendedor;



    public  Vendas(long dataVenda, int quantidade, long codigoProduto, long codigoVendedor) {
        this.dataVenda = dataVenda;
        this.quantidade = quantidade;
        this.codigoProduto = codigoProduto;
        this.codigoVendedor = codigoVendedor;
    }


	public long getDataVenda() {
		return dataVenda;
	}




	public void setDataVenda(long dataVenda) {
		this.dataVenda = dataVenda;
	}




	public int getQuantidade() {
		return quantidade;
	}




	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}




	public long getCodigoProduto() {
		return codigoProduto;
	}




	public void setCodigoProduto(long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}




	public long getCodigoVendedor() {
		return codigoVendedor;
	}




	public void setCodigoVendedor(long codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}




	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vendas other = (Vendas) obj;
        if (this.dataVenda != other.dataVenda) {
            return false;
        }
        return true;
    }   
}
