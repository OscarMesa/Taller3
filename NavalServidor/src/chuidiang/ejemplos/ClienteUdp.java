
package chuidiang.ejemplos;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUdp
{

    /**
     * Programa de prueba. Instancia esta clase
     * @param args
     */
    public static void main(String[] args)
    {
        new ClienteUdp();
    }

  
    public ClienteUdp()
    {
        try
        {

            // La IP es la local, el puerto es en el que este cliente est�
            // escuchando.
            DatagramSocket socket = new DatagramSocket(
                    Constantes.PUERTO_DEL_CLIENTE, InetAddress
                            .getByName("localhost"));

            // Se instancia un DatoUdp y se convierte a bytes[]
            DatoUdp elDato = new DatoUdp("hola");
            byte[] elDatoEnBytes = elDato.toByteArray();

            // Se meten los bytes en el DatagramPacket, que es lo que se
            // va a enviar por el socket.
            // El destinatario es el servidor.
            // El puerto es por el que est escuchando el servidor.
            DatagramPacket dato = new DatagramPacket(elDatoEnBytes,
                    elDatoEnBytes.length, InetAddress
                            .getByName(Constantes.HOST_SERVIDOR),
                    Constantes.PUERTO_DEL_SERVIDOR);
            
            // Se enva el DatagramPacket 10 veces, esperando 1 segundo entre
            // envo y env.
            for (int i = 0; i < 10; i++)
            {
                System.out.println("Envio dato " + i);
                socket.send(dato);
                Thread.sleep(1000);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
