/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navalcliente;

import co.com.poli.GUI.Tablero;
import java.io.Serializable;
import java.util.UUID;

public class Jugador implements Serializable {

    private static final long serialVersionUID = 5950169519310163575L;

    private String name;
    private String idjugador;
    private Mensaje msn;
    private Jugador openente;
    private Boton[][] MiTablero;//Este tablero va a tener 0 en todas las posiciones inicialmente donde tenga un 1 es por que ya fue un punto en la matriz que fue tomada por el oponente, donde tenga 2 es por que es una posicion del barco y donde tenga 3 es por que era una osicion del barco que fue tomada por el oponente.
    private Boton[][] TableroEnemigo;
    private Boton[] barco;

    public Jugador(String name) {
        this.name = name;
        idjugador = UUID.randomUUID().toString();
        msn = Mensaje.ESPERA_SERVER;
        MiTablero = new Boton[Tablero.numBotones + 1][Tablero.numBotones + 1];
        TableroEnemigo = new Boton[Tablero.numBotones + 1][Tablero.numBotones + 1];
        barco = new Boton[Tablero.numBotones + 1];
    }
    /**
     * Este metodo actualiza el estado del boton va a tener 0 en todas las posiciones inicialmente donde tenga un 1 es por que ya fue un punto en la matriz que fue tomada por el oponente, donde tenga 2 es por que es una posicion del barco y donde tenga 3 es por que era una osicion del barco que fue tomada por el oponente
     * @param i
     * @param j
     * @param dato 
     */
    public void setPosicionTablero(int i, int j, int dato) {
        MiTablero[i][j].setEstado(dato);
    }
    
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Jugador student = (Jugador) o;

        if (name != null ? !name.equals(student.name) : student.name != null) {
            return false;
        }

        return true;

    }

    public String getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(String idjugador) {
        this.idjugador = idjugador;
    }

    public void asignarPosicionTablero(int i, int j) {
        switch (MiTablero[i][j].getEstado()) {
            case 0:
                MiTablero[i][j].setEstado(1);
                break;
            case 2:
                MiTablero[i][j].setEstado(3);
                break;
            default:
                System.out.println("Esa posicion ya fue tomada.");
                break;
        }
    }

    public boolean esGanador() {
        for (Boton b : barco) {
            if (MiTablero[b.getFila()][b.getColumna()].getEstado() == 3) {
            } else {
                return false;
            }
        }
        return true;
    }

    public Mensaje getMsn() {
        return msn;
    }

    public void setMsn(Mensaje msn) {
        this.msn = msn;
    }

    public Jugador getOpenente() {
        return openente;
    }

    public void setOpenente(Jugador openente) {
        this.openente = openente;
    }

    public Boton[][] getMiTablero() {
        return MiTablero;
    }

    public void setMiTablero(Boton[][] MiTablero) {
        this.MiTablero = MiTablero;
    }

    public Boton[][] getTableroEnemigo() {
        return TableroEnemigo;
    }

    public void setTableroEnemigo(Boton[][] TableroEnemigo) {
        this.TableroEnemigo = TableroEnemigo;
    }

    public Boton[] getBarco() {
        return barco;
    }

    public void setBarco(Boton[] barco) {
        this.barco = barco;
    }

    
}

