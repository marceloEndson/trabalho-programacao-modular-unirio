/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirio.pm.util;

import br.edu.unirio.pm.model.Produto;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author MCE
 */
 //Formato da String no arquivo é: "7894900700015;Coca Cola Zero" , onde o separador é o ";"
public class ParserProdutoTest {

    @Test
    public void dadoUmaStringComCodigoENomeDoProdutoRetornaUmProduto() {
        Parser<Produto> parserProduto = new ParserProduto();
        Produto produto = parserProduto.processa("7894900700015;Coca Cola Zero");
        
        assertEquals(7894900700015L, produto.getCodigo());
        assertEquals("Coca Cola Zero", produto.getNome());
    }
    
    @Test
    public void dadoUmaStringComCodigoContendoUmaLetraENomeDoProdutoRetornaUmaExcecao() {
        Parser<Produto> parserProduto = new ParserProduto();
        Produto produto = parserProduto.processa("A7894900700015;Coca Cola Zero");
        
        assertNull(produto);
    }
    
    @Test
    public void dadoUmaStringComCodigoNegativoENomeDoProdutoRetornaUmaExcecao() {
        Parser<Produto> parserProduto = new ParserProduto();
        Produto produto = parserProduto.processa("-7894900700015;Coca Cola Zero");
        
        assertNull(produto);
    }
}
