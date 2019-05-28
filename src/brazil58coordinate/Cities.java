/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brazil58coordinate;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2015.1.08.026
 */
public class Cities {

    private List<Point2D.Double> cities;
    Point2D.Double city = null;
    private double[][] matrizcidade = null;
    private final int numberOfCities;

    Cities(int numberOfCities) {
        this.cities = new ArrayList<>();
        this.matrizcidade = new double[numberOfCities][numberOfCities];
        this.numberOfCities = numberOfCities;
    }

    public void setMatrizcidade(double[][] matriz) {
        for (int i = 0; i < this.numberOfCities; i++) {
            System.arraycopy(matriz[i], 0, this.matrizcidade[i], 0, this.numberOfCities);
        }
    }

    public Double getDistanceCities(int i, int j) {
        return matrizcidade[i][j];
    }

    public List<Point2D.Double> getCities() {
        return cities;
    }

    public Point2D.Double getPoint(int indice) {
        return cities.get(indice);
    }

    public void setCities(List<Point2D.Double> cities) {
        this.cities = cities;
    }

    public void add(Point2D.Double point) {
        cities.add(point);
    }

    public List<Integer> getAdjacent(int cityStart) {
        List<Integer> adjacents = new ArrayList<>();
        for (int destination = 0; destination < this.numberOfCities; destination++) {
            if (Double.compare(Double.POSITIVE_INFINITY, this.matrizcidade[cityStart][destination]) != 0) {
                adjacents.add(destination);
            }
        }
        return adjacents;
    }
    public double getAresta(int i, int j){
        return matrizcidade[i][j];
    }

    public int getNumberOfCities() {
        return numberOfCities;
    }
    
    public Aresta getInstanciaAresta(int origem, int destino) {
        Aresta aresta = new Aresta(origem,destino);
        return aresta;
    }
    
   
    
}
