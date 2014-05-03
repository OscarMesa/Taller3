/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.GUI;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.OR;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import memoria_cliente.Boton;
import memoria_cliente.HiloJugador;
import memoria_cliente.Jugador;
import memoria_cliente.Mensaje;

/**
 *
 * @author omesa
 */
public class Tablero extends javax.swing.JFrame {
    
    public static int numBotones = 4;
    public static int tamBarco = 4;
    private ArrayList<Boton> matrizBotonesEnemiga;
    private Mensaje mensajes;
    private Jugador jugador;
    private ArrayList<Boton> clicks;
    int[] img_v = new int[16];
    int[][] botones;

    /**
     * Creates new form Tablero
     */
    public Tablero() {
        botones = new int[numBotones + 1][numBotones + 1]; // 0 si no selecccionada 1 si es jugador 1 y 2 si es jugador 2
        initComponents();
        clicks = new ArrayList<>();
        matrizBotonesEnemiga = new ArrayList<>();
        llenarMatrizBotonesEnemiga();
        jLabel3.setText(mensajes.UBICAR_BARCO.getMsn());
        for (int i = 1; i <= numBotones; i++) {
            for (int j = 1; j <= numBotones; j++) {
                botones[i][j] = 0;
            }
        }
 
        // NavalCliente cliente = new NavalCliente();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 3, 0));
        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel1.setText("Memoriaza las imagenes");

        jLabel2.setText("Tablero");

        button1.setLabel("button1");

        button2.setLabel("button2");

        jButton1.setEnabled(false);
        jButton1.setLabel("Iniciar Partida");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("jLabel3");
        jLabel3.setName(""); // NOI18N

        jPanel1.setLayout(new java.awt.GridLayout(1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(38, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(314, 314, 314)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(106, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(77, 77, 77)))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jLabel3.setText(mensajes.ESPERA_SERVER.getMsn());
        jButton1.setEnabled(false);
        new HiloJugador(jugador,this).start();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }
    
    public boolean completo(){
        for (int i = 0 ; i < img_v.length ; i++) {
            if(img_v[i] == 0){
               return false;
            }
        }
        return true;
    }
    
    public int buscar_vacio(){
        int aletorio = 0;
        if(!completo()){
            aletorio = (int) Math.round((Math.random()*15));
            if(img_v[aletorio] != 0){
                aletorio = buscar_vacio();
            }
        }
        return aletorio;
    }
    
    public void llenarMatrizBotonesEnemiga() {
        jPanel1.setLayout(new GridLayout(numBotones, numBotones));
        int aletorio = 0; int position = 0;
        for (int n = 1 ; n < 9 ; n++) {
            aletorio = buscar_vacio();
            img_v[aletorio] = n;
            position = buscar_vacio();
            img_v[position] = n; 
        }

        
        int my_img=0;
        for (int i = 1; i <= numBotones; i++) {
            for (int j = 1; j <= numBotones; j++) {
                final JButton boton = new JButton("b" + i + "," + j);

                final Boton btnP = new Boton(boton, i, j);
                //boton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1.png")));
               
                btnP.setUrl(my_img);
               // boton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/"+img_v[my_img]+".png")));
                my_img++;
                
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnP.setHabilitado(false);
                        System.out.println("img"+btnP.getUrl());
                        btnP.getBtn().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/"+btnP.getUrl()+".png")));
                        //InHabilitarMatrizBotonesEnemiga();
                        jugador.setMsn(Mensaje.MOVIMIENTO_REALIZADO);
                        actualizarMensaje();
                        
                        if(clicks.size()==2)
                        {
                            System.out.println("entro.....");
                            validarClicks();
                            clicks = new ArrayList<>();
                        }else{
                                clicks.add(btnP);
                        }
                        
                    }

                    private void validarClicks() {
                        if(clicks.get(0).getUrl() == clicks.get(1).getUrl()){
                            botones[clicks.get(0).getFila()][clicks.get(0).getColumna()] = jugador.getIdjugador();
                            clicks.get(0).getBtn().setEnabled(false);
                            clicks.get(1).getBtn().setEnabled(false);
                        }else{
                            clicks.get(0).getBtn().setIcon(null);
                            clicks.get(1).getBtn().setIcon(null);
                        }
                            
                    }
                });
                matrizBotonesEnemiga.add(btnP);
                //boton.setEnabled(false);
                jPanel1.add(boton);
            }
        }
    }
    
    public void actualizarMensaje()
    {
        jLabel3.setText(jugador.getMsn().getMsn());
    }
    
    public Jugador getJugador() {
        return jugador;
    }
    
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
