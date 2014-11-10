/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acessodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class ConexaoBancoDados  {
    
    public static Connection getConnection()throws SQLException{
        Connection conexao;
        try{
            try {
                Class.forName("org.h2.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            conexao = DriverManager.getConnection("jdbc:h2://localhost:8082/progmodular/progmodular", "sa", "");
        } catch(SQLException excecao){
            throw excecao;
        }        
        return conexao;
    }
    
    
}
