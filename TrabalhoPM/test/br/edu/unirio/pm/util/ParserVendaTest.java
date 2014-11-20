/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.util;

import br.edu.unirio.pm.model.Venda;
import org.joda.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MCE
 */
public class ParserVendaTest {
    
   @Test
   public void dadoUmaStringComDataDaVendaQuantidadeVendidaCodigoDoProdutoECodigoDoVendedorRetornaUmaVenda() {
        Parser<Venda> parserVenda = new ParserVenda();
        Venda venda = parserVenda.processa("10/05/2013;50;7897123884036;021");
        
        assertEquals(new LocalDate(2013,05,10), venda.getDataVenda());
        assertEquals(50, venda.getQuantidadeVendida());
        assertEquals(7897123884036L, venda.getProduto().getCodigo());
        assertEquals(21, venda.getVendedor().getCodigo());
    }
    
}
