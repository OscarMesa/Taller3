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
    private String idjugador = "123";

 

    public Jugador(int id, String name) {

        this.id = id;

        this.name = name;

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
    
    

}