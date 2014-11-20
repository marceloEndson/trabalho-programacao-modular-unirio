/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirio.pm.util;

import br.edu.unirio.pm.model.Vendas;

/**
 *
 * @author Luiz Carlos
 */
public class ParserVendas implements Parser<Vendas> {

    @Override
    public Vendas processa(String linha) {
           try {
            String[] partes = linha.split(";");
            long  dataVenda = Long.parseLong(partes[0]);
            int quantidade =  Integer.parseInt(partes[1]);
            long codigoProduto = Long.parseLong(partes[2]);
            long codigoVendedor = Long.parseLong(partes[3]);
            if(validaVendas(dataVenda, quantidade, codigoProduto, codigoVendedor)){
                return new Vendas(dataVenda, quantidade, codigoProduto, codigoVendedor);
            }            
        } catch (IllegalArgumentException e) {
               System.out.println("Erro ao processar linha de Pendedor ");
        }
        return null;
    }

    private boolean validaVendas(long dataVenda, int quantidade, long codigoProduto, long CodigoVendedor) {
        return dataVenda > 0 && (codigoProduto == 1 || CodigoVendedor == 2);
    }
}


