/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria_cliente;

import co.com.poli.GUI.Tablero;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class HiloJugador extends Thread {

    private Jugador jugador;
    private Tablero tablero;
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inStream;

    public HiloJugador(Jugador jugador, Tablero tablero) {
        this.jugador = jugador;
        this.tablero = tablero;
    }

    public HiloJugador() {
    }

    public void run() {
        try {
            while (true) {
                //System.out.println(jugador.getMsn().getMsn());
                communicate();
                Thread.sleep(5000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clonarJugador(Jugador k) {
        for (Field campo : k.getClass().getDeclaredFields()) {
            campo.setAccessible(true);
            try {
                if (!campo.getName().equals("serialVersionUID")) {
                    Field c = jugador.getClass().getDeclaredField(campo.getName());
                    c.setAccessible(true);
                    c.set(jugador, campo.get(k));
                }
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void actualizarInterfaz()
    {
        if(jugador.getMsn() == Mensaje.TURNO)
        {
            tablero.HabilitarMatrizBotonesEnemiga();
        }
        
        tablero.actualizarMensaje();
    }
    
    public void communicate() throws InterruptedException {
        try {
            // isConnected = true;
            socket = new Socket("localHost", 4445);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(jugador);
            outputStream.flush();
            
            inStream = new ObjectInputStream(socket.getInputStream());
            Jugador j = (Jugador) inStream.readObject();
            clonarJugador(j);
            
            System.out.println(jugador.getMsn());
            Thread.sleep(1500);
            actualizarInterfaz();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HiloJugador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException se) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String... args)
    {
        Jugador k = new Jugador("oscar");
        for (Field campo : k.getClass().getDeclaredFields()) {
            campo.setAccessible(true);
            try {
                System.out.println(campo.get(k));
                campo.set(k, campo.get(k));
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(HiloJugador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(HiloJugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
