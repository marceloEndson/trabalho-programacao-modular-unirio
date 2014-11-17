/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.unirio.pm.model.Vendedor;
import br.edu.unirio.pm.resource.FabricaConexao;
import br.edu.unirio.pm.util.Parser;
import br.edu.unirio.pm.util.ParserVendedor;

/**
 *
 * @author MCE 
 */
/**
 * @author rogerio.silva
 *
 */
public class VendedoresDAO extends AbstractArquivosDAO<Vendedor>{
	
	  private Connection conexao;
	    private PreparedStatement comando;
	    private ResultSet resultado;
	    private final String INSERT = "insert into VENDEDOR (codigo, nome, categoria)"
	                + "values (?, ?, ?)";
	    private final String SELECT = "select * from VENDEDOR where codigo = ?";
	    private final String UPDATE_NOME = "update VENDEDOR set nome = ? where codigo = ?";
	    private final String UPDATE_NOME_CATEGORIA = "update VENDEDOR set nome=?, "
	            + "categoria=? where codigo = ?";

	    @Override
	    public Parser<Vendedor> getParser() {
	        return new ParserVendedor();
	    }
	    
	    public void inserirVendedor(Vendedor vendedor) throws SQLException{
	        if (vendedorEstaNoBanco(vendedor.getCodigo())){
	            atualizarNomeVendedor(vendedor);
	        } else {
	            iniciarComando(INSERT);
	            comando.setLong(1, vendedor.getCodigo());
	            comando.setString(2, vendedor.getNome());
	            comando.execute();
	        }
	        fecharConexao();
	        fecharComando();       
	    }
	    
	    public void atualizarNomeVendedor(Vendedor vendedor) throws SQLException{
	        iniciarComando(UPDATE_NOME);
	        comando.setString(1, vendedor.getNome());
	        comando.setLong(2, vendedor.getCodigo());
	        comando.execute();
	    }
	    
	  /*  public void inserirDadosDePrecoNoProduto(Produto produto) throws SQLException{
	        if (vendedorEstaNoBanco(produto.getCodigo())){
	            iniciarComando(UPDATE_NOME_CATEGORIA);
	            comando.setDouble(1, produto.getPreco());
	            comando.setDate(2, Date.valueOf(produto.getInicioVigenciaPreco().toString()));
	            comando.setLong(3, produto.getCodigo());
	            comando.execute();
	            fecharComando();
	            fecharConexao();
	        }
	    }
	    */
	    public boolean vendedorEstaNoBanco(long codigoVendedor) throws SQLException {
	        iniciarConexao();
	        iniciarComando(SELECT);
	        comando.setLong(1, codigoVendedor);
	        resultado = comando.executeQuery();
	        while (resultado.next()){
	            return true;
	        }
	        return false;        
	    }
	    
	    public boolean produtoTemPrecoCadastrado(long codigoProduto){
	        return false;
	    }
	    
	    private void iniciarConexao() throws SQLException{
	        FabricaConexao fabricaConexao = new FabricaConexao();
	        conexao = fabricaConexao.getConnection();
	    }
	    
	    private void iniciarComando(String comandoSQL) throws SQLException{
	        comando = conexao.prepareStatement(comandoSQL);
	    }
	    
	    private void fecharComando() throws SQLException{
	        comando.close();
	    }
	    
	    private void fecharConexao() throws SQLException{
	        conexao.close();
	    }
	    
	    
	    
	}