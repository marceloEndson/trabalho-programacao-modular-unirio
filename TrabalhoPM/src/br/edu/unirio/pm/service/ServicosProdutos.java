/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.service;

import br.edu.unirio.pm.dao.ProdutosDAO;
import br.edu.unirio.pm.model.Produto;
import br.edu.unirio.pm.resource.BDProdutosXml;
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
        for (Produto produto : listaProdutos){
            try{
                produtosDAO.inserirProduto(produto);
            } catch (SQLException e){
                return "Ocorreu o seguinte erro ao carregar o registro " + produto.getCodigo() + ": " + e.getMessage();
            }
        }
        return "Dados foram carregados com Sucesso!";
    }
    
    public String importarPrecosDoArquivo(String nomeArquivo){
        listaProdutos = produtosDAO.getObjetos(nomeArquivo);
        boolean sucesso = false;
        for (Produto produto : listaProdutos){
            try {
                System.out.println(produto.getCodigo());
                sucesso = produtosDAO.inserirDadosDePrecoNoProduto(produto);
            } catch (SQLException e) {
                return "Ocorreu o seguinte erro ao carregar o registro " + produto.getCodigo() + ": " + e.getMessage();
            }
        }
        if (!sucesso)
            return "Falha ao importar os dados.";
        else
            return "Dados foram carregados com Sucesso!";
    }
    
    public void atualizarPrecosDosProdutos(){
        // TODO
    }
}
