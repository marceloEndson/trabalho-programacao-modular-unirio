/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.unirio.pm.model.Vendas;
import br.edu.unirio.pm.resource.FabricaConexao;
import br.edu.unirio.pm.util.Parser;
import br.edu.unirio.pm.util.ParserVendas;

/**
 *
 * @author Luiz Carlos
 * @alter  Rogerio Silva
 */

public class VendasDAO extends AbstractArquivosDAO<Vendas> {
    //Agora referenciado na Classe FabricadeConexoes
    //private Connection conexao;
    //private PreparedStatement comando;
    private ResultSet resultado;
    private final String INSERT = "insert into VENDAS (dataVenda, quantidade, codigoProduto,codigoVendedor)"
    							+ "values (?, ?, ?, ?)";
    private final String SELECT = "select * from VENDAS where cod_vendedor = ?";
    private final String UPDATE = "update VENDAS set dataVenda=?, quantidade=?, cod_produto=?, cod_vendedor=?  where cod_vendedor=?";
    

    @Override
    public Parser<Vendas> getParser() {
        return new ParserVendas();
    }

	public boolean inserirVendas(Vendas venda) throws SQLException {
		PreparedStatement comando = null;
		try {
			if (vendaEfetuadaPorVendedor(venda.getCodigoVendedor())) {
				atualizarVendas(venda);
				return false;
			} else {
				FabricaConexao.iniciarConexao();
				comando = FabricaConexao.criarComando(INSERT);
				comando.setLong(1, venda.getDataVenda());
				comando.setInt(2, venda.getQuantidade());
				comando.setLong(3, venda.getCodigoProduto());
				comando.setLong(4, venda.getCodigoVendedor());
				comando.execute();
				return true;
			}
		} finally {
			FabricaConexao.fecharComando(comando);
			FabricaConexao.fecharConexao();
		}
	}
    
    public void atualizarVendas(Vendas venda) throws SQLException{
		PreparedStatement comando = null;
		
		try {
		FabricaConexao.iniciarConexao();
		comando = FabricaConexao.criarComando (UPDATE);
		comando.setLong(1, venda.getDataVenda());
		comando.setInt(2, venda.getQuantidade());
		comando.setLong(3, venda.getCodigoProduto());
		comando.setLong(4, venda.getCodigoVendedor());
        comando.execute();
		}

		finally {
			FabricaConexao.fecharComando(comando);
			FabricaConexao.fecharConexao();
		}

	}
    /* Se tem uma venda, algum devedor realizou. Verifica��o para validar, mesmo nao sendo necess�rio.*/
	public boolean vendaEfetuadaPorVendedor(long codigoVendedor) throws SQLException {
		PreparedStatement comando = null;

		try {
			FabricaConexao.iniciarConexao();
			comando = FabricaConexao.criarComando(SELECT);
			comando.setLong(1, codigoVendedor);
			resultado = comando.executeQuery();
			while (resultado.next()) {
				return true;
			}
			return false;
		}

		finally {
			FabricaConexao.fecharComando(comando);
			FabricaConexao.fecharConexao();
		}

	}
    
     
}
