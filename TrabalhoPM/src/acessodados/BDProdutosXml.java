/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acessodados;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import negocio.Produto;

/**
 *
 * @author Felipe
 */
public class BDProdutosXml {
    
    private static final String NOME_ARQUIVO_XML_PRODUTOS = "PRODUTOS.XML";
    
    public void salvarProduto(Produto produto) {
        XMLEncoder encoder = null;
        try {            
            try {
                encoder = new XMLEncoder(new FileOutputStream(NOME_ARQUIVO_XML_PRODUTOS));
                encoder.writeObject(produto);
            } 
            finally {
                if (encoder != null)
                    encoder.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Produto lerProduto() {
        XMLDecoder decoder = null;
        Produto produto = new Produto();
        try {            
            try {
                decoder = new XMLDecoder(new FileInputStream(NOME_ARQUIVO_XML_PRODUTOS));
                produto = (Produto) decoder.readObject();
            } 
            finally {
                if (decoder != null)
                    decoder.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return produto;
    }
    
}
