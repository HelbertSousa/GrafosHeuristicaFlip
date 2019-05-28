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
        String arquivo = "pontos.agm1";
        LeituraArquivo leitura = new LeituraArquivo();

        Cities cities = leitura.ler(arquivo);
        RespostaKruskalPrim respprim = new RespostaKruskalPrim();
        Prim prim = new Prim(cities);
        respprim = prim.prim(cities);

        Cities cities2 = leitura.ler(arquivo);
        RespostaKruskalPrim respkrus = new RespostaKruskalPrim();
        Kruskal krus = new Kruskal(cities2);
        respkrus = krus.krus(cities2);
        
        List<Integer> resposta = new ArrayList<>();
        for (int i = 0; i < 58; i++) {
            resposta.add(i);
        }
        
        Plotar plot;
        plot = new Plotar(resposta, cities.getMatrizcidade());
        
        Frame myFrame = new Frame();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        myFrame.setSize(screenWidth / 2, screenHeight / 2);

        myFrame.setVisible(true);
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setTitle("Grafo");

        List<Point2D.Double> citypoints = new ArrayList<Point2D.Double>();
        citypoints = cities.getCities();
        

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}
