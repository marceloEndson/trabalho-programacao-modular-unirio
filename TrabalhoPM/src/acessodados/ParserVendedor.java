/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acessodados;

import negocio.Vendedor;

/**
 *
 * @author MCE
 */
class ParserVendedor implements Parser<Vendedor> {

    @Override
    public Vendedor processa(String linha) {
           try {
            String[] partes = linha.split(";");
            long codigo = Long.parseLong(partes[0], 8); // O 8 é indica o sistema numérico em que a string será convertida, neste caso OCTAL. O DEFAULT é DECIMAL.
            String nome = partes[1];
            int categoria =  Integer.parseInt(partes[2]);
            if(validaVendedor(codigo, categoria)){
                return new Vendedor(codigo, nome, categoria);
            }            
        } catch (IllegalArgumentException e) {
               System.out.println("Erro ao processar linha de Pendedor ");
        }
        return null;
    }

    private boolean validaVendedor(long codigo, int categoria) {
        return codigo > 0 && (categoria == 1 || categoria == 2);
    }
}
