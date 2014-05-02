/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navalcliente;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class HiloJugador extends Thread {

    private Jugador jugador;

    public HiloJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(jugador.getIdjugador());
                Thread.sleep(5000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
