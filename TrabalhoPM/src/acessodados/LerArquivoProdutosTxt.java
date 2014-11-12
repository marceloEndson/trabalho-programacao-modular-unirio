/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acessodados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import negocio.Produto;

/**
 *
 * @author Felipe
 */
public class LerArquivoProdutosTxt {
    
    public List<Produto> carregarProdutos(String nomeArquivo) {
        BufferedReader reader = null;
        List<Produto> resultado = new ArrayList<>();
        try {            
            try {
                reader = new BufferedReader(new FileReader(nomeArquivo), 4096);
                String linha;
                while (reader.ready()) {
                    linha = reader.readLine();
                    if (processaLinhaProduto(linha) != null)
                        resultado.add(processaLinhaProduto(linha));  
                }
            } 
            finally {
                if (reader != null)
                    reader.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
        return resultado;
    }
    
    private Produto processaLinhaProduto(String linha){
        String[] partes = linha.split(";");
        try {
            long codigo = Long.parseLong(partes[0]);
            String nome = partes[1];
            return new Produto(codigo, nome);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
    
}
