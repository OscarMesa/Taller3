/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chuidiang.ejemplos.tcp;

import co.com.poli.GUI.Tablero;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Jugador implements Serializable {

    private static final long serialVersionUID = 5950169519310163575L;

    private int id;
    private String name;
    private String idjugador;
    private Mensaje msn;
    private Jugador openente; 
    private int[][] tablero;//Este tablero va a tener 0 en todas las posiciones inicialmente donde tenga un 1 es por que ya fue un punto en la matriz que fue tomada por el oponente, donde tenga 2 es por que es una posicion del barco y donde tenga 3 es por que era una osicion del barco que fue tomada por el oponente.
    private ArrayList<int[]> barco;
    
    public Jugador(int id, String name) {
        this.id = id;
        this.name = name;
        idjugador = UUID.randomUUID().toString();
        msn = Mensaje.ESPERA_SERVER;
        tablero = new int[Tablero.numBotones + 1][Tablero.numBotones  + 1];
        barco = new ArrayList<>();
    }
    
    public void setPosicionTablero(int i, int j, int dato)
    {
        tablero[i][j] = dato;
    }
    
    public void setPosicionBarco(int i,int j)
    {
        int[] g = {i,j};
        barco.add(g);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 

    public String getName() {

        return name;

    }

    public Jugador(int id, String name, Mensaje msn) {
        this.id = id;
        this.name = name;
        this.msn = msn;
    }

    

    public void setName(String name) {

        this.name = name;

    }

    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Jugador student = (Jugador) o;

        if (id != student.id) return false;

        if (name != null ? !name.equals(student.name) : student.name != null) return false;

        return true;

    }

    public int hashCode() {

        return id;

    }
    
    public String toString() {

        return "Id = " + getId() + " ; Name = " + getName();

    }

    public String getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(String idjugador) {
        this.idjugador = idjugador;
    }

    public Jugador(int id, String name, String idjugador, Mensaje msn) {
        this.id = id;
        this.name = name;
        this.idjugador = idjugador;
       // this.msn = msn;
    }
    
    public void asignarPosicionTablero(int i, int j)
    {
        switch(tablero[i][j])
        {
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
    
    public boolean esGanador()
    {
        for (int[] posicion : barco) {
            if(tablero[posicion[0]][posicion[1]] == 3) {
            } else
                return false;
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

enum Mensaje implements Serializable{

    ESPERA_SERVER("Esperando conexion del servidor."),
    MOVIMIENTO_REALIZADO("El jugador ha realizado el movimeitno"),
    ESPERA_OPONENTE("Esperando conexion oponente."),
    TURNO("Es su turno, realice su movimiento."),
    ESPERA_MOVIMIENTO_OPONENTE("Espere que su oponente realice el movimiento"),
    ERROR_CONEXION("A surgiodo un error durante la conexion."),
    EXITO_TIRO("A conseguido darle al oponente."),
    ERRADO_TIRO("Su tiro fue errado."),
    UBICAR_BARCO("Seleccione una posicion dentro de la matriz, para colocar aletoreamente el barco."),
    INICIAR_PARTIDA("Por favor inicie la partida."),
    ERROR_POSICION_BARCO("Debe seleccionar un punto diferente en la mtriz, debido a que el barco no puede ser ubicado"),
    GANADOR("Ganador"),
    PERDEDOR("Perdedor");

    private final String msn;
    private static final long serialVersionUID = 42L; 

    private Mensaje(String msn) {
        this.msn = msn;
    }

    public String getMsn() {
        return msn;
    }
}
