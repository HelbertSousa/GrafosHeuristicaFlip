/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brazil58;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

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
        int primeiracidade = cidade;
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
            valorCaminho += matrizcidade[cidade][guardaproximo];
            guardacaminho[cidade] = guardaproximo;
            cidade = guardaproximo;

        }
        //Finalizar o grafo da última cidade ligando-a a primeira.
        valorCaminho += matrizcidade[guardaproximo][primeiracidade];
    }

    public static long somaPercurso(ArrayList guardarcaminho) {
        int valorcaminho = 0;
        for (int i = 0; i < VizinhoMaisProximo.guardacaminho.length - 1; i++) {
            valorcaminho += VizinhoMaisProximo.matrizcidade[i][(int) guardarcaminho.get(i)];
        }
        //Somar ultimo vertice ligando ao primeiro
        valorcaminho += VizinhoMaisProximo.matrizcidade[(int) guardarcaminho.get(VizinhoMaisProximo.limite - 1)][(int) guardarcaminho.get(0)];
        return valorcaminho;
    }

    public static void flip(int inicio, int fim, ArrayList vetor) {
        while ((inicio < fim)) {
            Collections.swap(vetor, inicio, fim);
            inicio++;
            fim--;
        }
        System.out.println("limite" + limite);
        vetor.set(limite, vetor.get(0));
        System.out.println("lenght" + vetor.size());
    }

    public static void opt2(ArrayList<Integer> caminho) {
        long somaPercurso;

        for (int i = 1; i < limite % 2 + limite / 2; i++) {
            for (int j = 0; j < limite; j++) {
                List <Integer> caminhoatual = new ArrayList(caminho.size());
                
                somaPercurso = somaPercurso(caminho);
                if (VizinhoMaisProximo.valorCaminho < somaPercurso) {
                    Collections.swap(guardarcaminho, i, j);
                    cont++;
                } else if (somaPercurso > Integer.MAX_VALUE) {
                    melhorCaminho = somaPercurso;
                    System.out.println(melhorCaminho + " " + i + " " + j);
                    cont2++;
                }
            }

        }
    }

    public void printvet() {
        int parada = -1;
        int i = 0;
        while (parada++ < limite - 1) {
            System.out.print(guardacaminho[i] + " ");
            i = guardacaminho[i];
        }

        System.out.println("\n");
    }

    public void print() {
        for (int i : guardacaminho) {
            System.out.println(i + " --> " + guardacaminho[i]);
        }
    }

    public static String toGraphViz(int vetor[]) {

        StringBuilder s = new StringBuilder();
        String SL = System.getProperty("line.separator");
        s.append("graph G { graph [splines = true] node [height=0.4 shape=circle style=filled]").append(SL);
        for (int v = 0; v < vetor.length; v++) {
            s.append(v).append(" [ label= \"node = v").append(v).append("\" color = \"blue\"] ;").append(SL);
        }
        for (int v = 0; v < vetor.length; v++) {
            s.append(v).append(" -- ").append(vetor[v]).append(";").append(SL);
        }
        s.append("}");

        return s.toString();
    }
}
