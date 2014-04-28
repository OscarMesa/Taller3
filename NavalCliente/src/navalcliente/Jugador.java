/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package navalcliente;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author omesa
 */
public class Jugador implements Serializable {
    
    private static final long serialVersionUID = 3258698714674442547L;
    private UUID idjugador = UUID.randomUUID();
    private boolean execute;
    private Mensaje msn;
    
    public Jugador()
    {
        idjugador = UUID.randomUUID();
        execute = true;
    }
    
    public byte [] serializarJugardor(){
        try
        {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream (bytes);
            os.writeObject(this);
            os.close();
            return bytes.toByteArray();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    } 
    
    public static Jugador derializarJugador(byte[] bytes)
    {
        try
        {
            ByteArrayInputStream byteArray = new ByteArrayInputStream(bytes);
            ObjectInputStream is = new ObjectInputStream(byteArray);
            Jugador aux = (Jugador)is.readObject();
            is.close();
            return aux;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    
        public UUID getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(UUID idjugador) {
        this.idjugador = idjugador;
    }

    public boolean isExecute() {
        return execute;
    }

    public void setExecute(boolean execute) {
        this.execute = execute;
    }

    public Mensaje getMsn() {
        return msn;
    }

    public void setMsn(Mensaje msn) {
        this.msn = msn;
    }
    
    
}

enum Mensaje {

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

    private Mensaje(String msn) {
        this.msn = msn;
    }

    public String getMsn() {
        return msn;
    }
}
