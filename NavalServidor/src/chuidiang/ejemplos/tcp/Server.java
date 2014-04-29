/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuidiang.ejemplos.tcp;

/**
 *
 * @author Administrador
 */
import java.io.*;

import java.net.ServerSocket;

import java.net.Socket;

import java.net.SocketException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private ObjectInputStream inStream = null;
    
    private HashMap<String,Jugador> jugadores;
    
    public Server() {
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
                if(p == null)
                {
                    System.out.println("No existe, agregado");
                    jugadores.put(j.getIdjugador().toString(), j);
                    if(jugadores.size() == 2)
                    {
                        asignarOponentes();
                    }
                }else{
                    System.out.println("ya existe");
                }
                System.out.println(j);
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

    private void asignarOponentes() {
      
    }

}
