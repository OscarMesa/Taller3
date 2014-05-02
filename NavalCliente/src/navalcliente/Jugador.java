/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navalcliente;

import co.com.poli.GUI.Tablero;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Jugador implements Serializable {

    private static final long serialVersionUID = 5950169519310163575L;

    private String name;
    private String idjugador;
    private Mensaje msn;
    private Jugador openente;
    private int[][] tablero;//Este tablero va a tener 0 en todas las posiciones inicialmente donde tenga un 1 es por que ya fue un punto en la matriz que fue tomada por el oponente, donde tenga 2 es por que es una posicion del barco y donde tenga 3 es por que era una osicion del barco que fue tomada por el oponente.
    private ArrayList<int[]> barco;

    public Jugador(String name) {
        this.name = name;
        idjugador = UUID.randomUUID().toString();
        msn = Mensaje.ESPERA_SERVER;
        tablero = new int[Tablero.numBotones + 1][Tablero.numBotones + 1];
        barco = new ArrayList<>();
    }

    public void setPosicionTablero(int i, int j, int dato) {
        tablero[i][j] = dato;
    }

    public void setPosicionBarco(int i, int j) {
        int[] g = {i, j};
        barco.add(g);
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
        switch (tablero[i][j]) {
            case 0:
                tablero[i][j] = 1;
                break;
            case 2:
                tablero[i][j] = 3;
                break;
            default:
                System.out.println("Esa posicion ya fue tomada.");
                break;
        }
    }

    public boolean esGanador() {
        for (int[] posicion : barco) {
            if (tablero[posicion[0]][posicion[1]] == 3) {
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

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public ArrayList<int[]> getBarco() {
        return barco;
    }

    public void setBarco(ArrayList<int[]> barco) {
        this.barco = barco;
    }

}

