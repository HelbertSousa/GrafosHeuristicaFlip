/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brazil58coordinate;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author 2015.1.08.026
 */
public class Prim {

    private Queue<Aresta> filaprioridade;
    private double[] key;
    private int[] predecessor;
    private boolean[] visit;
    private List<Aresta> resp;
    private double peso;
    static Aresta auxaresta = null;

    public Prim(Cities cities) {
        filaprioridade = new PriorityQueue<>();
        for (int i = 0; i < cities.getNumberOfCities(); i++) {
            for (int j = 0; j < cities.getNumberOfCities(); j++) {
                filaprioridade.offer(new Aresta(i, j, cities.getAresta(i, j)));
            }
        }
        key = new double[cities.getNumberOfCities()];
        visit = new boolean[cities.getNumberOfCities()];
        predecessor = new int[cities.getNumberOfCities()];
        for (int u = 0; u < cities.getNumberOfCities(); u++) {
            key[u] = Double.MAX_VALUE;
            visit[u] = false;
        }
        resp = new LinkedList<>();
    }

    public RespostaKruskalPrim prim(Cities cities) {
        RespostaKruskalPrim result = new RespostaKruskalPrim();
        key[0] = 0;
        predecessor[0] = 0;

        while (!filaprioridade.isEmpty()) {
            auxaresta = filaprioridade.remove();
            resp.add(auxaresta);
            int u = auxaresta.getOrigem();
            filaprioridade.remove();

            for (Integer v : cities.getAdjacent(u)) {
                if (!visit[u]
                        && cities.getAresta(u, v) < key[v]) { //Encontra menor peso/distancia
                    key[v] = cities.getAresta(u, v);
                    filaprioridade.add(cities.getInstanciaAresta(u, v));
                    predecessor[v] = u;

                }
                visit[v] = true;
            }
        }
        
        for (int i = 0; i < key.length; i++) {
            peso += key[i];
        }
        
//        for (int i = 0; i < predecessor.length; i++) {
//            System.out.println("n = " + predecessor[i]);
//        }
        
        System.out.println(peso);
        result.peso = peso;
        result.resp = predecessor;

        return result;
    }
}
