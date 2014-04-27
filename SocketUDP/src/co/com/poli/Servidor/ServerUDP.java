package co.com.poli.Servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class ServerUDP {

    private static final int PUERTO_SERVER = 12345;

    public static void main(String[] args) {

        DatagramSocket servidor;
        DatagramPacket entrada;
        DatagramPacket salida;

        byte[] datosEntrada;
        byte[] datosSalida;

        Scanner teclado = new Scanner(System.in);
        System.out.println("Iniciando Chat Servidor...");
        try {
            servidor = new DatagramSocket(PUERTO_SERVER);
            while (true) {

                datosEntrada = new byte[1024];
                entrada = new DatagramPacket(datosEntrada, datosEntrada.length);
                servidor.receive(entrada);
                String mensaje = new String(entrada.getData(), 0, entrada.getLength());
                System.out.println("Cliente >> " + mensaje);

                datosSalida = new byte[1026];
                datosSalida = teclado.nextLine().getBytes();
                InetAddress IP = entrada.getAddress();
                salida = new DatagramPacket(datosSalida, datosSalida.length, IP, entrada.getPort());
                servidor.send(salida);
            }

        } catch (SocketException ex) {
            Logger.getLogger(ServerUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerUDP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
