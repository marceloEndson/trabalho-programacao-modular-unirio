package br.edu.unirio.pm.dao;

import br.edu.unirio.pm.model.Produto;
import java.util.List;
import static org.junit.Assert.assertEquals;
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
    
    @Test
    public void ProdutoDAOTest() {
        AbstractArquivosDAO<Produto> produtoDAO = new ProdutosDAO();
        List<Produto> produtos = produtoDAO.getObjetos("test/br/edu/unirio/pm/dao/dadosDeProdutos.txt");
        
        assertEquals(2,produtos.size());
        
        assertEquals(new Produto(7897123884036L, "Agua Mineral Prata").getCodigo(), produtos.get(0).getCodigo());
        assertEquals(new Produto(7894900700015L, "Coca Cola Zero").getCodigo(), produtos.get(1).getCodigo());
    }
}
