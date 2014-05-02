/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navalcliente;

import co.com.poli.GUI.Tablero;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    private Socket socket = null;

    private ObjectInputStream inputStream = null;

    private ObjectOutputStream outputStream = null;

    private boolean isConnected = false;
    
    private Jugador jugador;

    public Client() {
        jugador = new Jugador("sape");
        Tablero t = new Tablero();
        t.setJugador(jugador);
        t.setVisible(true);
    }

    public static void main(String[] args) {

        Client client = new Client();

    }

}
