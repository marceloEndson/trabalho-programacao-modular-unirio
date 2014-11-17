/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.util;

import br.edu.unirio.pm.model.Produto;

/**
 *
 * @author MCE
 */
public class ParserProduto implements Parser<Produto> {
//TODO REMOVER O RETURN NULL
    @Override
    public Produto processa(String linha) {
      String[] partes = linha.split(";");
        try {
            long codigo = Long.parseLong(partes[0]);
            String nome = partes[1];
            if(validaProduto(codigo)){
                return new Produto(codigo, nome);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao processar linha de Produto");
        }
          return null;
    }

    private boolean validaProduto(long codigo) {
        return codigo > 0;
    }
}
