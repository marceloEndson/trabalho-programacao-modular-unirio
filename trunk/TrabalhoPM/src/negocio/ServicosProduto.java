/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import acessodados.BDProdutosXml;
import acessodados.LerArquivoProdutosTxt;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Felipe
 */
public class ServicosProduto {
    
    private LerArquivoProdutosTxt lerArquivoProdutosTxt;
    private BDProdutosXml bdProdutosXml;    
    private Map<Integer, Produto> mapaCodigoProduto;

    public ServicosProduto() {
        lerArquivoProdutosTxt = new LerArquivoProdutosTxt();
        bdProdutosXml = new BDProdutosXml();
        mapaCodigoProduto = new HashMap<>();
    }
    
    
    
    public void importarProdutosDoArquivo(String nomeArquivoTxt){
        // TODO
    }
    
    public void importarPrecosDoArquivo(String nomeArquivoTxt){
        // TODO
    }
    
    public void salvarProdutoNoXml(Produto produto){
        // TODO
    }
    
    public void recuperarProdutoNoXml(){
        // TODO
    }
    
    public void atualizarPrecosDosProdutos(){
        // TODO
    }
}