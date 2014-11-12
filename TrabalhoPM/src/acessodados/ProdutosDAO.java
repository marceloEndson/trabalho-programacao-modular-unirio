/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acessodados;

import negocio.Produto;

/**
 *
 * @author MCE
 */
public class ProdutosDAO extends AbstractArquivosDAO<Produto> {

    @Override
    public Parser<Produto> getParser() {
        return new ParserProduto();
        }
    
}
