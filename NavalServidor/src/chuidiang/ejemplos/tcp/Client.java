/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chuidiang.ejemplos.tcp;

import java.io.IOException;

import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;

import java.net.Socket;

import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

 

public class Client {

    private Socket socket = null;

    private ObjectInputStream inputStream = null;

    private ObjectOutputStream outputStream = null;

    private boolean isConnected = false;

 

    public Client() {

 

    }

 

    public void communicate() {

 

     //   while (!isConnected) {

            try {

                System.out.println("Connected");

                isConnected = true;

                socket = new Socket("localHost", 4445);
                    Jugador student = new Jugador(43, "Bijoy");
                    System.out.println("Object to be written = " + student);
                   outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeObject(student);
                    outputStream.flush();
                   
                

            } catch (SocketException se) {

                se.printStackTrace();

                // System.exit(0);

            } catch (IOException e) {

                e.printStackTrace();

            }

        //}

    }

 

    public static void main(String[] args) {

        Client client = new Client();

        client.communicate();

    }

}