/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brazil58;

/**
 *
 * @author 2015.1.08.026
 */
public class DFS {
    static int[][] cidades = null;
    static boolean[] visitado = null;
    static int[] caminhoatual = null;
    static int[] guardamelhorcaminho = null;
    static int min = Integer.MAX_VALUE;
    static int nivel = 0;
    static int tamcidade;
            
    public DFS(int tam, int[][] aux) {
        cidades = new int[tam][tam];
        tamcidade = tam;
        visitado = new boolean[tam];
        caminhoatual = new int[tam];
        guardamelhorcaminho = new int[tam];
        cidades = aux;
    }
    
    public static int pontosCiclo(int[] aux){
        int total;
        total = 0;
        for (int i = 0; i < tamcidade - 1; i++) {
            total += cidades[aux[i]][aux[i+1]];          
        }
        total += cidades[aux[tamcidade-1]][aux[0]];
        
        return total;
    }
    
    
    public static void DFS_Visit(int vertice, int nivelAux){
        int dist;
        visitado[vertice] = true;
        caminhoatual[nivelAux] = vertice;
        if (nivelAux == tamcidade - 1){
            dist = pontosCiclo(caminhoatual);
            if(dist < min){
                min = dist;
                System.arraycopy(caminhoatual, 0, guardamelhorcaminho, 0, tamcidade);
            }
        }
        for (int i = 0; i < tamcidade; i++) {
            if(!visitado[i]){
                DFS_Visit(i, nivelAux + 1);
                visitado[i] = false;
            }
        }
    }
    public static void print (){
        for(int i=0;i<tamcidade;i++)
            System.out.println(guardamelhorcaminho[i]);
    }
}
