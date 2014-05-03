/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria_cliente;

import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author omesa
 */

public class memoria_cliente implements Serializable{
    
    private static final int PUERTO_SERVIDOR=12345;
   
    
    /**
     * @param args the command line arguments
     */
    
    public memoria_cliente() {
        
        try
        {

            // La IP es la local, el puerto es en el que este cliente est�
            // escuchando.
            DatagramSocket socket = new DatagramSocket(
                    Constantes.PUERTO_DEL_CLIENTE, InetAddress
                            .getByName("localhost"));

            // Se instancia un DatoUdp y se convierte a bytes[]
            Jugador elDato = new Jugador(null);
            //byte[] elDatoEnBytes = elDato.serializarJugardor();
            
            byte[] elDatoEnBytes = null;
            
            // Se meten los bytes en el DatagramPacket, que es lo que se
            // va a enviar por el socket.
            // El destinatario es el servidor.
            // El puerto es por el que est escuchando el servidor.
            DatagramPacket dato = new DatagramPacket(elDatoEnBytes,
                    elDatoEnBytes.length, InetAddress
                            .getByName(Constantes.HOST_SERVIDOR),
                    Constantes.PUERTO_DEL_SERVIDOR);
             socket.send(dato);
            
            // Se env�a el DatagramPacket 10 veces, esperando 1 segundo entre
            // env�o y env�o.
//            for (int i = 0; i < 10; i++)
//            {
//                System.out.println("Envio dato " + i);
//                socket.send(dato);
//                Thread.sleep(1000);
//            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String... args){
        new memoria_cliente();
    }
}
