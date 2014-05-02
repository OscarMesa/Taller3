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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import navalcliente.Jugador;
import navalcliente.Mensaje;

public class Server {

    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private ObjectInputStream inStream = null;
    private boolean asignado = false;

    private HashMap<String, Jugador> jugadores;
    private ObjectOutputStream outputStream;

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

    private void asignarOponentes(String id) {
        List keys = new ArrayList(jugadores.keySet());
        Jugador j1, j2;
        jugadores.get(keys.get(0)).setOpenente(jugadores.get(keys.get(1)));
        jugadores.get(keys.get(1)).setOpenente(jugadores.get(keys.get(0)));
        
        jugadores.get(id).setMsn(navalcliente.Mensaje.TURNO);
        
        if(!jugadores.get(keys.get(0)).getIdjugador().equals(id) ){
            jugadores.get(keys.get(0)).setMsn(Mensaje.ESPERA_MOVIMIENTO_OPONENTE);
        }else{
            jugadores.get(keys.get(1)).setMsn(Mensaje.ESPERA_MOVIMIENTO_OPONENTE);
        }
    }

}
