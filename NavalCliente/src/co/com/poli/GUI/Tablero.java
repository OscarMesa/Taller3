/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import navalcliente.HiloJugador;
import navalcliente.Jugador;
import navalcliente.Mensaje;

/**
 *
 * @author omesa
 */
public class Tablero extends javax.swing.JFrame {
    
    public static int numBotones = 5;
    public static int tamBarco = 4;
    private ArrayList<Boton> matrizBotones, matrizBotonesEnemiga;
    private Boton[][] matrizBotopesFC, matrizBotopesFCEnemiga;
    private ArrayList<JButton> barco;
    private Mensaje mensajes;
    private boolean barcoActivo;
    private boolean canToPlay;
    private Jugador jugador;
    
    {
        canToPlay = false;
        barcoActivo = false;
    }

    /**
     * Creates new form Tablero
     */
    public Tablero() {
        initComponents();
        matrizBotones = new ArrayList<>();
        matrizBotonesEnemiga = new ArrayList<>();
        matrizBotopesFC = new Boton[numBotones + 1][numBotones + 1];
        matrizBotopesFCEnemiga = new Boton[numBotones + 1][numBotones + 1];
        barco = new ArrayList<>();
        llenarMatrizBotones();
        llenarMatrizBotonesEnemiga();
        jLabel3.setText(mensajes.UBICAR_BARCO.getMsn());

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
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 3, 0));
        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel1.setText("Batalla Naval");

        jLabel2.setText("Mi tablero");

        button1.setLabel("button1");

        button2.setLabel("button2");

        jPanel1.setLayout(new java.awt.GridLayout(1, 20));

        jButton1.setEnabled(false);
        jButton1.setLabel("Iniciar Partida");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("jLabel3");
        jLabel3.setName(""); // NOI18N

        jPanel2.setLayout(new java.awt.GridLayout(1, 20));

        jLabel4.setText("Tablero enemigo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(203, 203, 203)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(503, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(106, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    
    public void HabilitarMatrizBotonesEnemiga() {
        for (int i = 1; i <= numBotones; i++) {
            for (int j = 1; j <= numBotones; j++) {
                if (matrizBotopesFCEnemiga[i][j].isHabilitado()) {
                    matrizBotopesFCEnemiga[i][j].getBtn().setEnabled(true);
                } else {
                    matrizBotopesFCEnemiga[i][j].getBtn().setEnabled(false);
                }
            }
        }
    }
    
    public void InHabilitarMatrizBotonesEnemiga() {
        for (int i = 1; i <= numBotones; i++) {
            for (int j = 1; j <= numBotones; j++) {
                matrizBotopesFCEnemiga[i][j].getBtn().setEnabled(false);
            }
        }
    }
    
    public void llenarMatrizBotonesEnemiga() {
        jPanel1.setLayout(new GridLayout(numBotones, numBotones));
        for (int i = 1; i <= numBotones; i++) {
            for (int j = 1; j <= numBotones; j++) {
                final JButton boton = new JButton("b" + i + "," + j);
                final Boton btnP = new Boton(boton, i, j);
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnP.setHabilitado(false);
                        InHabilitarMatrizBotonesEnemiga();
                        jugador.setMsn(Mensaje.MOVIMIENTO_REALIZADO);
                        actualizarMensaje();
                    }
                });
                matrizBotonesEnemiga.add(btnP);
                matrizBotopesFCEnemiga[i][j] = btnP;
                boton.setEnabled(false);
                jPanel1.add(boton);
            }
        }
    }
    
    public void actualizarMensaje()
    {
        jLabel3.setText(jugador.getMsn().getMsn());
    }
    
    public void llenarMatrizBotones() {
        jPanel2.setLayout(new GridLayout(numBotones, numBotones));
        
        for (int i = 1; i <= numBotones; i++) {
            for (int j = 1; j <= numBotones; j++) {
                final JButton boton = new JButton("b" + i + "," + j);
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int columna = (matrizBotones.get(Integer.parseInt(boton.getName())).getColumna());
                        int fila = (matrizBotones.get(Integer.parseInt(boton.getName())).getFila());
                        if (!barcoActivo) {
                            int minimum = 1, maximum = 4;
                            boolean sw = true, s1 = true, s3 = true, s2 = true, s4 = true;
                            int control = 0;
                            while (sw) {
                                int op = minimum + (int) (Math.random() * maximum);
                                switch (op) {
                                    case 1:
                                        if (fila - tamBarco >= 0) {
                                            sw = false;
                                            pintarBarco1(fila, columna);
                                        } else {
                                            s1 = false;
                                        }
                                        break;
                                    case 2:
                                        if ((numBotones - columna + 1) >= tamBarco) {
                                            sw = false;
                                            pintarBarco2(fila, columna);
                                        } else {
                                            s2 = false;
                                        }
                                        break;
                                    case 3:
                                        if ((numBotones - fila + 1) >= tamBarco) {
                                            sw = false;
                                            pintarBarco3(fila, columna);
                                        } else {
                                            s3 = false;
                                        }
                                        break;
                                    case 4:
                                        if (columna - tamBarco >= 0) {
                                            sw = false;
                                            pintarBarco4(fila, columna);
                                            
                                        } else {
                                            s4 = false;
                                        }
                                        break;
                                }
                                if (!s1 && !s2 && !s3 && !s4) {
                                    JOptionPane.showMessageDialog(rootPane, mensajes.ERROR_POSICION_BARCO.getMsn(), "Error", JOptionPane.ERROR_MESSAGE);
                                    break;
                                }
                            }
                            if (!sw) {
                                barcoActivo = true;
                                jButton1.setEnabled(true);
                                jLabel3.setText(mensajes.INICIAR_PARTIDA.getMsn());
                                InabilitarMatrizBotones();
                            }
                        } else {
                            InabilitarMatrizBotones();
                        }
                    }
                });
