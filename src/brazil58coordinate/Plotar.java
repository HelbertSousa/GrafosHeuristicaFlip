/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brazil58coordinate;

/**
 *
 * @author 2015.1.08.026
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.*;


public class  Plotar extends JPanel {

    private java.util.List<Integer> lista = new LinkedList<>();
    double matriz[][] = new double[58][58];
    
    
    
    public Plotar(java.util.List<Integer> resposta, double[][] matriz) {
        this.lista.addAll(resposta);
        this.matriz = matriz; 
        Graphics grafo = null;
        paintComponent();
    }

    public void paintComponent() {
        Graphics grafo = null;
        super.paintComponent(grafo);
        setBackground(Color.WHITE);
        Graphics2D g2d = (Graphics2D) grafo;

        int j = 1, i = 0;
        grafo.setColor(Color.GREEN); 
        grafo.fillOval((int) (this.matriz[this.lista.get(i)][0] * 5 - 5), (int) (this.matriz[this.lista.get(i)][1] * 5 - 5), 10, 10);
        
        for (i = 1; i < lista.size(); i++) { 
            grafo.setColor(Color.RED); 
            grafo.fillOval((int) (this.matriz[this.lista.get(i)][0] * 5 - 5), (int) (this.matriz[this.lista.get(i)][1] * 5 - 5), 10, 10);
        }
                
        
        for (i = 1; i < lista.size(); i++) { 
            grafo.setColor(Color.RED); 
            grafo.fillOval((int) (this.matriz[this.lista.get(i)][0] * 5 - 5), (int) (this.matriz[this.lista.get(i)][1] * 5 - 5), 10, 10);
        }
        for (i = 0; i < lista.size() && j < lista.size(); i++) {
            grafo.setColor(Color.blue); 
            grafo.drawLine((int) (this.matriz[this.lista.get(i)][0] * 5), (int) (this.matriz[this.lista.get(i)][1] * 5), (int) (this.matriz[lista.get(j)][0] * 5), (int) (this.matriz[this.lista.get(j)][1] * 5));
            			
            j++;
        }
        grafo.setColor(Color.YELLOW);
        grafo.fillOval((int) (this.matriz[this.lista.get(j - 1)][0] * 5 - 5), (int) (this.matriz[this.lista.get(j - 1)][1] * 5 - 5), 10, 10);
        grafo.setColor(Color.blue);
        grafo.drawLine((int) (this.matriz[this.lista.get(j - 1)][0] * 5), (int) (this.matriz[this.lista.get(j - 1)][1] * 5), (int) (this.matriz[this.lista.get(0)][0] * 5), (int) (this.matriz[this.lista.get(0)][1] * 5));
    
    }
}