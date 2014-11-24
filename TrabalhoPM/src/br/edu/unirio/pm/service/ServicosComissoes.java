/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.service;

import br.edu.unirio.pm.dao.VendasDAO;
import br.edu.unirio.pm.model.Venda;
import br.edu.unirio.pm.model.Vendedor;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class ServicosComissoes {
    
    VendasDAO vendasDAO;

    public ServicosComissoes() {
        vendasDAO = new VendasDAO();
    }
    
    
    
    public double obterComissaoMensalPorVendedor(Vendedor vendedor, MesEscolhido mesEscolhido) throws SQLException{
        double totalVendaMensal = 0;
        double totalComissaoMes = 0;
        totalVendaMensal = obterTotalVendaMensalPorVendedor(vendedor, mesEscolhido);
        if (vendedor.getCategoria() == 1)
            totalComissaoMes = calcularComissaoVendedorCategoria1(totalVendaMensal);
        else if (vendedor.getCategoria() == 2)
            totalComissaoMes = calcularComissaoVendedorCategoria2(totalVendaMensal);
        return totalComissaoMes;
        
    }
    
	public double obterTotalVendaMensalPorVendedor(Vendedor vendedor, MesEscolhido mesEscolhido) throws SQLException {
		List<Venda> listaVendas = vendasDAO.obterVendasDoMes(mesEscolhido, vendedor);
		double totalVendaMensal = 0;
		for (Venda venda : listaVendas) {
			// if (vendaPertenceAoVendedor(venda, vendedor))
			totalVendaMensal += (venda.getQuantidadeVendida() * venda.getProduto().getPreco());
		}
		return totalVendaMensal;
	}
    
    private boolean vendaPertenceAoVendedor(Venda venda, Vendedor vendedor){
        if (venda.getVendedor().getCodigo() == vendedor.getCodigo())
            return true;
        return false;
    }
    
    private double calcularComissaoVendedorCategoria1(double totalVendaMensal){
        if (totalVendaMensal < 2000)
            return calcularComissaoVendedorCategoria1ComVendaMensalAbaixoDe2000(totalVendaMensal);
        else if (totalVendaMensal >= 2000)
            return calcularComissaoVendedorCategoria1ComVendaMensalAPartirDe2000(totalVendaMensal);
        return 0;
    }
    
    private double calcularComissaoVendedorCategoria1ComVendaMensalAbaixoDe2000(double totalVendaMensal){
        if (totalVendaMensal <= 1000)
            return totalVendaMensal * 0.1;
        else if (totalVendaMensal > 1000 && totalVendaMensal <= 1800)
            return totalVendaMensal * 0.15;
        else if (totalVendaMensal > 1800)
            return totalVendaMensal * 0.2;
        return 0;
    }
    
    private double calcularComissaoVendedorCategoria1ComVendaMensalAPartirDe2000(double totalVendaMensal){
        return 220 + ((totalVendaMensal - 1800) * 0.2);        
    }
    
    private double calcularComissaoVendedorCategoria2(double totalVendaMensal){
        if (totalVendaMensal <= 2000)
            return totalVendaMensal * 0.1;
        else if (totalVendaMensal <= 4000)
            return totalVendaMensal * 0.2;
        else if (totalVendaMensal > 4000)
            return totalVendaMensal * 0.3;
        return 0;
    }
    
    public double obterComissaoAcumuladaPorVendedor(MesEscolhido mesInicial, MesEscolhido mesFinal, Vendedor vendedor) throws SQLException{
        double comissaoAcumulada = 0;
        MesEscolhido mes = mesInicial;
        comissaoAcumulada = obterComissaoMensalPorVendedor(vendedor, mesInicial);
        while (!mes.equals(mesFinal)){
            mes.acrescentarUmMes();
            comissaoAcumulada += obterComissaoMensalPorVendedor(vendedor, mes);
        }
        return comissaoAcumulada;
    }
    
    public double obterVendaAcumuladaPorVendedor(MesEscolhido mesInicial, MesEscolhido mesFinal, Vendedor vendedor) throws SQLException{
        MesEscolhido mes = new MesEscolhido (mesInicial.getAno(), mesInicial.getMes());
        double vendaAcumuladaPorVendedor = 0;
        vendaAcumuladaPorVendedor += obterTotalVendaMensalPorVendedor(vendedor, mesInicial);
        while(!mes.equals(mesFinal)){
            mes.acrescentarUmMes();
            vendaAcumuladaPorVendedor += obterTotalVendaMensalPorVendedor(vendedor, mes);   
        }
        return vendaAcumuladaPorVendedor;
    }
    
    public double obterComissaoAcumuladaMediaPorVendedor(MesEscolhido mesInicial, MesEscolhido mesFinal, Vendedor vendedor) throws SQLException{
        double comissaoAcumuladaPorVendedor = obterComissaoAcumuladaPorVendedor(mesInicial, mesFinal, vendedor);
        int quantidadeMeses = 1;
        MesEscolhido mes = new MesEscolhido (mesInicial.getAno(), mesInicial.getMes());
        while (!mes.equals(mesFinal)){
            quantidadeMeses++;
            mes.acrescentarUmMes();
        }
        double media = comissaoAcumuladaPorVendedor / quantidadeMeses;
        return media;     
    }
    
    public double obterVendaAcumuladaMediaPorVendedor(MesEscolhido mesInicial, MesEscolhido mesFinal, Vendedor vendedor) throws SQLException{
        double vendaAcumuladaPorVendedor = obterVendaAcumuladaPorVendedor(mesInicial, mesFinal, vendedor);
        int quantidadeMeses = 1;
        MesEscolhido mes = new MesEscolhido (mesInicial.getAno(), mesInicial.getMes());
        System.out.println("mes inicial " + mesInicial.getAno() + " " + mesInicial.getMes());
        System.out.println("mes final " + mesFinal.getAno() + " " + mesFinal.getMes());
        while (!mes.equals(mesFinal)){
            quantidadeMeses++;
            mes.acrescentarUmMes();
        } 
        return (double) (vendaAcumuladaPorVendedor / quantidadeMeses); 
    }
    
}
