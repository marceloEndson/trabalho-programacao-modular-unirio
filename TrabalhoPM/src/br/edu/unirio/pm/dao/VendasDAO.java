/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirio.pm.dao;

import br.edu.unirio.pm.model.Venda;
import br.edu.unirio.pm.resource.FabricaConexao;
import br.edu.unirio.pm.service.MesEscolhido;
import br.edu.unirio.pm.util.Parser;
import br.edu.unirio.pm.util.ParserVenda;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;

/**
 *
 * @author MCE
 */
public class VendasDAO extends AbstractArquivosDAO<Venda> {
    
    private PreparedStatement comando;
    private String consulta;
    private ResultSet resultado;
    private final String INSERT = "insert into venda (data_venda, quantidade, cod_vendedor, cod_produto)"
            + "values (?, ?, ?, ?)";
    private final String SELECT_MES_ESPECIFICO = "select * from venda where data_venda between ? and ?";
    private final String SELECT_MAX_DATA = "select max (data_venda) from venda";
    private final String SELECT_MIN_DATA = "select min (data_venda) from venda";
    private List<Venda> listaVendasDoMes = new ArrayList<>();

    @Override
    public Parser<Venda> getParser() {
        return new ParserVenda();
    }
    
    public boolean inserirVenda(Venda venda) throws SQLException {
	try {
		FabricaConexao.iniciarConexao();
		comando = FabricaConexao.criarComando(INSERT);
		comando.setDate(1, Date.valueOf(venda.getDataVenda().toString()));
                comando.setInt(2, venda.getQuantidadeVendida());
                comando.setLong(3, venda.getVendedor().getCodigo());
                comando.setLong(4, venda.getProduto().getCodigo());
		comando.execute();
                return true;
	} finally {
		FabricaConexao.fecharComando(comando);
		FabricaConexao.fecharConexao();
	}
    }
    
    public List<Venda> obterVendasDoMes(MesEscolhido mesEscolhido) throws SQLException{
        comando = null;
        try{
            consulta = SELECT_MES_ESPECIFICO;
            ProdutosDAO produtosDAO = new ProdutosDAO();
            VendedoresDAO vendedoresDAO = new VendedoresDAO();
            FabricaConexao.iniciarConexao();
            comando = FabricaConexao.criarComando(consulta);
            LocalDate dataInicialDoMes = new LocalDate(mesEscolhido.getAno(), mesEscolhido.getMes(), 1);
            LocalDate dataFinalDoMes = new LocalDate(mesEscolhido.getAno(), mesEscolhido.getMes(), mesEscolhido.obterQuantidadeDeDiasDoMes());
            comando.setDate(1, Date.valueOf(dataInicialDoMes.toString()));
            comando.setDate(2, Date.valueOf(dataFinalDoMes.toString()));
            resultado = comando.executeQuery();
        while (resultado.next()){
            Venda venda = new Venda();
            venda.setDataVenda(new LocalDate(resultado.getDate("DATA_VENDA")));
            venda.setProduto(produtosDAO.buscarProdutoNoBanco(resultado.getLong("COD_PRODUTO")));
            venda.setQuantidadeVendida(resultado.getInt("QUANTIDADE"));
            venda.setVendedor(vendedoresDAO.buscarVendedorNoBanco(resultado.getLong("COD_VENDEDOR")));
            listaVendasDoMes.add(venda);            
        }
        return listaVendasDoMes;
        } finally {
		FabricaConexao.fecharComando(comando);
		FabricaConexao.fecharConexao();
	}  
    }
    
    public LocalDate obterDataDaVendaMaisAtual() throws SQLException{
        try{
            consulta = SELECT_MAX_DATA;
            LocalDate dataVendaMaisAtual = LocalDate.now();
            FabricaConexao.iniciarConexao();
            comando = FabricaConexao.criarComando(consulta);
            resultado = comando.executeQuery();
            while(resultado.next())
                dataVendaMaisAtual = new LocalDate(resultado.getDate(1));
            return dataVendaMaisAtual;
        } finally {
		FabricaConexao.fecharComando(comando);
		FabricaConexao.fecharConexao();
	}        
    }
    
    public LocalDate obterDataDaVendaMaisAntiga() throws SQLException{
        try{
            consulta = SELECT_MIN_DATA;
            LocalDate dataVendaMaisAntiga = LocalDate.now();
            FabricaConexao.iniciarConexao();
            comando = FabricaConexao.criarComando(consulta);
            resultado = comando.executeQuery();
            while(resultado.next())
                dataVendaMaisAntiga = new LocalDate (resultado.getDate(1));
            return dataVendaMaisAntiga;
        } finally {
		FabricaConexao.fecharComando(comando);
		FabricaConexao.fecharConexao();
	}        
    }

}
