/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brazil58coordinate;

import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author 2015.1.08.026
 */
public class Brazil58coordinate {
    
    public static void main(String[] args) throws IOException {
    String arquivo = "brazil58coordinates.tsp.txt";
    LeituraArquivo leitura = new LeituraArquivo();
    
    
//    Cities cities = leitura.ler(arquivo);
//    RespostaKruskalPrim respprim = new RespostaKruskalPrim();
//    Prim prim = new Prim(cities);
//    respprim = prim.prim(cities);
    
    Cities cities2 = leitura.ler(arquivo);
    RespostaKruskalPrim respkrus = new RespostaKruskalPrim();
    Kruskal krus = new Kruskal(cities2);
    respkrus = krus.krus(cities2);
    
//    JFrame frame = new JFrame();
//    frame.setSize(400,400);
//    frame.setTitle("Grafo");
//    
//    PointComponent visit = new PointComponent();
//    
//    frame.add(visit);
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.setVisible(true);
    
    }
}
