/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.unirio.pm.model.Vendedor;
import br.edu.unirio.pm.resource.FabricaConexao;
import br.edu.unirio.pm.util.Parser;
import br.edu.unirio.pm.util.ParserVendedor;


/**
 * @author rogerio.silva
 *
 */
public class VendedoresDAO extends AbstractArquivosDAO<Vendedor>{
	    //Agora referenciado na Classe FabricadeConexoes
	    //private Connection conexao;
	    //private PreparedStatement comando;
	    private ResultSet resultado;
	    private final String INSERT = "insert into VENDEDOR (codigo, nome, categoria)"
	                                 + "values (?, ?, ?)";
	    private final String SELECT = "select * from VENDEDOR where codigo = ?";
	    private final String UPDATE_NOME_CATEGORIA = "update VENDEDOR set nome=?, " 
	    											+ "categoria=? where codigo = ?";

	    @Override
	    public Parser<Vendedor> getParser() {
	        return new ParserVendedor();  
	    }
	    
	    /**
	     * Retorna true caso tenha inserido, e false caso tenha atualizado.
	     * @param vendedor
	     * @return
	     * @throws SQLException
	     */
		public boolean inserirVendedor(Vendedor vendedor) throws SQLException {
			PreparedStatement comando = null;
			try {
				if (vendedorEstaNoBanco(vendedor.getCodigo())) {
					atualizarNomeVendedor(vendedor);
					return false;
				} else {
					FabricaConexao.iniciarConexao();
					comando = FabricaConexao.criarComando(INSERT);
					comando.setLong(1, vendedor.getCodigo());
					comando.setString(2, vendedor.getNome());
					comando.setInt(3, vendedor.getCategoria());
					comando.execute();
					return true;
				}
			} finally {
				FabricaConexao.fecharComando(comando);
				FabricaConexao.fecharConexao();
			}
		}
	    
		public boolean vendedorEstaNoBanco(long codigoVendedor) throws SQLException {
			PreparedStatement comando = null;
	
			try {
				FabricaConexao.iniciarConexao();
				comando = FabricaConexao.criarComando(SELECT);
				comando.setLong(1, codigoVendedor);
				resultado = comando.executeQuery();
				if (resultado.next()) {
					return true;
				}
				return false;
			}
	
			finally {
				FabricaConexao.fecharComando(comando);
				FabricaConexao.fecharConexao();
			}
	
		}
	    
	public void atualizarNomeVendedor(Vendedor vendedor) throws SQLException {
		PreparedStatement comando = null;

		try {
			FabricaConexao.iniciarConexao();
			comando = FabricaConexao.criarComando(UPDATE_NOME_CATEGORIA);
			comando.setString(1, vendedor.getNome());
			comando.setInt(2, vendedor.getCategoria());
			comando.setLong(3, vendedor.getCodigo());
			comando.execute();

		}

		finally {
			FabricaConexao.fecharComando(comando);
			FabricaConexao.fecharConexao();
		}

	}

}