/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import org.joda.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Felipe
 */
public class ProdutoTest {
    
    private long codigo = 1;
    private String nome = "teste";
    private double preco = 1.00;
    LocalDate data;
    private static int DIA = 1;
    private static int MES = 1;
    private static int ANO = 2014;
    private boolean retornoBooleano = true;
    /**
     * Test of getCodigo method, of class Produto.
     */
    @Test
    public void testGetCodigo() {
        Produto instance = new Produto(codigo, nome);
        assertEquals(codigo, instance.getCodigo());
    }

    /**
     * Test of setCodigo method, of class Produto.
     */
    @Test
    public void testSetCodigo() {
        Produto instance = new Produto();
        instance.setCodigo(codigo);
        assertEquals(codigo, instance.getCodigo());
    }

    /**
     * Test of getNome method, of class Produto.
     */
    @Test
    public void testGetNome() {
        Produto instance = new Produto(codigo, nome);
        assertEquals(nome, instance.getNome());
    }

    /**
     * Test of setNome method, of class Produto.
     */
    @Test
    public void testSetNome() {
        Produto instance = new Produto();
        instance.setNome(nome);
        assertEquals(nome, instance.getNome());
    }
  
    /**
     * Test of setPreco method, of class Produto.
     */
    @Test
    public void testSetPreco() {
        Produto instance = new Produto();
        instance.setPreco(preco * 3);
        assertEquals(instance.getPreco(), preco * 3, 0);
    }

    /**
     * Test of setInicioVigenciaPreco method, of class Produto.
     */
    @Test
    public void testSetInicioVigenciaPreco() {
        Produto instance = new Produto();
        data = new LocalDate(ANO, MES, DIA);
        instance.setInicioVigenciaPreco(data);
        assertEquals(data, instance.getInicioVigenciaPreco());
    }

        /**
     * Test of equals method, of class Produto.
     */
    @Test
    public void testEquals() {
        Produto primeiroProduto = new Produto(codigo, nome);
        Produto segundoProduto = new Produto(codigo, nome);
        assertEquals(retornoBooleano, primeiroProduto.equals(segundoProduto));
    }
    
}
