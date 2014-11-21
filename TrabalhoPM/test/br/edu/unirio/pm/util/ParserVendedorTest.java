/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirio.pm.util;

import br.edu.unirio.pm.model.Vendedor;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author MCE
 */
public class ParserVendedorTest {
    private Parser<Vendedor> parserVendedor;
    
    @Before
    public void setUp(){
        parserVendedor = new ParserVendedor();

    }
    
    @Test
    public void dadoUmaStringComUmCodigo21UmNomeEUmaCategoria2DeVendedorRetornaUmVendedor() {
        Vendedor vendedor = parserVendedor.processa("0021;JOANA ANGELICA;2");
        assertEquals(21, vendedor.getCodigo());
        assertEquals("JOANA ANGELICA", vendedor.getNome());
        assertEquals(2, vendedor.getCategoria());
    }
    
   @Test
    public void dadoUmaStringComUmCodigo20UmNomeEUmaCategoria1DeVendedorRetornaUmVendedor() {
        Vendedor vendedor = parserVendedor.processa("0020;MANOEL DA SILVA;1");
        assertEquals(20, vendedor.getCodigo());
        assertEquals("MANOEL DA SILVA", vendedor.getNome());
        assertEquals(1, vendedor.getCategoria());
    }
    
    @Test
    public void dadoUmaStringComUmCodigoNegativoUmNomeEUmaCategoriaDeVendedorRetornaNull() {
        Vendedor vendedor = parserVendedor.processa("-0021;JOANA ANGELICA;2");
        assertNull(vendedor);
    }

    @Test
    public void dadoUmaStringComUmCodigoUmNomeEUmaCategoriaIgualA3DeVendedorRetornaUmNull() {
        Vendedor vendedor = parserVendedor.processa("0021;JOANA ANGELICA;3");
        assertNull(vendedor);
    }

    @Test
    public void dadoUmaStringComUmCodigoUmNomeEUmaCategoriaIgualA0DeVendedorRetornaUmNull() {
        Vendedor vendedor = parserVendedor.processa("0021;JOANA ANGELICA;0");
        assertNull(vendedor);
    }
    
    @Test
    public void dadoUmaStringComUmCodigoIgualabcUmNomeEUmaCategoriaIDeVendedorRetornaUmNull() {
        Vendedor vendedor = parserVendedor.processa("abc;JOANA ANGELICA;1");
        assertNull(vendedor);
    }
    
    @Test
    public void dadoUmaStringComUmCodigoUmNomeEUmaCategoriaIgualcDeVendedorRetornaUmNull() {
        Vendedor vendedor = parserVendedor.processa("0021;JOANA ANGELICA;c");
        assertNull(vendedor);
    }
}
