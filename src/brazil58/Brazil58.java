/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brazil58;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author 2015.1.08.026
 */
public class Brazil58 {

    /**
     *
     * @param guardarcaminho
     * @return
     */
    public static long somaPercurso(ArrayList guardarcaminho) {
        int valorcaminho = 0;
        for (int i = 0; i < VizinhoMaisProximo.guardacaminho.length; i++) {
            valorcaminho += VizinhoMaisProximo.matrizcidade[i][(int) guardarcaminho.get(i)];
        }
        return valorcaminho;
    }

    public static void print(ArrayList caminho) {
        for (int i = 0; i < 58; i++) {
            System.out.print(caminho.get(i) + " ");
        }
        System.out.println("");
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

//        int[][] matriz = { 
//                {Integer.MAX_VALUE,3,5,48,48,8,8},
//                {3,Integer.MAX_VALUE,3,48,48,8,8},
//                {5,3,Integer.MAX_VALUE,72,72,48,48},
//                {48,48,72,Integer.MAX_VALUE,Integer.MAX_VALUE,6,6},
//                {48,48,72,Integer.MAX_VALUE,Integer.MAX_VALUE,6,6},
//                {8,8,48,6,6,Integer.MAX_VALUE,Integer.MAX_VALUE},
//                {8,8,48,6,6,Integer.MAX_VALUE,Integer.MAX_VALUE}
//        };
//        
//        DFS teste = new DFS(7, matriz);
//        teste.DFS_Visit(0,0);
//        teste.print();
        String arquivo = "brazil58.tsp.txt";

        LeituraArquivo ler = new LeituraArquivo();
        ler.ler(arquivo);
//        ler.print();

        VizinhoMaisProximo visit;
        visit = new VizinhoMaisProximo(arquivo);
        VizinhoMaisProximo.achaProximo(4);//Melhor caminho alcançado
//        System.out.println(VizinhoMaisProximo.toGraphViz(VizinhoMaisProximo.guardacaminho));

        ArrayList guardarcaminho = new ArrayList(VizinhoMaisProximo.guardacaminho.length);
        for (int i = 0; i < VizinhoMaisProximo.guardacaminho.length; i++) {
            guardarcaminho.add(VizinhoMaisProximo.guardacaminho[i]);
        }

        long rndd = 1;
        Random rnd = new Random(rndd);

//        for (int j = 0; j < 10; j++) {
//            for (int i = 0; i < VizinhoMaisProximo.limite; i++) {
//                Collections.shuffle(guardarcaminho, rnd);
//            }
//            print(guardarcaminho);
//            System.out.println(somaPercurso(guardarcaminho));
//            
//        }
        int cont = 0; int cont2 = 0;
        long somaPercurso;
        long melhorCaminho;
        melhorCaminho = (long) VizinhoMaisProximo.valorCaminho;

        for (int i = 0; i < VizinhoMaisProximo.limite; i++) {

            for (int j = 0; j < VizinhoMaisProximo.limite && i != j; j++) {

                Collections.swap(guardarcaminho, i, j);

                somaPercurso = somaPercurso(guardarcaminho);
                if (melhorCaminho < somaPercurso) {
                    Collections.swap(guardarcaminho, i, j);
                    cont++;
                } else if (somaPercurso > Integer.MAX_VALUE) {
                    melhorCaminho = somaPercurso;
                    System.out.println(melhorCaminho + " " + i + " " + j);
                    cont2++;
                }

            }
        }
        

        //       visit.printvet();
        //     visit.print();
        //       System.out.println("Valor do caminho encontrado: " + VizinhoMaisProximo.valorCaminho);
//       visit.printnormal(VizinhoMaisProximo.guardacaminho);
    }

}
