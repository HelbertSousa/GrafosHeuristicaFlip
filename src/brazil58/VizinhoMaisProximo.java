/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brazil58;

import java.io.IOException;
import java.math.BigInteger;

/**
 *
 * @author 2015.1.08.026
 */
public class VizinhoMaisProximo {

    static int cont = -1;
    static int[][] matrizcidade = null;
    static int aux = Integer.MAX_VALUE;
    static int limite;
    static int[] guardacaminho = null;
    static boolean[] visit = null;
    static LeituraArquivo ler = new LeituraArquivo();
    static int valorCaminho = 0;

    public VizinhoMaisProximo(String arquivo) throws IOException {

        matrizcidade = ler.ler(arquivo);
        VizinhoMaisProximo.limite = matrizcidade.length;
        guardacaminho = new int[limite];
        visit = new boolean[limite];
    }

    public static void achaProximo(int cidade) {
        int guardaproximo = 0;
        while (!(cont++ == limite - 2)) {
            aux = Integer.MAX_VALUE;
            visit[cidade] = true;
            for (int aresta = 0; aresta < limite; aresta++) {
                if (aux > matrizcidade[cidade][aresta]) {
                    if (!visit[aresta]) {
                        aux = matrizcidade[cidade][aresta];
                        guardaproximo = aresta;
                    }
                }
            }
            visit[guardaproximo] = true;
            valorCaminho += matrizcidade[cidade][guardaproximo];
            guardacaminho[cidade] = guardaproximo;
            cidade = guardaproximo;
        }
    }

    public void printvet() {
        for (int i = 0; i < limite; i++) {
            System.out.print(guardacaminho[i] + " ");
        }
        System.out.println("");
    }
}
