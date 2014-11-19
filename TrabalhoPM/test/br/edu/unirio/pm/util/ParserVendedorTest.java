/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.util;

import br.edu.unirio.pm.model.Vendedor;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author MCE
 */
public class ParserVendedorTest {
    
  @Test
  public void dadoUmaStringComUmCodigoUmNomeEUmaCategoriaDeVendedorRetornaUmVendedor(){
      Parser<Vendedor> parserVendedor = new ParserVendedor();
      Vendedor vendedor = parserVendedor.processa("0021;JOANA ANGELICA;2");
      
      assertEquals(0021L, vendedor.getCodigo());
  }
  
  @Test
  public void dadoUmaStringComUmCodigoNegativoUmNomeEUmaCategoriaDeVendedorRetornaUmVendedor(){
      Parser<Vendedor> parserVendedor = new ParserVendedor();
      Vendedor vendedor = parserVendedor.processa("-0021;JOANA ANGELICA;2");
      
      assertNull(vendedor);
  }
  
  @Test
  public void dadoUmaStringComUmCodigoUmNomeEUmaCategoriaIgualA3DeVendedorRetornaUmVendedor(){
      Parser<Vendedor> parserVendedor = new ParserVendedor();
      Vendedor vendedor = parserVendedor.processa("0021;JOANA ANGELICA;3");
      
      assertNull(vendedor);
  }
  
  @Test
  public void dadoUmaStringComUmCodigoUmNomeEUmaCategoriaIgualA0DeVendedorRetornaUmVendedor(){
      Parser<Vendedor> parserVendedor = new ParserVendedor();
      Vendedor vendedor = parserVendedor.processa("0021;JOANA ANGELICA;0");
      
      assertNull(vendedor);
  }
}
