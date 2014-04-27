/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package navalservidor;

/**
 *
 * @author jgiraldo
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

class NavalServidor {

    private static final int PUERTO_SERVER = 12345;
    
    public static void main(String[] args) {

        DatagramSocket servidor;
        DatagramPacket entrada;
        DatagramPacket salida;

        byte[] datosEntrada;
        byte[] datosSalida;
        entrada = new DatagramPacket(new byte[100], 100);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Iniciando Chat Servidor...");
        
        try {
            servidor = new DatagramSocket(PUERTO_SERVER);
            while (true) {

                servidor.receive(entrada);

                System.out.print("Recibido dato de "
                        + entrada.getAddress().getHostName() + " : ");
                
                
                
            }

        } catch (SocketException ex) {
            Logger.getLogger(NavalServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NavalServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

