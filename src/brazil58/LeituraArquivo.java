/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brazil58;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 2015.1.08.026
 */
public class LeituraArquivo {

    BufferedReader conteudoTXT = null;
    String linha = "";
    String separador = " ";
    static int tamanho = 58;
    int[][] matrizcidade = null;

    public int[][] ler(String arquivo) throws FileNotFoundException, IOException {
        matrizcidade = new int[tamanho][tamanho];

        //leitura arquivo
        conteudoTXT = new BufferedReader(new FileReader(arquivo));

        //cidade
        int i, m;
        i = 0;
        m = 0;
        int teste = 0;
        while ((linha = conteudoTXT.readLine()) != null && !linha.contentEquals("")) {
            String[] aux = linha.split(separador);

            for (m = m; m < i; m++, teste++) {
                matrizcidade[i][m] = Integer.parseInt(aux[teste]);
                matrizcidade[m][i] = Integer.parseInt(aux[teste]);

            }
            for (m = i + 1; m < tamanho; m++, teste++) {
                matrizcidade[i][m] = Integer.parseInt(aux[teste]);
                matrizcidade[m][i] = Integer.parseInt(aux[teste]);
            }
            matrizcidade[i][i] = Integer.MAX_VALUE;
            i++;
            teste = 0;

        }
        return matrizcidade;
    }
        
    public void print() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print(matrizcidade[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
