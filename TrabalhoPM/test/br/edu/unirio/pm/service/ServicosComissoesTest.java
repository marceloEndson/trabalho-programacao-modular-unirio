/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirio.pm.service;

import br.edu.unirio.pm.model.Vendedor;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author MCE
 */
public class ServicosComissoesTest {

    private ServicosComissoes instance;

    @Before
    public void setUp() {
        instance = new ServicosComissoes();
    }

    @Test
    public void testTotalVendaMensalPorVendedorJaneiro() throws SQLException {
        double totalVendaMensalVendedorCategoria1 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 1));
        assertEquals(999.99, totalVendaMensalVendedorCategoria1, 0.01);

        double totalVendaMensalVendedorCategoria2 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 1));
        assertEquals(1999.99, totalVendaMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testTotalVendaMensalPorVendedorFevereiro() throws SQLException {
        double totalVendasMensalVendedorCategoria1 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 2), new MesEscolhido(13, 1));
        assertEquals(1000.00, totalVendasMensalVendedorCategoria1, 0.01);

        double totalVendaMensalVendedorCategoria2 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 2));
        assertEquals(2000.00, totalVendaMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testTotalVendaMensalPorVendedorMarco() throws SQLException {
        double totalVendasMensalVendedorCategoria1 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 3));
        assertEquals(1000.01, totalVendasMensalVendedorCategoria1, 0.01);

        double totalVendaMensalVendedorCategoria2 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 3));
        assertEquals(2000.01, totalVendaMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testTotalVendaMensalPorVendedorAbril() throws SQLException {
        double totalVendasMensalVendedorCategoria1 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 4));
        assertEquals(1799.99, totalVendasMensalVendedorCategoria1, 0.01);

        double totalVendaMensalVendedorCategoria2 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 4));
        assertEquals(3999.99, totalVendaMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testTotalVendaMensalPorVendedorMaio() throws SQLException {
        double totalVendasMensalVendedorCategoria1 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 5));
        assertEquals(1800.00, totalVendasMensalVendedorCategoria1, 0.01);

        double totalVendaMensalVendedorCategoria2 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 5));
        assertEquals(4000.00, totalVendaMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testTotalVendaMensalPorVendedorJunho() throws SQLException {
        double totalVendasMensalVendedorCategoria1 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 6));
        assertEquals(1800.01, totalVendasMensalVendedorCategoria1, 0.01);

        double totalVendaMensalVendedorCategoria2 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 6));
        assertEquals(4000.01, totalVendaMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testTotalVendaMensalPorVendedorJulho() throws SQLException {
        double totalVendasMensalVendedorCategoria1 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 7));
        assertEquals(1999.99, totalVendasMensalVendedorCategoria1, 0.01);

        double totalVendaMensalVendedorCategoria2 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 7));
        assertEquals(0.00, totalVendaMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testTotalVendaMensalPorVendedorAgosto() throws SQLException {
        double totalVendasMensalVendedorCategoria1 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 8));
        assertEquals(2000.00, totalVendasMensalVendedorCategoria1, 0.01);

        double totalVendaMensalVendedorCategoria2 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 8));
        assertEquals(0.00, totalVendaMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testTotalVendaMensalPorVendedorSetembro() throws SQLException {
        double totalVendasMensalVendedorCategoria1 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 9));
        assertEquals(5000.00, totalVendasMensalVendedorCategoria1, 0.01);

        double totalVendaMensalVendedorCategoria2 = instance.obterTotalVendaMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 9));
        assertEquals(5000.00, totalVendaMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testobterComissaoMensalPorVendedorJaneiro() throws SQLException {
        double totalComissaoMensalVendedorCategoria1 = instance.obterComissaoMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 1));
        assertEquals(99.99, totalComissaoMensalVendedorCategoria1, 0.01);

        double totalComissaoMensalVendedorCategoria2 = instance.obterComissaoMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 1));
        assertEquals(199.99, totalComissaoMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testobterComissaoMensalPorVendedorFevereiro() throws SQLException {
        double totalComissaoMensalVendedorCategoria1 = instance.obterComissaoMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 2));
        assertEquals(100.00, totalComissaoMensalVendedorCategoria1, 0.01);

        double totalComissaoMensalVendedorCategoria2 = instance.obterComissaoMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 2));
        assertEquals(200.00, totalComissaoMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testobterComissaoMensalPorVendedorMarco() throws SQLException {
        double totalComissaoMensalVendedorCategoria1 = instance.obterComissaoMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 3));
        assertEquals(150.00, totalComissaoMensalVendedorCategoria1, 0.01);

        double totalComissaoMensalVendedorCategoria2 = instance.obterComissaoMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 3));
        assertEquals(400.00, totalComissaoMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testobterComissaoMensalPorVendedorAbril() throws SQLException {
        double totalComissaoMensalVendedorCategoria1 = instance.obterComissaoMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 4));
        assertEquals(269.99, totalComissaoMensalVendedorCategoria1, 0.01);

        double totalComissaoMensalVendedorCategoria2 = instance.obterComissaoMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 4));
        assertEquals(799.99, totalComissaoMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testobterComissaoMensalPorVendedorMaio() throws SQLException {
        double totalComissaoMensalVendedorCategoria1 = instance.obterComissaoMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 5));
        assertEquals(270.00, totalComissaoMensalVendedorCategoria1, 0.01);

        double totalComissaoMensalVendedorCategoria2 = instance.obterComissaoMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 5));
        assertEquals(800.00, totalComissaoMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testobterComissaoMensalPorVendedorJunho() throws SQLException {
        double totalComissaoMensalVendedorCategoria1 = instance.obterComissaoMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 6));
        assertEquals(360.00, totalComissaoMensalVendedorCategoria1, 0.01);

        double totalComissaoMensalVendedorCategoria2 = instance.obterComissaoMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 6));
        assertEquals(1200.00, totalComissaoMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testobterComissaoMensalPorVendedorJulho() throws SQLException {
        double totalComissaoMensalVendedorCategoria1 = instance.obterComissaoMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 7));
        assertEquals(399.99, totalComissaoMensalVendedorCategoria1, 0.01);

        double totalComissaoMensalVendedorCategoria2 = instance.obterComissaoMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 7));
        assertEquals(0.00, totalComissaoMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testobterComissaoMensalPorVendedorAgosto() throws SQLException {
        double totalComissaoMensalVendedorCategoria1 = instance.obterComissaoMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 8));
        assertEquals(260.00, totalComissaoMensalVendedorCategoria1, 0.01);

        double totalComissaoMensalVendedorCategoria2 = instance.obterComissaoMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 8));
        assertEquals(0.00, totalComissaoMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testobterComissaoMensalPorVendedorSetembro() throws SQLException {
        double totalComissaoMensalVendedorCategoria1 = instance.obterComissaoMensalPorVendedor(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 9));
        assertEquals(860.00, totalComissaoMensalVendedorCategoria1, 0.01);

        double totalComissaoMensalVendedorCategoria2 = instance.obterComissaoMensalPorVendedor(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 9));
        assertEquals(1500.00, totalComissaoMensalVendedorCategoria2, 0.01);
    }

    @Test
    public void testobterComissaoAcumuladaPorVendedor2Meses() throws SQLException {
        double totalComissaoAcumuladaVendedorCategoria1 = instance.obterComissaoAcumuladaPorVendedor(new MesEscolhido(13, 1), new MesEscolhido(13, 2), new Vendedor(20L, "MANOEL DA SILVA", 1));
        assertEquals(199.99, totalComissaoAcumuladaVendedorCategoria1, 0.01);

        double totalComissaoAcumuladaVendedorCategoria2 = instance.obterComissaoAcumuladaPorVendedor(new MesEscolhido(13, 1), new MesEscolhido(13, 2), new Vendedor(21L, "JOANA ANGELICA", 2));
        assertEquals(399.99, totalComissaoAcumuladaVendedorCategoria2, 0.01);
    }

    @Test
    public void testobterVendaAcumuladaPorVendedor2Meses() throws SQLException {
        double totalVendaAcumuladaPorVendedor1 = instance.obterVendaAcumuladaPorVendedor(new MesEscolhido(13, 1), new MesEscolhido(13, 2), new Vendedor(20L, "MANOEL DA SILVA", 1));
        assertEquals(1999.99, totalVendaAcumuladaPorVendedor1, 0.01);

        double totalVendaAcumuladaPorVendedor2 = instance.obterVendaAcumuladaPorVendedor(new MesEscolhido(13, 1), new MesEscolhido(13, 2), new Vendedor(21L, "JOANA ANGELICA", 2));
        assertEquals(3999.99, totalVendaAcumuladaPorVendedor2, 0.01);
    }

    @Test
    public void testobterComissaoAcumuladaMediaPorVendedor2Meses() throws SQLException {
        double totalComissaoAcumuladaMediaPorVendedor1 = instance.obterComissaoAcumuladaMediaPorVendedor(new MesEscolhido(13, 1), new MesEscolhido(13, 2), new Vendedor(20L, "MANOEL DA SILVA", 1));
        assertEquals(99.99, totalComissaoAcumuladaMediaPorVendedor1, 0.01);

        double totalComissaoAcumuladaMediaPorVendedor2 = instance.obterComissaoAcumuladaMediaPorVendedor(new MesEscolhido(13, 1), new MesEscolhido(13, 2), new Vendedor(21L, "JOANA ANGELICA", 2));
        assertEquals(199.99, totalComissaoAcumuladaMediaPorVendedor2, 0.01);
    }
}


