/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.service;

import br.edu.unirio.pm.dao.ProdutosDAO;
import br.edu.unirio.pm.model.Produto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class ServicosProdutos {
    
    private ProdutosDAO produtosDAO;    
    private List<Produto> listaProdutos;

    public ServicosProdutos() {
        produtosDAO = new ProdutosDAO();
        listaProdutos = new ArrayList<>();
    }
    
    public String importarProdutosDoArquivo(String nomeArquivo){
        listaProdutos = produtosDAO.getObjetos(nomeArquivo);
        
        //remove os produtos sem nome
		for (int c = listaProdutos.size() - 1; c >= 0; c--) {
			if (listaProdutos.get(c).getNome()==null){
				listaProdutos.remove(c);
			}
		}
        
        boolean sucesso = true;
        StringBuilder verificarDados=new StringBuilder();
        for (Produto produto : listaProdutos){
            try{
                System.out.println(produto.getNome());
               if (!produtosDAO.inserirProduto(produto)){
            	   verificarDados.append(produto.getNome()).append(", ");
               }
            } catch (SQLException e){
            	sucesso = false;
            	e.printStackTrace();
                return ("Ocorreu o seguinte erro ao carregar o registro " + produto.getCodigo() + ": " + e.getMessage());
            }
        }
        if (!sucesso || listaProdutos.size() ==0 )
            return "Falha ao importar os dados.";

        else {
        	if (verificarDados.length()>0){
        		return "Dados carregados com sucesso.\n Produtos: " + verificarDados.toString().substring(0, verificarDados.length()-2);
        	} else {
        		return "Dados foram carregados com Sucesso!";
        	}
        }
    }
    
    public String importarPrecosDoArquivo(String nomeArquivo){
        listaProdutos = produtosDAO.getObjetos(nomeArquivo);
        
        //remove os produtos sem vigencia
		for (int c = listaProdutos.size() - 1; c >= 0; c--) {
			if (listaProdutos.get(c).getInicioVigenciaPreco()==null){
				listaProdutos.remove(c);
			}
		}
		
        boolean sucesso = true;
        StringBuilder verificarDados=new StringBuilder();
        for (Produto produto : listaProdutos){
            try {
                System.out.println(produto.getCodigo());
                if (!produtosDAO.inserirDadosDePrecoNoProduto(produto)){
                	verificarDados.append(produto.getCodigo()).append(", ");
                }
            } catch (SQLException e){
            	sucesso = false;
            	e.printStackTrace();
                return ("Ocorreu o seguinte erro ao carregar o registro " + produto.getCodigo() + ": " + e.getMessage());
            }
        }
        if (!sucesso || listaProdutos.size() ==0 ){
            return "Falha ao importar os dados.";
        } else {
        	if (verificarDados.length()>0){
        		return "Dados carregados com sucesso.\n Preços: " + verificarDados.toString().substring(0, verificarDados.length()-2);
        	} else {
        		return "Dados foram carregados com Sucesso!";
        	}
        }
    }
    
 
}
