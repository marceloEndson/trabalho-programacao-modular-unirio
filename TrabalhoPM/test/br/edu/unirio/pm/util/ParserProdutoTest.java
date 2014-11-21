/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirio.pm.util;

import br.edu.unirio.pm.model.Produto;
import org.joda.time.LocalDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author MCE
 */
 //Formato da String no arquivo é: "7894900700015;Coca Cola Zero" , onde o separador é o ";"
public class ParserProdutoTest {
    private Parser<Produto> parserProduto;
    private final LocalDate INICIO_VIGENCIA_PRECO_10_05_2013 = new LocalDate(2013,05,10);
    private final long CODIGO_PRODUTO_FINAL_036 = 7897123884036L;
    private final long CODIGO_PRODUTO_FINAL_015 = 7894900700015L;
    private final double PRECO_PRODUTO = 2.0;
    
    @Before
    public void setUp(){
        parserProduto = new ParserProduto();
    }
    
    @Test
    public void dadoUmaStringComCodigoENomeDoProdutoRetornaUmProduto() {
        Produto produto = parserProduto.processa("7894900700015;Coca Cola Zero");
        assertEquals(CODIGO_PRODUTO_FINAL_015, produto.getCodigo());
        assertEquals("Coca Cola Zero", produto.getNome());
    }
    
    @Test
    public void dadoUmaStringComCodigoContendoUmaLetraENomeDoProdutoRetornaNullELancaUmaExcecao() {
        Produto produto = parserProduto.processa("A7894900700015;Coca Cola Zero");
        assertNull(produto);
    }
    
    @Test
    public void dadoUmaStringComCodigoNegativoENomeDoProdutoRetornaNullELancaUmaExcecao() {
        Produto produto = parserProduto.processa("-7894900700015;Coca Cola Zero");        
        assertNull(produto);
    }
    
    @Test
    public void dadoUmaStringComCodigoPrecoEDataVigenciaPrecoDoProdutoRetornaUmProduto() {
        Produto produto = parserProduto.processa("10/05/2013;7897123884036;2.00");        
        assertEquals(INICIO_VIGENCIA_PRECO_10_05_2013, produto.getInicioVigenciaPreco());
        assertEquals(CODIGO_PRODUTO_FINAL_036, produto.getCodigo());
        assertEquals(PRECO_PRODUTO, produto.getPreco(), 0.01);
    }
    
    @Test
    public void dadoUmaStringComCodigoPrecoEDataVigenciaPrecoInvalidaDoProdutoRetornaNullELancaUmaExcecao() {
        Produto produto = parserProduto.processa("29/02/2013;7897123884036;2.00");  
        assertNull(produto);
    }
    
    @Test
    public void dadoUmaStringComCodigoPrecoInvalidoEDataVigenciaPrecoDoProdutoRetornaNullELancaUmaExcecao() {
        Produto produto = parserProduto.processa("10/05/2013;7897123884036;-2.00");  
        assertNull(produto);
    }
    
}
