/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirio.pm.dao;

import br.edu.unirio.pm.model.Venda;
import br.edu.unirio.pm.util.Parser;
import br.edu.unirio.pm.util.ParserVenda;

/**
 *
 * @author MCE
 */
public class VendasDAO extends AbstractArquivosDAO<Venda> {

    @Override
    public Parser<Venda> getParser() {
        return new ParserVenda();
    }

}
