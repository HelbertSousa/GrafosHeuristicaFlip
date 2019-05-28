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
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Principal extends javax.swing.JFrame {
    

    public Principal() {
        initComponents();
    }
    
//Inicializa Componentes
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        buttonForcabruta = new javax.swing.JButton();
        buttonVizinho = new javax.swing.JButton();
        buttonInsercaoproximo = new javax.swing.JButton();
        buttonInsercaodistante = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        JMenuBar Barra = new javax.swing.JMenuBar();
        JMenu Menu = new javax.swing.JMenu();
        JMenuItem Abrir = new javax.swing.JMenuItem();
        JMenuItem Sair = new javax.swing.JMenuItem();
        
        Menu.setText("File");        
        Abrir.setText("Abrir");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });
        Menu.add(Abrir);
        
        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        
        Menu.add(Sair);
        Barra.add(Menu);
        setJMenuBar(Barra);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TSP - Everton Giani Ribeiro");
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Parametros"));
        jLabel2.setText("Grafo");

        buttonInsercaodistante.setText("Insercao Mais distante");
        buttonInsercaodistante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	buttonVizinhoActionPerformed(evt);
            }
        });
        
        buttonInsercaoproximo.setText("Insercao Mais Próximo");
        buttonInsercaoproximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	buttonVizinhoActionPerformed(evt);
            }
        });
        
        buttonVizinho.setText("Vizinho Mais Próximo");
        buttonVizinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	buttonVizinhoActionPerformed(evt);
            }
        });

        buttonForcabruta.setText("Forca Bruta");
        buttonForcabruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonForcabrutaActionPerformed(evt);
            }
        });
        
        buttonSair.setText("Sair");
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });

       
        
        //Imprimir a matriz de adjacencia aqui
       
        //jScrollPane2.setViewportView(jTextArea2);

        jLabel3.setText("");
        
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonForcabruta)
                        .addGap(10, 10, 10)
                        .addComponent(buttonInsercaoproximo)
                        .addGap(10, 10, 10)
                        .addComponent(buttonInsercaodistante)
                        .addGap(10, 10, 10)
                        .addComponent(buttonVizinho)
                        .addGap(10, 10, 10)
                        .addComponent(buttonSair))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSair)
                    .addComponent(buttonInsercaodistante)
                    .addComponent(buttonInsercaoproximo)
                    .addComponent(buttonVizinho)
                    .addComponent(buttonForcabruta)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado "));
        jTextArea1.setColumns(40);
        jTextArea1.setRows(10);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pack();
    }
    
    private void SairActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {
    
    JFileChooser chooser = new JFileChooser();
    int returnVal = chooser.showOpenDialog(null);
    if(returnVal == JFileChooser.APPROVE_OPTION) {
       String arquivo = (chooser.getSelectedFile().getName());
       //Recebe o nome do arquivo selecionado
       String diretorio = ((chooser.getCurrentDirectory())+"\\"+arquivo);
       //Chama metodo da classe responsavel por leitura do arquivo
       //retorna um vetor de objetos do tipo vertice, cada qual contem um rotulo,coord x e coord y
       //vertices = file.read(diretorio);
       //Escreve nome do arquivo na interface
       jLabel3.setText("Instancia : "+arquivo);
       //Define o numero de vertices
       numVertices = vertices.length;
       
       }
 	
    }
    
    
    
    
    

    
    private void buttonInsercaoproximoActionPerformed(java.awt.event.ActionEvent evt) {
        
    	Date horaInicio = new Date();
        long horaInicioLong = horaInicio.getTime();

        //Codigo aqui
        
        
        
        //Mostra o tempo de execução
        Date horaFinal = new Date();
        long horaFinalLong = horaFinal.getTime();
        long tempoExecucaoMili = (horaFinalLong-horaInicioLong);
        Double tempoExecucaoSeg = tempoExecucaoMili/1000.0;

        jTextArea1.append("\n\nInício: " + horaInicio);
        jTextArea1.append("\nFinal: " + horaFinal);
        jTextArea1.append("\nTempo de execução: " + Double.toString(tempoExecucaoSeg) + " segundos (" + tempoExecucaoMili + " milisegundos)");
    	
    }

    private void buttonInsercaodistanteActionPerformed(java.awt.event.ActionEvent evt) {
    
    	Date horaInicio = new Date();
        long horaInicioLong = horaInicio.getTime();

        //Codigo aqui
        
        
        
        //Mostra o tempo de execução
        Date horaFinal = new Date();
        long horaFinalLong = horaFinal.getTime();
        long tempoExecucaoMili = (horaFinalLong-horaInicioLong);
        Double tempoExecucaoSeg = tempoExecucaoMili/1000.0;

        jTextArea1.append("\n\nInício: " + horaInicio);
        jTextArea1.append("\nFinal: " + horaFinal);
        jTextArea1.append("\nTempo de execução: " + Double.toString(tempoExecucaoSeg) + " segundos (" + tempoExecucaoMili + " milisegundos)");
    	
    }
    
    private void buttonVizinhoActionPerformed(java.awt.event.ActionEvent evt) {
        
    	Date horaInicio = new Date();
        long horaInicioLong = horaInicio.getTime();

        //Codigo aqui
        
        
        
        //Mostra o tempo de execução
        Date horaFinal = new Date();
        long horaFinalLong = horaFinal.getTime();
        long tempoExecucaoMili = (horaFinalLong-horaInicioLong);
        Double tempoExecucaoSeg = tempoExecucaoMili/1000.0;

        jTextArea1.append("\n\nInício: " + horaInicio);
        jTextArea1.append("\nFinal: " + horaFinal);
        jTextArea1.append("\nTempo de execução: " + Double.toString(tempoExecucaoSeg) + " segundos (" + tempoExecucaoMili + " milisegundos)");
    	
    }
    
    private void buttonForcabrutaActionPerformed(java.awt.event.ActionEvent evt) {
        int i,j;
        
        Date horaInicio = new Date();
        long horaInicioLong = horaInicio.getTime();

        //Codigo aqui
        
        
        
        //Mostra o tempo de execução
        Date horaFinal = new Date();
        long horaFinalLong = horaFinal.getTime();
        long tempoExecucaoMili = (horaFinalLong-horaInicioLong);
        Double tempoExecucaoSeg = tempoExecucaoMili/1000.0;

        jTextArea1.append("\n\nInício: " + horaInicio);
        jTextArea1.append("\nFinal: " + horaFinal);
        jTextArea1.append("\nTempo de execução: " + Double.toString(tempoExecucaoSeg) + " segundos (" + tempoExecucaoMili + " milisegundos)");
    }
    
    
    
    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    
 
    //Classe principal
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	
                new Principal().setVisible(true);
            }
        });
    }
    
    //Variaveis
    private javax.swing.JButton buttonForcabruta;
    private javax.swing.JButton buttonVizinho;
    private javax.swing.JButton buttonInsercaoproximo;
    private javax.swing.JButton buttonInsercaodistante;
    private javax.swing.JButton buttonSair;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    

    Vertice vertices [] = null;	//Vetor com os vertices lidos do arquivo
    int numVertices;            /* número de vértices do grafo */
    int min;                    /* usado para selecionar o menor ciclo */

    private static class Vertice {

        public Vertice() {
        }
    }
}