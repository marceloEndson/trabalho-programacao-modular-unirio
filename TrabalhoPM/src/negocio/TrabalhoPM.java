/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import acessodados.ConexaoBancoDados;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Felipe
 */
public class TrabalhoPM {
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection con = ConexaoBancoDados.getConnection();
            System.out.println("Conexao ok!");
        } catch (SQLException ex) {
            System.out.println("Conexao nao estabelecida!");
            System.out.println(ex.getMessage());
           
        }
    }

    
}
