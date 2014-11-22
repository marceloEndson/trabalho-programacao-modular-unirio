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
    private final String INSERT = "insert into venda (data_venda, quantidade, cod_vendedor, cod_produto)"
            + "values (?, ?, ?, ?)";
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
        String consulta = "select * from venda where data_venda between ? and ?";
        ProdutosDAO produtosDAO = new ProdutosDAO();
        VendedoresDAO vendedoresDAO = new VendedoresDAO();
        FabricaConexao.iniciarConexao();
        comando = FabricaConexao.criarComando(consulta);
        LocalDate dataInicialDoMes = new LocalDate(mesEscolhido.getAno(), mesEscolhido.getMes(), 1);
        LocalDate dataFinalDoMes = new LocalDate(mesEscolhido.getAno(), mesEscolhido.getMes(), obterQuantidadeDeDiasDoMes(mesEscolhido));
        comando.setDate(1, Date.valueOf(dataInicialDoMes.toString()));
        comando.setDate(2, Date.valueOf(dataFinalDoMes.toString()));
        ResultSet resultado = comando.executeQuery();
        while (resultado.next()){
            Venda venda = new Venda();
            venda.setDataVenda(new LocalDate(resultado.getDate("DATA_VENDA")));
            venda.setProduto(produtosDAO.buscarProdutoNoBanco(resultado.getLong("COD_PRODUTO")));
            venda.setQuantidadeVendida(resultado.getInt("QUANTIDADE"));
            venda.setVendedor(vendedoresDAO.buscarVendedorNoBanco(resultado.getLong("COD_VENDEDOR")));
            listaVendasDoMes.add(venda);            
        }
        return listaVendasDoMes;
    }
    
    public int obterQuantidadeDeDiasDoMes(MesEscolhido mesEscolhido){
        if (mesEscolhido.getMes() == 2 && mesEscolhido.getAno() % 4 == 0) // Anos bissextos são múltiplos de 4.
            return 29;
        else if (mesEscolhido.getMes() == 2)
            return 28;
        else if (mesEscolhido.getMes() == 1 || mesEscolhido.getMes() == 3 ||
                mesEscolhido.getMes() == 5 || mesEscolhido.getMes() == 7 ||
                mesEscolhido.getMes() == 8 || mesEscolhido.getMes() == 10 ||
                mesEscolhido.getMes() == 12)
            return 31;
        return 30;
    }

}
