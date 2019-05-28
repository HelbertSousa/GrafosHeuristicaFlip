/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brazil58coordinate;

/**
 *
 * @author a15026
 */
public class Aresta implements Comparable<Aresta> {

    private int origem;
    private int destino;
    private double distancia;

    public Aresta(int origem, int destino) {
        this.origem = origem;
        this.destino = destino;
    }

    public Aresta(int origem, int destino, double distancia) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    public int getOrigem() {
        return this.origem;
    }

    public int getDestino() {
        return this.destino;
    }

    public double getDistance() {
        return this.distancia;
    }

    @Override
    public int compareTo(Aresta o) {
        if (this.distancia > o.distancia) {
            return 1;
        } else if (this.distancia < o.distancia) {
            return -1;
        } else {
            return 0;
        }
    }

}
