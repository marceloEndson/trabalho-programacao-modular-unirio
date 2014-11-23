/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Felipe
 * @alter  Rogerio
 */
public class FabricaConexao  {
	
   private static Connection conexao;
   
    public Connection getConnection()throws SQLException{
        Connection conexao;
        try{
            try {
                Class.forName("org.h2.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Excecao dentro da classe ConexaoBancoDados");
                System.out.println(ex.getMessage());
            }
            conexao = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/programodular", "sa", "");
        } catch(SQLException excecao){
            System.out.println("Conexao nao estabelecida.");
            throw excecao;
        }        
        return conexao;
    }
    
    public static void iniciarConexao() throws SQLException{
    	if (conexao==null){
    		FabricaConexao fabricaConexao = new FabricaConexao();
    		conexao = fabricaConexao.getConnection();
    	}
    }

	public static void fecharConexao() throws SQLException {
		if (conexao != null) {
			conexao.close();
			conexao = null;
		}
	}
    
    public static Connection getConexao() throws SQLException {
    	if (conexao==null){
    		iniciarConexao();
    	}
		return conexao;
	}

	public static PreparedStatement criarComando(String comandoSQL) throws SQLException{
        return conexao.prepareStatement(comandoSQL);
    }
    
	public static void fecharComando(PreparedStatement comando)
			throws SQLException {
		if (comando != null) {
			comando.close();
		}
	}
    
}
