/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package navalcliente;

import co.com.poli.GUI.Tablero;
import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omesa
 */

public class NavalCliente implements Serializable{
    
    private static final int PUERTO_SERVIDOR=12345;
   
    
    /**
     * @param args the command line arguments
     */
    
    public NavalCliente() {
        try {
            //InetAddress IP_Servidor = InetAddress.getLocalHost();
            
            InetAddress IP_Servidor = null ;
            try {
                IP_Servidor = InetAddress.getByName("192.168.0.16");
            } catch (UnknownHostException ex) {
                Logger.getLogger(NavalCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            DatagramSocket cliente;
            DatagramPacket entrada;
            DatagramPacket salida;
            
            byte[] datosEntrada;
            byte[] datosSalida;
            
            
            Jugador jugador = new Jugador();
            
            cliente = new DatagramSocket();
            byte[] j = jugador.serializarJugardor();
            salida = new DatagramPacket(j, j.length, IP_Servidor, PUERTO_SERVIDOR);
            try {
                cliente.send(salida);
            } catch (IOException ex) {
                Logger.getLogger(NavalCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Iniciando Cliente...");
            /*while(true){
                try {
                    cliente = new DatagramSocket();
                    datosSalida = new byte[1024];
                    salida = new DatagramPacket(datosSalida, datosSalida.length, IP_Servidor, PUERTO_SERVIDOR);
                    cliente.send(salida);
                    
                    datosEntrada = new byte[1024];
                    entrada = new DatagramPacket(datosEntrada, datosEntrada.length);
                    cliente.receive(entrada);
                    String mensaje = new String(entrada.getData(), 0, entrada.getLength());
                    System.out.println("Servidor >>"+mensaje);
       
                } catch (SocketException ex) {
                    Logger.getLogger(NavalCliente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(NavalCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
        } catch (SocketException ex) {
            Logger.getLogger(NavalCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
