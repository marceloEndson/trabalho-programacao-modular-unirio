/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conjuntodetestes;

import acessodados.ParserProdutoTest;
import acessodados.ParserVendedorTest;
import acessodados.ProdutoDAOTest;
import acessodados.VendedoresDAOTest;
import negocio.ProdutoTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author MCE
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ParserProdutoTest.class, ParserVendedorTest.class, ProdutoDAOTest.class, VendedoresDAOTest.class,
ProdutoTest.class})
public class TodosOsTestes { 
}
