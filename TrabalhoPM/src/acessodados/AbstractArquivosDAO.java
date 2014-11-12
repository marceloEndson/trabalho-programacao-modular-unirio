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

/**
 *
 * @author MCE
 */
public abstract class AbstractArquivosDAO<T> {

    public abstract Parser<T> getParser();

    public List<T> getObjetos(String nomeArquivo) {
        Parser<T> parser = getParser();
        return carregaArquivo(nomeArquivo, parser);
    }

    private List<T> carregaArquivo(String nomeArquivo, Parser<T> parser) {
        List<T> lista = new ArrayList<T>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            while ((linha = reader.readLine()) != null) {
                T objeto = parser.processa(linha);
                if (objeto != null) {   //TODO REMOVER ESSA VERIFICAÇÃO E O RETURN NULL
                    lista.add(objeto);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo " + e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e2) {
                System.out.println("Erro ao fechar o arquivo");
            }
        }
        return lista;
    }
}