//                boton.addPropertyChangeListener(new PropertyChangeListener() {
//                        public void propertyChange(PropertyChangeEvent evt) {
//                            if (evt.getPropertyName().equals("enabled")) {
//                                JComponent component = (JComponent) evt.getSource();
//                                boolean enabled = component.isEnabled();
//                                component.setBackground(enabled ? Color.red: Color.blue);
//                            }
//                        }
//                    });
                Boton btnP = new Boton(boton, i, j);
                matrizBotones.add(btnP);
                matrizBotopesFC[i][j] = btnP;
                boton.setName(String.valueOf(matrizBotones.size() - 1));
                jPanel2.add(boton);
            }
        }
    }
    
    public void InabilitarMatrizBotones() {
        for (int i = 1; i <= numBotones; i++) {
            for (int j = 1; j <= numBotones; j++) {
                if (barco.contains(matrizBotopesFC[i][j].getBtn())) {
                    matrizBotopesFC[i][j].getBtn().setBorder(null);
                    matrizBotopesFC[i][j].getBtn().setText("<html><body bgcolor=\"#E6E6FA\"><font color=red>" + matrizBotopesFC[i][j].getBtn().getText() + "</font></html>");;
                }
                matrizBotopesFC[i][j].getBtn().setEnabled(false);
            }
        }
        
    }

    public void HabilitarMatrizBotones() {
        for (int i = 1; i <= numBotones; i++) {
            for (int j = 1; j <= numBotones; j++) {
                if (barco.contains(matrizBotopesFC[i][j].getBtn())) {
                    matrizBotopesFC[i][j].getBtn().setEnabled(false);
                } else {
                    matrizBotopesFC[i][j].getBtn().setEnabled(true);
                }
            }
        }
    }
    
    public void pintarBarco1(int fila, int columna) {
        int cont = 0;
        for (int i = fila; cont < tamBarco; i--) {
            barco.add(matrizBotopesFC[i][columna].getBtn());
            cont++;
        }
    }
    
    public void pintarBarco2(int fila, int columna) {
        int cont = 0;
        for (int j = columna; cont < tamBarco; j++) {
            matrizBotopesFC[fila][j].getBtn().setBackground(Color.BLUE);
            barco.add(matrizBotopesFC[fila][j].getBtn());
            cont++;
        }
    }
    
    public void pintarBarco3(int fila, int columna) {
        int cont = 0;
        for (int i = fila; cont < tamBarco; i++) {
            matrizBotopesFC[i][columna].getBtn().setBackground(Color.BLUE);
            barco.add(matrizBotopesFC[i][columna].getBtn());
            cont++;
        }
    }
    
    public void pintarBarco4(int fila, int columna) {
        int cont = 0;
        for (int j = columna; cont < tamBarco; j--) {
            matrizBotopesFC[fila][j].getBtn().setBackground(Color.BLUE);
            barco.add(matrizBotopesFC[fila][j].getBtn());
            cont++;
        }
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}

class Boton implements Comparable<Boton>, Comparator<Boton> {
    
    private JButton btn;
    private int fila;
    private int columna;
    private boolean habilitado;
    
    public Boton() {
    }
    
    public Boton(JButton btn, int fila, int columna) {
        this.btn = btn;
        this.fila = fila;
        this.columna = columna;
        habilitado = true;
    }
    
    public boolean isHabilitado() {
        return habilitado;
    }    
    
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    public JButton getBtn() {
        return btn;
    }
    
    public void setBtn(JButton btn) {
        this.btn = btn;
    }
    
    public int getFila() {
        return fila;
    }
    
    public void setFila(int fila) {
        this.fila = fila;
    }
    
    public int getColumna() {
        return columna;
    }
    
    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    @Override
    public int compareTo(Boton o) {
        if (this.getColumna() == o.getColumna() && this.getFila() == o.getFila()) {
            return 2;
        } else {
            return (this.getFila());
        }
    }
    
    @Override
    public int compare(Boton o1, Boton o2) {
        return o1.equals(o2) ? 1 : 0;
    }
    
}
