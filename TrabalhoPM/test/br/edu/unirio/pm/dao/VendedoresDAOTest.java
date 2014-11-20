/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.dao;

import br.edu.unirio.pm.model.Vendedor;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author MCE
 */
public class VendedoresDAOTest {
    private List<Vendedor> vendedores;
    private final String NOME_ARQUIVO = "test/br/edu/unirio/pm/dao/dadosDeVendedores.txt";
    private final int CODIGO_VENDEDOR_0020 = 20;
    private final int CODIGO_VENDEDOR_0021 = 21;
    private final String MANOEL_DA_SILVA = "MANOEL DA SILVA";
    private final String JOANA_ANGELICA = "JOANA ANGELICA";
    private final int CATEGORIA_1 = 1;
    private final int CATEGORIA_2 = 2;

    
    @Before
    public void setUpListaVendedores(){
        AbstractArquivosDAO<Vendedor> vendedorDAO = new VendedoresDAO();
        vendedores = vendedorDAO.getObjetos(NOME_ARQUIVO);
    }
    
    @Test
    public void VendedoresDAOTestTotalVendedoresNaLista(){
        assertEquals(2,vendedores.size());
    }
    
    @Test
    public void dadoUmaListaDeVendedoresVerificaOVendedorDaPrimeiraPosicao(){
        Vendedor vendedor = vendedores.get(0);
        assertEquals(CODIGO_VENDEDOR_0020, vendedor.getCodigo());
        assertEquals(MANOEL_DA_SILVA, vendedor.getNome());
        assertEquals(CATEGORIA_1, vendedor.getCategoria());
    }
    
    @Test
    public void dadoUmaListaDeVendedoresVerificaOVendedorDaUltimaPosicao(){
        Vendedor vendedor = vendedores.get(1);
        assertEquals(CODIGO_VENDEDOR_0021, vendedor.getCodigo());
        assertEquals(JOANA_ANGELICA, vendedor.getNome());
        assertEquals(CATEGORIA_2, vendedor.getCategoria());
    }
    
           

}
