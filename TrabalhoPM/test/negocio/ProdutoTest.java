/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Felipe
 */
public class ProdutoTest {
    
    final int CODIGO = 1;
    final String NOME = "teste";
    final double PRECO = 1.00;
    Calendar data;
    final int DIA = 1;
    final int MES = 1;
    final int ANO = 2014;
    final boolean retornoBooleano = true;
    
    public ProdutoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCodigo method, of class Produto.
     */
    @Test
    public void testGetCodigo() {
        Produto instance = new Produto(CODIGO, NOME);
        assertEquals(CODIGO, instance.getCodigo());
    }

    /**
     * Test of setCodigo method, of class Produto.
     */
    @Test
    public void testSetCodigo() {
        Produto instance = new Produto();
        instance.setCodigo(CODIGO * 2);
        assertEquals(CODIGO * 2, instance.getCodigo());
    }

    /**
     * Test of getNome method, of class Produto.
     */
    @Test
    public void testGetNome() {
        Produto instance = new Produto(CODIGO, NOME);
        assertEquals(NOME, instance.getNome());
    }

    /**
     * Test of setNome method, of class Produto.
     */
    @Test
    public void testSetNome() {
        Produto instance = new Produto();
        instance.setNome(NOME);
        assertEquals(NOME, instance.getNome());
    }
  
    /**
     * Test of setPreco method, of class Produto.
     */
    @Test
    public void testSetPreco() {
        Produto instance = new Produto();
        instance.setPreco(PRECO * 3);
        assertEquals(instance.getPreco(), PRECO * 3, 0);
    }

    /**
     * Test of setInicioVigenciaPreco method, of class Produto.
     */
    @Test
    public void testSetInicioVigenciaPreco() {
        Produto instance = new Produto();
        data = Calendar.getInstance();
        data.set(ANO, MES, DIA);
        instance.setInicioVigenciaPreco(data);
        assertEquals(data, instance.getInicioVigenciaPreco());
    }

        /**
     * Test of equals method, of class Produto.
     */
    @Test
    public void testEquals() {
        Produto primeiroProduto = new Produto(CODIGO, NOME);
        Produto segundoProduto = new Produto(CODIGO, NOME);
        assertEquals(retornoBooleano, primeiroProduto.equals(segundoProduto));
    }
    
}
