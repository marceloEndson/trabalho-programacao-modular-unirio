/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.unirio.pm.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unirio.pm.model.Vendedor;

/**
 *
 * @author Rogerio
 */
public class LerArquivoVendedoresTxt {
    
    public List<Vendedor> lerArquivoVendedor(String nomeArquivo) {
        BufferedReader reader = null;
        List<Vendedor> resultado = new ArrayList<>();
        try {            
            try {
                reader = new BufferedReader(new FileReader(nomeArquivo), 4096);
                String linha;
                while (reader.ready()) {
                    linha = reader.readLine();
                    if (processaLinhaVendedor(linha) != null)
                        resultado.add(processaLinhaVendedor(linha));  
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
    
    public Vendedor processaLinhaVendedor(String linha){
        String[] partes = linha.split(";");
        Vendedor vendedor = new Vendedor(Integer.parseInt(partes[0]), partes[1], Integer.parseInt(partes[2]));         
        return vendedor;
    }
    
}
