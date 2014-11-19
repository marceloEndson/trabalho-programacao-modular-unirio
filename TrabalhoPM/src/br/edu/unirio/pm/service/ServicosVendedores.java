/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.service;

import br.edu.unirio.pm.action.LerArquivoProdutosTxt;
import br.edu.unirio.pm.action.LerArquivoVendedoresTxt;
import br.edu.unirio.pm.model.Vendedor;
import br.edu.unirio.pm.resource.BDProdutosXml;
import br.edu.unirio.pm.resource.BDVendedoresXml;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rogerio Silva
 */
public class ServicosVendedores {
    
    private LerArquivoVendedoresTxt lerArquivoVendedoresTxt;
    private BDVendedoresXml bdVendedoresXml;    
    private Map<Integer, Vendedor> mapaCodigoVendedores;

    public ServicosVendedores() {
    	  lerArquivoVendedoresTxt = new LerArquivoVendedoresTxt();
          bdVendedoresXml = new BDVendedoresXml();
          mapaCodigoVendedores = new HashMap<>();
    }
    
    
   

	public LerArquivoVendedoresTxt getLerArquivoVendedoresTxt() {
		return lerArquivoVendedoresTxt;
	}


	public void setLerArquivoVendedoresTxt(LerArquivoVendedoresTxt lerArquivoVendedoresTxt) {
		this.lerArquivoVendedoresTxt = lerArquivoVendedoresTxt;
	}



	public BDVendedoresXml getBdVendedoresXml() {
		return bdVendedoresXml;
	}



	public void setBdVendedoresXml(BDVendedoresXml bdVendedoresXml) {
		this.bdVendedoresXml = bdVendedoresXml;
	}


}
