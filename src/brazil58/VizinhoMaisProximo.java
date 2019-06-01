/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brazil58;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author 2015.1.08.026
 */
public class VizinhoMaisProximo {

    static int[][] matrizcidade = null;
    static int limite;
    static int[] guardacaminho = null;
    static boolean[] visit = null;
    static LeituraArquivo ler = new LeituraArquivo();
    static long valorCaminho = 0;
    static int primeiracidade, ultimacidade;

    public VizinhoMaisProximo(String arquivo) throws IOException {

        matrizcidade = ler.ler(arquivo);
        VizinhoMaisProximo.limite = matrizcidade.length;
        guardacaminho = new int[limite];
        visit = new boolean[limite];
    }

    public static int achaMenorCidade(int cidadeAtual) {
        long aux = Long.MAX_VALUE;
        int proximaCidade = 0;
        visit[cidadeAtual] = true;
        for (int i = 0; i < matrizcidade.length; i++) {
            if (aux > matrizcidade[cidadeAtual][i] && cidadeAtual != i && !visit[i]) {
                aux = matrizcidade[cidadeAtual][i];
                proximaCidade = i;
            }
        }
        visit[proximaCidade] = true;

        return proximaCidade;
    }

    public static int[] achaProximo(int cidade) {
        primeiracidade = cidade;
        int cont = 0;
        visit[cidade] = true;
        while (cont++ < matrizcidade.length) {
            int auxcidade = achaMenorCidade(cidade);
            guardacaminho[cidade] = auxcidade;
            if (cont == 58) {
                ultimacidade = cidade;
            }
            cidade = auxcidade;
        }
        //Finalizar o grafo da última cidade ligando-a a primeira. 
        guardacaminho[ultimacidade] = primeiracidade;
        valorCaminho += somaPercurso(guardacaminho);
        //guardacaminho[ultimacidade] = primeiracidade;
        return guardacaminho;
    }

    public static long somaPercurso(ArrayList<Integer> guardarcaminho) {
        long valorcaminhoaux = 0;
        for (int i = 0; i < guardarcaminho.size(); i++) {
            valorcaminhoaux += VizinhoMaisProximo.matrizcidade[i][(int) guardarcaminho.get(i)];
        }

        return valorcaminhoaux;
    }

    public static long somaPercurso(int[] guardarcaminho) {
        long valorcaminhoaux = 0;
        for (int i = 0; i < guardarcaminho.length; i++) {
            valorcaminhoaux += VizinhoMaisProximo.matrizcidade[i][guardarcaminho[i]];
        }
        return valorcaminhoaux;
    }

    public static ArrayList<Integer> swap(ArrayList<Integer> vetor, int a, int b, int c, int d) {
        Collections.swap(vetor, b, c);
        return vetor;
    }

    public static ArrayList<Integer> flip(ArrayList<Integer> vetor, int inicio, int fim) {
        while ((inicio++ < fim--)) {
            Collections.swap(vetor, inicio, fim);
        }
        return vetor;
    }

    public static ArrayList<Integer> flip2(ArrayList<Integer> aux, int inicio, int fim) {
        ArrayList<Integer> dados = new ArrayList<>();

        for (int i = 0; i < inicio; i++) {
            dados.add(aux.get(i));
        }
        int reverse = 0;
        for (int j = 0; j <= fim - inicio; j++) {
            dados.add(aux.get(fim - reverse));
            reverse++;
        }
        for (int i = fim; i < aux.size() - 1; i++) {
            dados.add(aux.get(i));
        }

        return dados;
    }

