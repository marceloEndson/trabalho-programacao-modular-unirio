/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.service;

import br.edu.unirio.pm.dao.AbstractArquivosDAO;
import br.edu.unirio.pm.dao.VendedoresDAO;
import br.edu.unirio.pm.model.Vendedor;
import br.edu.unirio.pm.resource.BDVendedoresXml;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rogerio Silva
 */
public class ServicosVendedores {
    
    private AbstractArquivosDAO vendedoresDAO;
    private BDVendedoresXml bdVendedoresXml;    
    private Map<Integer, Vendedor> mapaCodigoVendedores;

    public ServicosVendedores() {
    	  vendedoresDAO = new VendedoresDAO();
          bdVendedoresXml = new BDVendedoresXml();
          mapaCodigoVendedores = new HashMap<>();
    }
    
    
   

	public AbstractArquivosDAO getVendedoresDAO() {
		return vendedoresDAO;
	}


	public void setVendedoresDAO(AbstractArquivosDAO vendedoresDAO) {
		this.vendedoresDAO = vendedoresDAO;
	}



	public BDVendedoresXml getBdVendedoresXml() {
		return bdVendedoresXml;
	}



	public void setBdVendedoresXml(BDVendedoresXml bdVendedoresXml) {
		this.bdVendedoresXml = bdVendedoresXml;
	}


}
