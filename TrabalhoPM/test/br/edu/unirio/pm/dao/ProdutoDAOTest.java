package br.edu.unirio.pm.dao;

import br.edu.unirio.pm.model.Produto;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MCE
 */
public class ProdutoDAOTest {
    private List<Produto> produtos;
    private final String NOME_ARQUIVO = "test/br/edu/unirio/pm/dao/dadosDeProdutos.txt";
    private final long CODIGO_PRODUTO_FINAL_036 = 7897123884036L;
    private final long CODIGO_PRODUTO_FINAL_015 = 7894900700015L;
    private final String COCA_COLA_ZERO = "Coca Cola Zero";
    private final String AGUA_MINERAL_PRATA = "Agua Mineral Prata";
    
    @Before
    public void setUpListaProdutos(){
        AbstractArquivosDAO<Produto> produtoDAO = new ProdutosDAO();
        produtos = produtoDAO.getObjetos(NOME_ARQUIVO);
    }
    
    @Test
    public void ProdutoDAOTestTotalDeProdutosNaLista() {       
        assertEquals(2,produtos.size());
    }
    
    @Test
    public void dadoUmaListaDeProdutosVerificaOProdutoNaPrimeiraPosicao(){
        Produto produto = produtos.get(0);
        assertEquals(CODIGO_PRODUTO_FINAL_036, produto.getCodigo());
        assertEquals(AGUA_MINERAL_PRATA, produto.getNome());
    }
    
    @Test
    public void dadoUmaListaDeProdutosVerificaOProdutoNaUltimaPosicao(){
        Produto produto = produtos.get(1);
        assertEquals(CODIGO_PRODUTO_FINAL_015, produto.getCodigo());
        assertEquals(COCA_COLA_ZERO, produto.getNome());
    }
}
