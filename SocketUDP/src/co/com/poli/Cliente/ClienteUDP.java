package co.com.poli.Cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteUDP {

    private static final int PUERTO_SERVIDOR=12345;
   
    public static void main(String[] args) throws UnknownHostException {
        
        //InetAddress IP_Servidor = InetAddress.getLocalHost();
        InetAddress IP_Servidor = InetAddress.getByName("10.126.13.147");
            
        DatagramSocket cliente;
        DatagramPacket entrada;
        DatagramPacket salida;
        
        byte[] datosEntrada;
        byte[] datosSalida;
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Iniciando Chat Cliente...");
        while(true){
            try {
                cliente = new DatagramSocket();
                datosSalida = new byte[1024];
                datosSalida = teclado.nextLine().getBytes();
                salida = new DatagramPacket(datosSalida, datosSalida.length, IP_Servidor, PUERTO_SERVIDOR);
                cliente.send(salida);
                
                datosEntrada = new byte[1024];
                entrada = new DatagramPacket(datosEntrada, datosEntrada.length);
                cliente.receive(entrada);
                String mensaje = new String(entrada.getData(), 0, entrada.getLength());
                System.out.println("Servidor >>"+mensaje);
   
            } catch (SocketException ex) {
                Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
