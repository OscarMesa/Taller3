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
import chuidiang.ejemplos.Constantes;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import navalcliente.Jugador;

/**
 * Servidor de udp que se pone a la escucha de DatagramPacket que contengan
 * dentro DatoUdp y los escribe en pantalla.
 * 
 * @author Chuidiang
 */
public class NavalServidor
{

    public NavalServidor()
    {
        try
        {

            // La IP es la local, el puerto es en el que el servidor est� 
            // escuchando.
            DatagramSocket socket = new DatagramSocket(
                    Constantes.PUERTO_DEL_SERVIDOR, InetAddress
                            .getByName("localhost"));

            // Un DatagramPacket para recibir los mensajes.
            DatagramPacket dato = new DatagramPacket(new byte[100], 100);

            // Bucle infinito.
            while (true)
            {
                // Se recibe un dato y se escribe en pantalla.
                socket.receive(dato);
                System.out.print("Recibido dato de "
                        + dato.getAddress().getHostName() + " : ");
                
                // Conversion de los bytes a DatoUdp
                Jugador j = Jugador.derializarJugador(dato.getData());
                System.out.println(j.getIdjugador());
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    
   public static void main(String... args){
        new NavalServidor();
    }
}
