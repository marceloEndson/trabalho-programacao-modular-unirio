/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.util;

import br.edu.unirio.pm.dao.ProdutosDAO;
import br.edu.unirio.pm.dao.VendedoresDAO;
import br.edu.unirio.pm.model.Produto;
import br.edu.unirio.pm.model.Venda;
import br.edu.unirio.pm.model.Vendedor;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author MCE
 */
public class ParserVenda implements Parser<Venda> {
    private final DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyy");
    private ProdutosDAO produtosDAO = new ProdutosDAO();
    private VendedoresDAO vendedorDAO = new VendedoresDAO();
   
    @Override
    public Venda processa(String linha) {
        String[] partes = linha.split(";");
        try {
            LocalDate dataVenda = formatter.parseLocalDate(partes[0]);
            int quantidadeVendida = Integer.parseInt(partes[1]);
            //long numero = Long.parseLong(partes[2]);
            Produto produto = produtosDAO.buscarProdutoNoBanco(Long.parseLong(partes[2]));
            Vendedor vendedor = vendedorDAO.buscarVendedorNoBanco(Long.parseLong(partes[3]));
            return new Venda(dataVenda, quantidadeVendida, produto, vendedor);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao ler a linha de Vendas! " + linha + ": " + e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(ParserVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
