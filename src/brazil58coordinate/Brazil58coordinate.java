/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brazil58coordinate;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 2015.1.08.026
 */
public class Brazil58coordinate {

    public static void main(String[] args) throws IOException {
        String arquivo = "brazil58coordinates.tsp.txt";
        LeituraArquivo leitura = new LeituraArquivo();

        Cities cities = leitura.ler(arquivo);
//        RespostaKruskalPrim respprim = new RespostaKruskalPrim();
//        Prim prim = new Prim(cities);
//        respprim = prim.prim(cities);

        Cities cities2 = leitura.ler(arquivo);
        RespostaKruskalPrim respkrus = new RespostaKruskalPrim();
        Kruskal krus = new Kruskal(cities2);
        respkrus = krus.krus(cities2);
        
        List<Integer> resposta = new ArrayList<>();
        for (int i = 0; i < 58; i++) {
            resposta.add(respkrus.resp[i]);
        }
        
//        Plotar plot;
//        plot = new Plotar(resposta, cities.getMatrizcidade());
        
        krus.Desenha(resposta, cities.getMatrizcidade());
        
        List<Point2D.Double> citypoints = new ArrayList<Point2D.Double>();
        citypoints = cities.getCities();

    }
}
