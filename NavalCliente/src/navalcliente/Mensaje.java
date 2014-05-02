/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package navalcliente;

import java.io.Serializable;

/**
 *
 * @author Administrador
 */
public enum Mensaje implements Serializable {

    ESPERA_SERVER("Esperando conexion del servidor."),
    MOVIMIENTO_REALIZADO("Movimiento realizo, esperando movimiento de oponente"),
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

