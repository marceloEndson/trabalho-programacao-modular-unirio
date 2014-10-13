/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class TrabalhoPM {
    
    private static final String NOME_ARQUIVO_PRODUTOS = "produtos.txt";
    private static final String NOME_ARQUIVO_PRECOS = "precos.txt";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcao;
        escreverMenu();
        opcao = lerOpcao();
        chamarOpcaoEscolhida(opcao);
    }

    private static void escreverMenu() {
        System.out.println("MENU");
        System.out.println("1 - Importar produtos");
        System.out.println("2 - Importar precos");
        System.out.println("Digite sua opcao: ");
    }
    
    private static int lerOpcao(){
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        return opcao;        
    }
    
    private static void chamarOpcaoEscolhida(int opcao){
        ServicosProduto servicosProduto = new ServicosProduto();
        if (opcao == 1)
            servicosProduto.importarProdutosDoArquivo(NOME_ARQUIVO_PRODUTOS);
        else if (opcao == 2)
            servicosProduto.importarPrecosDoArquivo(NOME_ARQUIVO_PRECOS);
        else
            System.out.println("Opcao invalida.");
    }
    
}
