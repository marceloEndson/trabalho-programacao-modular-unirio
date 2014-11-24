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
import java.util.logging.Level;
import java.util.logging.Logger;

import org.joda.time.LocalDate;

/**
 *
 * @author Luiz Carlos
 * @alter Rogerio Silva
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
        boolean sucesso = true;
        StringBuilder idIgnorado=new StringBuilder();
        for (Venda venda : listaVendas){
            try {
                System.out.println(venda.getDataVenda());
                if (!vendasDAO.inserirVenda(venda)){
                	idIgnorado.append(venda.getDataVenda()).append(", ");
                }
            } catch (SQLException e) {
            	sucesso = false;
            	e.printStackTrace();
                return ("Ocorreu o seguinte erro ao carregar a venda " + venda.getProduto() + ": " + e.getMessage());
            }
        }
        if (!sucesso || listaVendas.size()==0)
            return "Falha ao importar os dados.";

        else {
        	if (idIgnorado.length()>0){
        		return "Dados carregados com sucesso. Foram Ignorados os seguintes Vendedores que já existiam: " + idIgnorado.toString().substring(0, idIgnorado.length()-2);
        	} else {
        		return "Dados foram carregados com Sucesso!";
        	}
        }
    }
    
    public List<Integer> obterAnosDisponiveisParaConsulta() throws SQLException{
        List<Integer> anosDisponiveisParaConsulta = new ArrayList<>();
        LocalDate dataInicial = vendasDAO.obterDataDaVendaMaisAntiga();
        LocalDate dataFinal = vendasDAO.obterDataDaVendaMaisAtual();
        for (int ano = dataInicial.getYear(); ano <= dataFinal.getYear(); ano++){
            anosDisponiveisParaConsulta.add(ano);
        }
        return anosDisponiveisParaConsulta;    
    }


}
