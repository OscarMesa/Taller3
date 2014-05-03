/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria_servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Memoria_servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memoria_servidor;

/**
 *
 * @author Administrador
 */
import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import memoria_cliente.Jugador;
import memoria_cliente.Mensaje;

public class Memoria_sevidor {

    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private ObjectInputStream inStream = null;
    private boolean asignado = false;

    private HashMap<String, Jugador> jugadores;
    private ObjectOutputStream outputStream;

    public Memoria_sevidor() {
        jugadores = new HashMap<>();
    }

    public void communicate() {
        try {
            serverSocket = new ServerSocket(4445);
            System.out.println("Connected");

            while (true) {
                socket = serverSocket.accept();
                inStream = new ObjectInputStream(socket.getInputStream());
                Jugador j = (Jugador) inStream.readObject();
                Jugador p = jugadores.get(j.getIdjugador().toString());
                if (p == null) {
                    System.out.println("No existe, agregado");
                    jugadores.put(j.getIdjugador().toString(), j);
                    if (jugadores.size() == 2 && !asignado) {
                        asignado = true;
                        asignarOponentes(j.getIdjugador());
                    }else{
                        jugadores.get(j.getIdjugador().toString()).setMsn(Mensaje.ESPERA_OPONENTE);
                    }
                } else {
                   System.out.println("ya existe");
                }
                System.out.println(j);
                outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(jugadores.get(j.getIdjugador().toString()));
            }
        } catch (SocketException se) {
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.communicate();
    }
}
