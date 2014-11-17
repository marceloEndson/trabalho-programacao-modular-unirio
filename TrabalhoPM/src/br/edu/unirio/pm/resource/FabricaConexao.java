/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Felipe
 */
public class FabricaConexao  {
    
    public Connection getConnection()throws SQLException{
        Connection conexao;
        try{
            try {
                Class.forName("org.h2.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Excecao dentro da classe ConexaoBancoDados");
                System.out.println(ex.getMessage());
            }
            conexao = DriverManager.getConnection("jdbc:h2:~/progmodular/progmodular", "sa", "");
            System.out.println("Conexao estabelecida.");
        } catch(SQLException excecao){
            System.out.println("Conexao nao estabelecida.");
            throw excecao;
        }        
        return conexao;
    }
    
    
}
