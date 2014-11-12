/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acessodados;

import negocio.Vendedor;

/**
 *
 * @author MCE
 */
public class VendedoresDAO extends AbstractArquivosDAO<Vendedor>{

    @Override
    public Parser<Vendedor> getParser() {
        return new ParserVendedor();
    }
    
}