/*
 @RunWith(Theories.class)
 public class ServicosComissoesTest {
 Vendedor vendedor;
 MesEscolhido mesEscolhido;
 double resultado;

 public ServicosComissoesTest(Vendedor vendedor, MesEscolhido mesEscolhido, double resultado) {
 this.vendedor = vendedor;
 this.mesEscolhido = mesEscolhido;
 this.resultado = resultado;
 }

   
 @DataPoints
 public static ServicosComissoesTest[] obterTotalVendaMensalPorVendedor = {
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 1), 999.99),
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 2), 1000.00),
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 3), 1000.01),
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 4), 1799.99),
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 5), 1800.00),
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 6), 1800.01),
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 7), 1999.99),
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 8), 2000.01),
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 9), 5000.00),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 1), 1999.99),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 2), 2000.00),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 3), 2000.01),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 4), 3999.99),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 5), 4000.00),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 6), 4000.01),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 7), 0.00),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 8), 0.00),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 9), 5000.00)
 };
    
 @DataPoints
 public static ServicosComissoesTest[] obterComissaoMensalPorVendedor = {
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 1), 99.99),
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 2), 100.00),
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 3), 150.00),
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 4), 269.99),
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 5), 270.00),
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 6), 360.01),
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 7), 399.99),
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 8), 260.00),
 new ServicosComissoesTest(new Vendedor(20L, "MANOEL DA SILVA", 1), new MesEscolhido(13, 9), 860.00),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 1), 199.99),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 2), 200.00),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 3), 400.00),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 4), 799.99),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 5), 800.00),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 6), 1200.00),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 7), 0.00),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 8), 0.00),
 new ServicosComissoesTest(new Vendedor(21L, "JOANA ANGELICA", 2), new MesEscolhido(13, 9), 1500.00)
 };

 @Theory
 public void testObterTotalVendaMensalPorVendedor(ServicosComissoesTest cenario) throws SQLException {
 Assume.assumeTrue(Arrays.asList(obterTotalVendaMensalPorVendedor).contains(cenario));
 ServicosComissoes instance = new ServicosComissoes();
 double totalVendas = instance.obterTotalVendaMensalPorVendedor(cenario.vendedor, cenario.mesEscolhido);
 assertEquals(totalVendas, cenario.resultado, 0.01);
 }

 @Theory
 public void testobterComissaoMensalPorVendedor(ServicosComissoesTest cenario) throws SQLException {
 Assume.assumeTrue(Arrays.asList(obterComissaoMensalPorVendedor).contains(cenario));
 ServicosComissoes instance = new ServicosComissoes();
 double comissao = instance.obterComissaoMensalPorVendedor(cenario.vendedor, cenario.mesEscolhido);
 assertEquals(comissao, cenario.resultado, 0.01);
 }
 }
 */
