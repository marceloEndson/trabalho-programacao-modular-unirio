/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirio.pm.dao;

import br.edu.unirio.pm.model.Venda;
import br.edu.unirio.pm.resource.FabricaConexao;
import br.edu.unirio.pm.util.Parser;
import br.edu.unirio.pm.util.ParserVenda;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author MCE
 */
public class VendasDAO extends AbstractArquivosDAO<Venda> {
    
    private PreparedStatement comando;
    private final String INSERT = "insert into venda (data_venda, quantidade, cod_vendedor, cod_produto)"
            + "values (?, ?, ?, ?)";

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

}
