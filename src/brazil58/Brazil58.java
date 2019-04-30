/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brazil58;

import java.io.IOException;
import static java.util.Arrays.sort;
import java.util.Iterator;

/**
 *
 * @author 2015.1.08.026
 */
public class Brazil58 {

    /**
     * @param args the command line arguments
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
        ler.print();

        VizinhoMaisProximo visit;
        visit = new VizinhoMaisProximo(arquivo);
        VizinhoMaisProximo.achaProximo(0);
        sort(VizinhoMaisProximo.guardacaminho);
        visit.printvet();
        System.out.println("Valor do Caminho pelo Vizinho mais Próximo: " + VizinhoMaisProximo.valorCaminho);
    }

}
