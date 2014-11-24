/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirio.pm.util;

import br.edu.unirio.pm.model.Vendedor;

/**
 *
 * @author MCE
 */
public class ParserVendedor implements Parser<Vendedor> {

    private long codigo;
    private String nome;
    int categoria;

    @Override
    public Vendedor processa(String linha) {
        try {
            String[] partes = linha.split(";");
            //  long codigo = Long.parseLong(partes[0], 8); // O 8 é indica o sistema numérico em que a string será convertida, neste caso OCTAL. O DEFAULT é DECIMAL.
            codigo = Long.parseLong(partes[0]);
            nome = partes[1];
            categoria = Integer.parseInt(partes[2]);
            validaVendedor(codigo, categoria);
            return new Vendedor(codigo, nome, categoria);
        } catch (Exception e) {
            System.out.println("Erro ao ler a linha de Vendedor! " + linha + ": " + e.getMessage());
        }
        return null;
    }

    private void validaVendedor(long codigo, int categoria) {
        validaCodigo(codigo);
        validaCategoria(categoria);
    }

    private void validaCodigo(long codigo) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("Código inválido");
        }
    }

    private void validaCategoria(int categoria) {
        if (categoria != 1 && categoria != 2) {
            throw new IllegalArgumentException("Categoria inválida");
        }
    }
}
