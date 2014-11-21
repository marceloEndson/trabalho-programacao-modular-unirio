/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.service;

import br.edu.unirio.pm.dao.AbstractArquivosDAO;
import br.edu.unirio.pm.dao.VendasDAO;
import br.edu.unirio.pm.model.Venda;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Luiz Carlos
 */
public class ServicosVendas {
    
    private VendasDAO vendasDAO;    
    private List<Venda> listaVendas;

    public ServicosVendas() {
    	  vendasDAO = new VendasDAO();
          listaVendas = new ArrayList<>();
    }
    
    public AbstractArquivosDAO getVendasDAO() {
	return vendasDAO;
    }

    public void setVendasDAO(VendasDAO vendasDAO) {
	this.vendasDAO = vendasDAO;
    }
    
    public String importarPrecosDoArquivo(String nomeArquivo){
        listaVendas = vendasDAO.getObjetos(nomeArquivo);
        boolean sucesso = false;
        for (Venda venda : listaVendas){
            try {
                sucesso = vendasDAO.inserirVenda(venda);
            } catch (SQLException e) {
                return "Ocorreu o seguinte erro ao carregar o registro: " + e.getMessage();
            }
        }
        if (!sucesso)
            return "Falha ao importar os dados.";
        else
            return "Dados foram carregados com Sucesso!";
    }


}