    //   opt2 a partir dos materias do ziviane
//    public static void opt2(ArrayList<Integer> vetor) {
//        boolean fim = false;
//        int k, ia, a, b, pa, nb, ib;
//        while (!fim) {
//            fim = true;
//            for (k = 1; k <= ((vetor.size() % 2) + (vetor.size() / 2)); k++) {
//                for (ia = 0; ia < vetor.size(); ia++) {
//                    ib = (ia + k) % vetor.size();
//                    a = vetor.get(ia);
//                    b = vetor.get(ib);
//                    pa = vetor.get(( ia == 0 ) ? vetor.size() - 1 : ia - 1);
//                    nb = vetor.get(( ib == (vetor.size() - 1)) ? 0 : ib + 1);
//                    if((matrizcidade[pa][b]+matrizcidade[a][nb]) < (matrizcidade[pa][a]+matrizcidade[b][nb]))
//                    {
//                        flip(vetor, ia, ib);
//                        fim = false;
//                    }
//                }
//            }
//        }
//    }
    public static ArrayList<Integer> opt2(ArrayList<Integer> vetor) {
        ArrayList<Integer> novocaminho = new ArrayList<>();
        for (int k = 0; k < vetor.size(); k++) {
            novocaminho.add(vetor.get(k));
        }

        long melhorDistancia = somaPercurso(vetor);
        int test = 1; // condição de parada quando não existir modificações que surtam efeito positivo.
        while (test != 0) {
            test = 0;
            for (int i = 1; i < vetor.size() - 2; i++) {
                for (int j = i + 1; j < vetor.size() - 2; j++) {
                    // distance line A,B + line C,D against A,C + B,D 
                    if ((matrizcidade[i][vetor.get(i - 1)] + matrizcidade[j + 1][vetor.get(j)])
                            >= matrizcidade[i][vetor.get(j + 1)] + matrizcidade[i + 1][vetor.get(j)]) {
//                        System.out.println("soma 1: "+ (matrizcidade[i][vetor.get(i - 1)] + matrizcidade[j + 1][vetor.get(j)]));
//                        System.out.println("soma 2: "+ (matrizcidade[i][vetor.get(j + 1)] + matrizcidade[i - 1][vetor.get(j)]));

                        //novocaminho = flip2(vetor, i, j); //erro em flip 2.
                        novocaminho = flip(novocaminho, i, j);
                        //novocaminho = swap(vetor, i - 1, j + 1, j + 1, i + 1);

                        long novaDistancia = somaPercurso(novocaminho);
                        if ((novaDistancia < melhorDistancia) && (novaDistancia > 0)) {
                            //System.out.println("novaDistancia" + novaDistancia + "melhorDistancia: "+ melhorDistancia);
                            melhorDistancia = novaDistancia;
                            test++;
                            for (int k = 0; k < novocaminho.size(); k++) {
                                vetor.set(k, novocaminho.get(k));
                            }
                        }
                    }
                }
            }
        }
        return vetor;
    }

    public static ArrayList<Integer> opt3(ArrayList<Integer> caminho) {
        ArrayList<Integer> caminhoencontrado = new ArrayList();
        ArrayList<Integer> caminhoantigo = new ArrayList<>();
        long melhorcaminho = somaPercurso(caminho);
        long somaPercurso;

        for (int k = 0; k < caminho.size(); k++) {
            caminhoantigo.add(caminho.get(k));
            caminhoencontrado.add(0);
        }

        for (int i = 1; i < caminho.size() % 2 + caminho.size() / 2; i++) {
            for (int j = 0; j < caminho.size(); j++) {
                for (int k = 0; k < caminho.size(); k++) {
                    caminhoantigo.set(k, caminho.get(k));
                }
                flip(caminhoantigo, j, (j + 1) % caminho.size());

                caminhoantigo = opt2(caminhoantigo);

                somaPercurso = somaPercurso(caminhoantigo);
                if ((somaPercurso < melhorcaminho) && (somaPercurso > 0)) {

                    melhorcaminho = somaPercurso;

                    for (int k = 0; k < caminho.size(); k++) {
                        caminhoencontrado.set(k, caminhoantigo.get(k));
                    }
                }
            }
        }
        return caminhoencontrado;
    }

    public static void printvet() {
        int parada = -1;
        int i = 0;
        while (parada++ < limite - 1) {
            System.out.print(guardacaminho[i] + " ");
            i = guardacaminho[i];
        }

        System.out.println("\n");
    }

    public static void printvet(ArrayList<Integer> aux) {
        int parada = -1;
        int i = 0;
        while (parada++ < aux.size() - 1) {
            System.out.print(aux.get(i) + " ");
            i = aux.get(i);
        }

        System.out.println("\n");
    }

    public static void print() {
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
