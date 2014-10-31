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
import negocio.Vendedor;

/**
 *
 * @author Rogerio Silva
 */
public class BDVendedoresXml {
    
    private static final String NOME_ARQUIVO_XML_VENDEDORES = "VENDEDORES.XML";
    
    public void salvarVendedor(Vendedor vendedor) {
        XMLEncoder encoder = null;
        try {            
            try {
                encoder = new XMLEncoder(new FileOutputStream(NOME_ARQUIVO_XML_VENDEDORES));
                encoder.writeObject(vendedor);
            } 
            finally {
                if (encoder != null)
                    encoder.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Vendedor lerVendedor() {
        XMLDecoder decoder = null;
        Vendedor vendedor = new Vendedor();
        try {            
            try {
                decoder = new XMLDecoder(new FileInputStream(NOME_ARQUIVO_XML_VENDEDORES));
                vendedor = (Vendedor) decoder.readObject();
            } 
            finally {
                if (decoder != null)
                    decoder.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return vendedor;
    }
    
}
