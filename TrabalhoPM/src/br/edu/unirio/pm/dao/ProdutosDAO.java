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

import br.edu.unirio.pm.model.Produto;
import br.edu.unirio.pm.resource.FabricaConexao;
import br.edu.unirio.pm.util.Parser;
import br.edu.unirio.pm.util.ParserProduto;

/**
 *
 * @author MCE
 */
public class ProdutosDAO extends AbstractArquivosDAO<Produto> {
    
    private Connection conexao;
    private PreparedStatement comando;
    private ResultSet resultado;
    private final String INSERT = "insert into produto (codigo, nome)"
                + "values (?, ?)";
    private final String SELECT = "select * from produto where codigo = ?";
    private final String UPDATE_NOME = "update produto set nome = ? where codigo = ?";
    private final String UPDATE_PRECO_VIGENCIA = "update produto set preco=?, "
            + "data_inicio_vigencia=? where codigo = ?";

    @Override
    public Parser<Produto> getParser() {
        return new ParserProduto();
    }
    
    public void inserirProduto(Produto produto) throws SQLException{
        if (produtoEstaNoBanco(produto.getCodigo())){
            atualizarNomeProduto(produto);
        } else {
            iniciarComando(INSERT);
            comando.setLong(1, produto.getCodigo());
            comando.setString(2, produto.getNome());
            comando.execute();
        }
        fecharConexao();
        fecharComando();       
    }
    
    public void atualizarNomeProduto(Produto produto) throws SQLException{
        iniciarComando(UPDATE_NOME);
        comando.setString(1, produto.getNome());
        comando.setLong(2, produto.getCodigo());
        comando.execute();
    }
    
    public void inserirDadosDePrecoNoProduto(Produto produto) throws SQLException{
        if (produtoEstaNoBanco(produto.getCodigo())){
            iniciarComando(UPDATE_PRECO_VIGENCIA);
            comando.setDouble(1, produto.getPreco());
            comando.setDate(2, Date.valueOf(produto.getInicioVigenciaPreco().toString()));
            comando.setLong(3, produto.getCodigo());
            comando.execute();
            fecharComando();
            fecharConexao();
        }
    }
    
    public boolean produtoEstaNoBanco(long codigoProduto) throws SQLException {
        iniciarConexao();
        iniciarComando(SELECT);
        comando.setLong(1, codigoProduto);
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
