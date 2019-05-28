/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brazil58coordinate;

import java.io.IOException;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.awt.*;
import java.awt.geom.Point2D;

/**
 *
 * @author 2015.1.08.026
 */
public class LeituraArquivo {

    BufferedReader conteudoTXT = null;
    String linha = "";
    String separador = ",";
    Cities cities = null;

    public Cities ler(String arquivo) throws FileNotFoundException, IOException {

        //leitura arquivo
        conteudoTXT = new BufferedReader(new FileReader(arquivo));

        //guardar a quantidade de cidades a partir da primeira linha
        String[] aux = linha.split(separador);
        linha = conteudoTXT.readLine();
        int numberOfCities = Integer.parseInt(linha);
        cities = new Cities(numberOfCities);

        int COORDENADA_X = 0;
        int COORDENADA_Y = 1;
        while ((linha = conteudoTXT.readLine()) != null && !linha.contentEquals("")) {
            aux = linha.split(separador);
            Point2D.Double point2d = new Point2D.Double(Double.parseDouble(aux[COORDENADA_X]), Double.parseDouble(aux[COORDENADA_Y]));
            cities.add(point2d);
        }

        //Distance of City(Points)
        double[][] matrizcidade = new double[numberOfCities][numberOfCities];
        for (int i = 0; i < numberOfCities; i++) {
            for (int j = 0; j < numberOfCities; j++) {
                matrizcidade[i][j] = cities.getPoint(i).distance(cities.getPoint(j));
            }
            matrizcidade[i][i] = Double.POSITIVE_INFINITY;
        }
        cities.setMatrizcidade(matrizcidade);

        return cities;
    }
}

//public int contarLinhas(String endereco) throws FileNotFoundException, IOException {
//        LineNumberReader lineCounter = new LineNumberReader(new InputStreamReader(new FileInputStream(endereco)));
//        String nextLine = null;
//
//        try {
//            while ((nextLine = lineCounter.readLine()) != null) {
//                String[] aux = linha.split(separador);
//                if (nextLine == null) {
//                    break;
//                }
//                System.out.println(nextLine);
//            }
//            System.out.println("Total number of line in this file " + lineCounter.getLineNumber());
//        } catch (IOException done) {
//        }
//
//        return lineCounter.getLineNumber();
//    }
