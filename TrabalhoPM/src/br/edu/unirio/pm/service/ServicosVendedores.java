/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.service;

import br.edu.unirio.pm.dao.AbstractArquivosDAO;
import br.edu.unirio.pm.dao.VendasDAO;
import br.edu.unirio.pm.dao.VendedoresDAO;
import br.edu.unirio.pm.model.Vendedor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rogerio Silva
 * 
 */
public class ServicosVendedores {
    
    private VendedoresDAO vendedoresDAO;    
    private List<Vendedor> listaVendedores;

    public ServicosVendedores() {
    	  vendedoresDAO = new VendedoresDAO();
          listaVendedores = new ArrayList<>();
    }
    
    public AbstractArquivosDAO getVendasDAO() {
    	return vendedoresDAO;
        }

        public void setVendedoresDAO(VendedoresDAO vendedoresDAO) {
    	this.vendedoresDAO = vendedoresDAO;
        }
    
    public String importarVendedoresDoArquivo(String nomeArquivo){
        listaVendedores = vendedoresDAO.getObjetos(nomeArquivo);
        boolean sucesso = true;
        StringBuilder idAtualizado=new StringBuilder();
        for (Vendedor vendedor : listaVendedores){
            try{
                System.out.println(vendedor.getNome());
                if (!vendedoresDAO.inserirVendedor(vendedor)){
                	idAtualizado.append(vendedor.getCodigo()).append(", ");
                }
            } catch (SQLException e){
            	sucesso = false;
            	e.printStackTrace();
                return ("Ocorreu o seguinte erro ao carregar o registro " + vendedor.getCodigo() + ": " + e.getMessage());
            }
        }
        if (!sucesso || listaVendedores.size()==0) {
            return "Falha ao importar os dados.";
        } else {
        	if (idAtualizado.length()>0){
        		return "Dados carregados com sucesso.\n Foram atualizados o Nome e a Categoria do seguintes IDS que já existiam: \n" + idAtualizado.toString().substring(0, idAtualizado.length()-2);
        	} else {
        		return "Dados foram carregados com Sucesso!";
        	}
        }
    }
    
    public List<Vendedor> obterListaVendedores() throws SQLException{
        listaVendedores = vendedoresDAO.obterListaVendedores();
        return listaVendedores;
    }
}
