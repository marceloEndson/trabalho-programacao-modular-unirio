/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.service;

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
public class MesEscolhidoTest {
    
    public MesEscolhidoTest() {
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

    @Test
    public void testObterQuantidadeDeDiasMesCom28Dias() {
        final int ANO = 2014;
        final int MES = 2;
        MesEscolhido instance = new MesEscolhido(ANO, MES);
        assertEquals(28, instance.obterQuantidadeDeDiasDoMes());
    }
    
    @Test
    public void testObterQuantidadeDeDiasMesCom29Dias() {
        final int ANO = 2016;
        final int MES = 2;
        MesEscolhido instance = new MesEscolhido(ANO, MES);
        assertEquals(29, instance.obterQuantidadeDeDiasDoMes());
    }
    
    @Test
    public void testObterQuantidadeDeDiasMesCom30Dias() {
        final int ANO = 2014;
        final int MES = 4;
        MesEscolhido instance = new MesEscolhido(ANO, MES);
        assertEquals(30, instance.obterQuantidadeDeDiasDoMes());
    }
    
    @Test
    public void testObterQuantidadeDeDiasMesCom31Dias() {
        final int ANO = 2014;
        final int MES = 1;
        MesEscolhido instance = new MesEscolhido(ANO, MES);
        assertEquals(31, instance.obterQuantidadeDeDiasDoMes());
    }

  
    @Test
    public void testAcrescentarUmMesInicioDoAno() {
        final int ANO = 2014;
        final int MES = 1;
        MesEscolhido instance = new MesEscolhido(ANO, MES);
        instance.acrescentarUmMes();
        assertEquals(2, instance.getMes());
    }
    
    @Test
    public void testAcrescentarUmMesFinalDoAno() {
        final int ANO = 2014;
        final int MES = 12;
        MesEscolhido instance = new MesEscolhido(ANO, MES);
        instance.acrescentarUmMes();
        assertEquals(1, instance.getMes());
        assertEquals(2015, instance.getAno());
    }

   
    @Test
    public void testEqualsMesesIguais() {
        final int ANO = 2014;
        final int MES = 12;
        MesEscolhido instance1 = new MesEscolhido(ANO, MES);
        MesEscolhido instance2 = new MesEscolhido(ANO, MES);
        boolean expResult = true;
        assertEquals(expResult, instance1.equals(instance2));
    }
    
    @Test
    public void testEqualsMesesDiferentes() {
        final int ANO1 = 2014;
        final int MES1 = 12;
        final int ANO2 = 2015;
        final int MES2 = 12;
        MesEscolhido instance1 = new MesEscolhido(ANO1, MES1);
        MesEscolhido instance2 = new MesEscolhido(ANO2, MES2);
        boolean expResult = false;
        assertEquals(expResult, instance1.equals(instance2));
    }
    
}
