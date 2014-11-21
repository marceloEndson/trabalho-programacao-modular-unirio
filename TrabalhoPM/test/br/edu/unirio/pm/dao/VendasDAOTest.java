/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.dao;

import br.edu.unirio.pm.model.Venda;
import java.util.List;
import org.joda.time.LocalDate;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author MCE
 */
public class VendasDAOTest {
    private final LocalDate DATA_VENDA_10_05_2013 = new LocalDate(2013,05,10);
    private final LocalDate DATA_VENDA_12_05_2013 = new LocalDate(2013,05,12);
    private final LocalDate DATA_VENDA_01_06_2013 = new LocalDate(2013,06,01);
    private final LocalDate DATA_VENDA_02_06_2013 = new LocalDate(2013,06,02);
    private final LocalDate DATA_VENDA_10_07_2013 = new LocalDate(2013,07,10);
    private final LocalDate DATA_VENDA_12_07_2013 = new LocalDate(2013,07,12);
    private final int QUANTIDADA_PRODUTOS_30 = 30;
    private final int QUANTIDADA_PRODUTOS_50 = 50;
    private final int QUANTIDADA_PRODUTOS_80 = 80;
    private final long CODIGO_PRODUTO_COM_FINAL_036 = 7897123884036L;
    private final long CODIGO_PRODUTO_COM_FINAL_015 = 7894900700015L;
    private final int CODIGO_VENDEDOR_020 = 020;
    private final int CODIGO_VENDEDOR_021 = 021;
    private final String NOME_ARQUIVO = "test/br/edu/unirio/pm/dao/dadosDeVendas.txt";
    private List<Venda> vendas;

    
    @Before
    public void setUpListaDeVendas(){
        AbstractArquivosDAO<Venda> vendaDAO = new VendasDAO();
     // AbstractArquivosDAO<Venda> vendaDAO = mock(VendasDAO.class);
        vendas = vendaDAO.getObjetos(NOME_ARQUIVO);
    }
       
    @Test
    public void vendasDAOTestTotalDeObjetosNaLista(){  
        
        assertEquals(24,vendas.size());
    }
    
    @Test
    public void dadoUmaListaComVendasVerificaAsVendaNaPrimeiraPosicaoDaLista(){
        Venda venda = vendas.get(0);
        assertEquals(DATA_VENDA_10_05_2013, venda.getDataVenda());
        assertEquals(QUANTIDADA_PRODUTOS_30, venda.getQuantidadeVendida());
        assertEquals(CODIGO_PRODUTO_COM_FINAL_036, venda.getProduto().getCodigo());
        assertEquals(CODIGO_VENDEDOR_020, venda.getVendedor().getCodigo());
    }
    
    @Test
    public void dadoUmaListaComVendasVerificaAsVendaNaQuintaPosicaoDaLista(){
        Venda venda = vendas.get(4);
        assertEquals(DATA_VENDA_12_05_2013, venda.getDataVenda());
        assertEquals(QUANTIDADA_PRODUTOS_30, venda.getQuantidadeVendida());
        assertEquals(CODIGO_PRODUTO_COM_FINAL_036, venda.getProduto().getCodigo());
        assertEquals(CODIGO_VENDEDOR_020, venda.getVendedor().getCodigo());
    }
    
    @Test
    public void dadoUmaListaComVendasVerificaAsVendaNaDecimaPosicaoDaLista(){
        Venda venda = vendas.get(9);
        assertEquals(DATA_VENDA_01_06_2013, venda.getDataVenda());
        assertEquals(QUANTIDADA_PRODUTOS_50, venda.getQuantidadeVendida());
        assertEquals(CODIGO_PRODUTO_COM_FINAL_015, venda.getProduto().getCodigo());
        assertEquals(CODIGO_VENDEDOR_020, venda.getVendedor().getCodigo());
    }
    
    @Test
    public void dadoUmaListaComVendasVerificaAsVendaNaDecimaQuintaPosicaoDaLista(){
        Venda venda = vendas.get(14);
        assertEquals(DATA_VENDA_02_06_2013, venda.getDataVenda());
        assertEquals(QUANTIDADA_PRODUTOS_50, venda.getQuantidadeVendida());
        assertEquals(CODIGO_PRODUTO_COM_FINAL_036, venda.getProduto().getCodigo());
        assertEquals(CODIGO_VENDEDOR_021, venda.getVendedor().getCodigo());
    }
    
    @Test
    public void dadoUmaListaComVendasVerificaAsVendaNaDecimaOitavaPosicaoDaLista(){
        Venda venda = vendas.get(17);
        assertEquals(DATA_VENDA_10_07_2013, venda.getDataVenda());
        assertEquals(QUANTIDADA_PRODUTOS_50, venda.getQuantidadeVendida());
        assertEquals(CODIGO_PRODUTO_COM_FINAL_015, venda.getProduto().getCodigo());
        assertEquals(CODIGO_VENDEDOR_020, venda.getVendedor().getCodigo());
    }
    
    @Test
    public void dadoUmaListaComVendasVerificaAsVendaNaUltimaPosicaoDaLista(){
        Venda venda = vendas.get(23);
        assertEquals(DATA_VENDA_12_07_2013, venda.getDataVenda());
        assertEquals(QUANTIDADA_PRODUTOS_80, venda.getQuantidadeVendida());
        assertEquals(CODIGO_PRODUTO_COM_FINAL_015, venda.getProduto().getCodigo());
        assertEquals(CODIGO_VENDEDOR_021, venda.getVendedor().getCodigo());
    }
}
