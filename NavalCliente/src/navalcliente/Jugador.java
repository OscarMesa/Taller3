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
    
}
