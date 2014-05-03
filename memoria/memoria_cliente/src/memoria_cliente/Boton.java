/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria_cliente;

import java.util.Comparator;
import javax.swing.JButton;

/**
 *
 * @author Administrador
 */
public class Boton implements Comparable<Boton>, Comparator<Boton>{
    
    private JButton btn;
    private int fila;
    private int columna;
    private boolean habilitado;
    private int estado;
    private int url;
    
    public Boton() {
    }
    
    public Boton(JButton btn, int fila, int columna) {
        this.btn = btn;
        this.fila = fila;
        this.columna = columna;
        habilitado = true;
        estado = 0;
    }
    
    public boolean isHabilitado() {
        return habilitado;
    }    
    
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    public JButton getBtn() {
        return btn;
    }
    
    public void setBtn(JButton btn) {
        this.btn = btn;
    }
    
    public int getFila() {
        return fila;
    }
    
    public void setFila(int fila) {
        this.fila = fila;
    }
    
    public int getColumna() {
        return columna;
    }
    
    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }    
    
    @Override
    public int compareTo(Boton o) {
        if (this.getColumna() == o.getColumna() && this.getFila() == o.getFila()) {
            return 2;
        } else {
            return (this.getFila());
        }
    }
    
    @Override
    public int compare(Boton o1, Boton o2) {
        return o1.equals(o2) ? 1 : 0;
    }
    
    public static void main(String... args)
    {
        System.out.println("hola");
        new Boton();
    }
    
}
