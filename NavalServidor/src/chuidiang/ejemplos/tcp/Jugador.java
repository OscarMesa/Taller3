/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chuidiang.ejemplos.tcp;

import java.io.Serializable;
import java.util.UUID;

public class Jugador implements Serializable {

 

    private static final long serialVersionUID = 5950169519310163575L;

    private int id;
    private String name;
    private String idjugador;
    private Mensaje msn;

    public Jugador(int id, String name) {
        this.id = id;
        this.name = name;
        idjugador = UUID.randomUUID().toString();
        msn = Mensaje.ESPERA_SERVER;
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


    
}

enum Mensaje implements Serializable{

    ESPERA_SERVER("Esperando conexion del servidor."),
    ESPERA_OPONENTE("Esperando conexion oponente."),
    TURNO("Es su turno, realice su movimiento."),
    ESPERA_MOVIMIENTO_OPONENTE("Espere que su oponente realice el movimiento"),
    ERROR_CONEXION("A surgiodo un error durante la conexion."),
    EXITO_TIRO("A conseguido darle al oponente."),
    ERRADO_TIRO("Su tiro fue errado."),
    UBICAR_BARCO("Seleccione una posicion dentro de la matriz, para colocar aletoreamente el barco."),
    INICIAR_PARTIDA("Por favor inicie la partida."),
    ERROR_POSICION_BARCO("Debe seleccionar un punto diferente en la mtriz, debido a que el barco no puede ser ubicado");

    private final String msn;
    private static final long serialVersionUID = 42L; 

    private Mensaje(String msn) {
        this.msn = msn;
    }

    public String getMsn() {
        return msn;
    }
}
