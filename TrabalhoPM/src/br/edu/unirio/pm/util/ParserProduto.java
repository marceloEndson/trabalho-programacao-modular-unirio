/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirio.pm.util;

import br.edu.unirio.pm.model.Produto;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author MCE
 */
public class ParserProduto implements Parser<Produto> {

    private final DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyy");
    private long codigo;
    private String nome;
    private LocalDate inicioVigenciaPreco;
    private double preco;

    @Override
    public Produto processa(String linha) {
        String[] partes = linha.split(";");

        if (partes.length == 2) {
            try {
                codigo = Long.parseLong(partes[0]);
                nome = partes[1];
                validaCodigo(codigo);
                return new Produto(codigo, nome);
            } catch (Exception e) {
                System.out.println("Erro ao processar linha de Produto" + e.getMessage());
            }
        } else {
            try {
                inicioVigenciaPreco = formatter.parseLocalDate(partes[0]);
                codigo = Long.parseLong(partes[1]);
                preco = Double.parseDouble(partes[2]);
                validaCodigo(codigo);
                validaPreco(preco);
                return new Produto(codigo, preco, inicioVigenciaPreco);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao processar linha de Produto" + e.getMessage());
            }
        }
        return null;
    }

    private void validaCodigo(long codigo) {
        if (codigo < 0) {
            throw new IllegalArgumentException("Código inválido!");
        }
    }

    private void validaPreco(double preco) {
        if(preco < 0.0){
            throw new IllegalArgumentException("Código inválido!");
        }
    }
}
