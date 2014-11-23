/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirio.pm.service;

import br.edu.unirio.pm.model.Vendedor;
import java.sql.SQLException;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 *
 * @author MCE
 */
@RunWith(Theories.class)
public class ServicosComissoesTest {

    private final MesEscolhido mesEscolhido;
    private final Vendedor vendedor;
    private final double resultado;   

    public ServicosComissoesTest(MesEscolhido mesEscolhido, Vendedor vendedor, Double resultado) {
        this.mesEscolhido = mesEscolhido;
        this.vendedor = vendedor;
        this.resultado = resultado;
    }

    @DataPoints
    public static ServicosComissoesTest[] obterTotalVendaMensalPorVendedor = {
        new ServicosComissoesTest(new MesEscolhido(2013, 1), new Vendedor(20, "MANOEL DA SILVA", 1), 999.99),
        new ServicosComissoesTest(new MesEscolhido(2013, 2), new Vendedor(20, "MANOEL DA SILVA", 1), 1000.00),
        new ServicosComissoesTest(new MesEscolhido(2013, 3), new Vendedor(20, "MANOEL DA SILVA", 1), 1000.01),
        new ServicosComissoesTest(new MesEscolhido(2013, 4), new Vendedor(20, "MANOEL DA SILVA", 1), 1799.99),
        new ServicosComissoesTest(new MesEscolhido(2013, 5), new Vendedor(20, "MANOEL DA SILVA", 1), 1800.00),
        new ServicosComissoesTest(new MesEscolhido(2013, 6), new Vendedor(20, "MANOEL DA SILVA", 1), 1800.01),
        new ServicosComissoesTest(new MesEscolhido(2013, 7), new Vendedor(20, "MANOEL DA SILVA", 1), 1999.99),
        new ServicosComissoesTest(new MesEscolhido(2013, 8), new Vendedor(20, "MANOEL DA SILVA", 1), 2000.01),
        new ServicosComissoesTest(new MesEscolhido(2013, 9), new Vendedor(20, "MANOEL DA SILVA", 1), 5000.00),
        
        new ServicosComissoesTest(new MesEscolhido(2013, 1), new Vendedor(21, "JOANA ANGELICA", 2), 1999.99),
        new ServicosComissoesTest(new MesEscolhido(2013, 2), new Vendedor(21, "JOANA ANGELICA", 2), 2000.00),
        new ServicosComissoesTest(new MesEscolhido(2013, 3), new Vendedor(21, "JOANA ANGELICA", 2), 2000.01),
        new ServicosComissoesTest(new MesEscolhido(2013, 4), new Vendedor(21, "JOANA ANGELICA", 2), 3999.99),
        new ServicosComissoesTest(new MesEscolhido(2013, 5), new Vendedor(21, "JOANA ANGELICA", 2), 4000.00),
        new ServicosComissoesTest(new MesEscolhido(2013, 6), new Vendedor(21, "JOANA ANGELICA", 2), 4000.01),
        new ServicosComissoesTest(new MesEscolhido(2013, 7), new Vendedor(21, "JOANA ANGELICA", 2), 0.00),
        new ServicosComissoesTest(new MesEscolhido(2013, 8), new Vendedor(21, "JOANA ANGELICA", 2), 0.00),
        new ServicosComissoesTest(new MesEscolhido(2013, 9), new Vendedor(21, "JOANA ANGELICA", 2), 5000.00)    
    };
    
    @DataPoints
    public static ServicosComissoesTest[] obterComissaoMensalPorVendedor = {
        new ServicosComissoesTest(new MesEscolhido(2013, 1), new Vendedor(20, "MANOEL DA SILVA", 1), 99.99),
        new ServicosComissoesTest(new MesEscolhido(2013, 2), new Vendedor(20, "MANOEL DA SILVA", 1), 100.00),
        new ServicosComissoesTest(new MesEscolhido(2013, 3), new Vendedor(20, "MANOEL DA SILVA", 1), 150.00),
        new ServicosComissoesTest(new MesEscolhido(2013, 4), new Vendedor(20, "MANOEL DA SILVA", 1), 269.99),
        new ServicosComissoesTest(new MesEscolhido(2013, 5), new Vendedor(20, "MANOEL DA SILVA", 1), 270.00),
        new ServicosComissoesTest(new MesEscolhido(2013, 6), new Vendedor(20, "MANOEL DA SILVA", 1), 360.01),
        new ServicosComissoesTest(new MesEscolhido(2013, 7), new Vendedor(20, "MANOEL DA SILVA", 1), 399.99),
        new ServicosComissoesTest(new MesEscolhido(2013, 8), new Vendedor(20, "MANOEL DA SILVA", 1), 260.00),
        new ServicosComissoesTest(new MesEscolhido(2013, 9), new Vendedor(20, "MANOEL DA SILVA", 1), 860.00),
        
        new ServicosComissoesTest(new MesEscolhido(2013, 1), new Vendedor(21, "JOANA ANGELICA", 2), 199.99),
        new ServicosComissoesTest(new MesEscolhido(2013, 2), new Vendedor(21, "JOANA ANGELICA", 2), 200.00),
        new ServicosComissoesTest(new MesEscolhido(2013, 3), new Vendedor(21, "JOANA ANGELICA", 2), 400.00),
        new ServicosComissoesTest(new MesEscolhido(2013, 4), new Vendedor(21, "JOANA ANGELICA", 2), 799.99),
        new ServicosComissoesTest(new MesEscolhido(2013, 5), new Vendedor(21, "JOANA ANGELICA", 2), 800.00),
        new ServicosComissoesTest(new MesEscolhido(2013, 6), new Vendedor(21, "JOANA ANGELICA", 2), 1200.00),
        new ServicosComissoesTest(new MesEscolhido(2013, 7), new Vendedor(21, "JOANA ANGELICA", 2), 0.00),
        new ServicosComissoesTest(new MesEscolhido(2013, 8), new Vendedor(21, "JOANA ANGELICA", 2), 0.00),
        new ServicosComissoesTest(new MesEscolhido(2013, 9), new Vendedor(21, "JOANA ANGELICA", 2), 1500.00)    
    };
    
    @Theory
    public void testObterTotalVendaMensalPorVendedor(ServicosComissoesTest cenario) throws SQLException{
        Assume.assumeTrue(Arrays.asList(obterTotalVendaMensalPorVendedor).contains(cenario));
        ServicosComissoes instance = new ServicosComissoes();
        double totalVendas = instance.obterTotalVendaMensalPorVendedor(cenario.vendedor, cenario.mesEscolhido);
        assertEquals(cenario.resultado, totalVendas, 0.01);
    }
    
    @Theory
    public void testobterComissaoMensalPorVendedor (ServicosComissoesTest cenario) throws SQLException{
        Assume.assumeTrue(Arrays.asList(obterTotalVendaMensalPorVendedor).contains(cenario));
        ServicosComissoes instance = new ServicosComissoes();
        double comissao = instance.obterComissaoMensalPorVendedor(cenario.vendedor, cenario.mesEscolhido);
        assertEquals(cenario.resultado, comissao, 0.01);
    }
}
