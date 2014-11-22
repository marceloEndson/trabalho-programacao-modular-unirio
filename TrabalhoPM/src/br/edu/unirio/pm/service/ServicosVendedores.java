/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.service;

import br.edu.unirio.pm.dao.AbstractArquivosDAO;
import br.edu.unirio.pm.dao.VendedoresDAO;
import br.edu.unirio.pm.model.Produto;
import br.edu.unirio.pm.model.Venda;
import br.edu.unirio.pm.model.Vendedor;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Rogerio Silva
 */
public class ServicosVendedores {
    
    private VendedoresDAO vendedoresDAO;    
    private List<Vendedor> listaVendedores;

    public ServicosVendedores() {
    	  vendedoresDAO = new VendedoresDAO();
          listaVendedores = new ArrayList<>();
    }
    
    public String importarVendedoresDoArquivo(String nomeArquivo){
        listaVendedores = vendedoresDAO.getObjetos(nomeArquivo);
        for (Vendedor vendedor : listaVendedores){
            try{
                vendedoresDAO.inserirVendedor(vendedor);
            } catch (SQLException e){
                return "Ocorreu o seguinte erro ao carregar o registro " + vendedor.getCodigo() + ": " + e.getMessage();
            }
        }
        return "Dados foram carregados com Sucesso!";
    }
    
    
   

	public AbstractArquivosDAO getVendedoresDAO() {
		return vendedoresDAO;
	}


	public void setVendedoresDAO(VendedoresDAO vendedoresDAO) {
		this.vendedoresDAO = vendedoresDAO;
	}


}
