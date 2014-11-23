/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.service;

import br.edu.unirio.pm.dao.VendasDAO;
import br.edu.unirio.pm.dao.VendedoresDAO;
import br.edu.unirio.pm.model.Venda;
import br.edu.unirio.pm.model.Vendedor;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.LocalDate;


/**
 *
 * @author Felipe
 */
public class TrabalhoPM {
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        ServicosComissoes svc = new ServicosComissoes();
        ServicosVendas svcVendas = new ServicosVendas();
        MesEscolhido mes = new MesEscolhido(2013, 5);
        MesEscolhido mesFinal = new MesEscolhido(2013, 7);
        VendedoresDAO dao = new VendedoresDAO();
        VendasDAO vendasDao = new VendasDAO();
        //mes.setAno(2013);
        //mes.setMes(7);
        Vendedor vendedor = new Vendedor();
        
        
        /*List<Venda> listaVendas = vendasDao.obterVendasDoMes(mes);
        for (Venda venda : listaVendas){
            System.out.println(venda.getDataVenda() + " " + venda.getProduto().getCodigo() + " " + venda.getVendedor().getNome());
        }*/
        
        try {
            vendedor = dao.buscarVendedorNoBanco(21L);
            System.out.println("busca de vendedor: " + vendedor.getNome());
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhoPM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Falha ao buscar vendedor.");
        }
        try {
            svc = new ServicosComissoes();
            svcVendas = new ServicosVendas();
            double comissao = svc.obterComissaoMensalPorVendedor(vendedor, mes);
            System.out.println("Comissao de um mes: " + comissao);
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhoPM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Falha no calculo da comissao");
        }
        try {
            svc = new ServicosComissoes();
            svcVendas = new ServicosVendas();
            double comissao = svc.obterComissaoAcumuladaPorVendedor(mes, mesFinal, vendedor);
            System.out.println("Comissao acumulada: " + comissao);
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhoPM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Falha no calculo da comissao acumulada");
        }
        try {
            svc = new ServicosComissoes();
            svcVendas = new ServicosVendas();
            double venda = svc.obterTotalVendaMensalPorVendedor(vendedor, mes);
            System.out.println("Venda mensal: " + venda);
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhoPM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Falha no calculo da venda");
        }
        try {
            svc = new ServicosComissoes();
            svcVendas = new ServicosVendas();
            MesEscolhido mes2 = new MesEscolhido(2013, 5);
            double venda = svc.obterVendaAcumuladaPorVendedor(mes2, mesFinal, vendedor);
            System.out.println("Venda acumulada: " + venda);
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhoPM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Falha no calculo da venda acumulada");
        }
        /*try {
            LocalDate date = vendasDao.obterDataDaVendaMaisAtual();
            LocalDate date2 = vendasDao.obterDataDaVendaMaisAntiga();
            System.out.println(date.getMonthOfYear() + " " + date2.getYear());
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhoPM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Falha ao obter a data mais atual");
        }
        try {
            List<Integer> lista = svcVendas.obterAnosDisponiveisParaConsulta();
            for (int i : lista){
                System.out.println(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhoPM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Falha ao obter lista de anos");
        }
        try {
            List<Vendedor> lista = dao.obterListaVendedores();
            System.out.println(lista.size());
            for (Vendedor v : lista){
                System.out.println(v.getNome());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhoPM.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Falha ao obter lista de vendedores");
        }*/
        
    }

    
}