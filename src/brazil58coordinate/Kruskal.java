/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brazil58coordinate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author 2015.1.08.026
 */
public class Kruskal {

    private double peso;
    private int edgesaux, num = 0;

    private ArrayList<Aresta> edges = null;
    private int pai[] = null;

    public Kruskal(Cities cities) {

        pai = new int[cities.getNumberOfCities()];
        for (int i = 0; i < cities.getNumberOfCities(); i++) {
            pai[i] = i;
        }

        edges = new ArrayList<>();
        for (int i = 0; i < cities.getNumberOfCities(); i++) {
            for (int j = 0; j < cities.getNumberOfCities(); j++) {
                edges.add(new Aresta(i, j, (cities.getAresta(i, j))));
            }
        }
    }

    public RespostaKruskalPrim krus(Cities cities) {
        Collections.sort(edges);

        RespostaKruskalPrim result = new RespostaKruskalPrim();

        while ((edgesaux < cities.getNumberOfCities() - 1 || num < cities.getNumberOfCities())) {

            if (find(edges.get(num).getOrigem()) != find(edges.get(num).getDestino())) {
                union(edges.get(num).getOrigem(), edges.get(num).getDestino());
                peso += edges.get(num).getDistance();

                edgesaux++;
            }
            num++;
        }
        for (int r = 0; r < cities.getNumberOfCities(); r++) {
            System.out.println(r + " -> " + pai[r]);
        }

        System.out.println(peso);
        result.peso = peso;
        result.resp = pai;
        return result;
    }

    public int find(int x) {
        if (pai[x] == x) {
            return x;
        }
        return find(pai[x]);
    }

    public void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        pai[fx] = fy;
    }

}
