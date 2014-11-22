/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.service;

import br.edu.unirio.pm.dao.VendedoresDAO;
import br.edu.unirio.pm.model.Vendedor;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Felipe
 */
public class TrabalhoPM {
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServicosComissoes svc = new ServicosComissoes();
        MesEscolhido mes = new MesEscolhido();
        VendedoresDAO dao = new VendedoresDAO();
        mes.setAno(2013);
        mes.setMes(6);
        Vendedor vendedor = new Vendedor();
        try {
            vendedor = dao.buscarVendedorNoBanco(20L);
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhoPM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Falha ao buscar vendedor.");
        }
        try {
            double comissao = svc.obterComissaoMensalPorVendedor(vendedor, mes);
            System.out.println(comissao);
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhoPM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Falha no calculo da comissao");
        }
        // Esta classe provavelmente será deletada.
    }

    
}
