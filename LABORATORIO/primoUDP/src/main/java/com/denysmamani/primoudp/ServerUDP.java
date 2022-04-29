/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denysmamani.primoudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Carlos
 */
public class ServerUDP {

  public static void main (String args[]) { 
    int port=6789;  
    try {
      
      DatagramSocket socketUDP = new DatagramSocket(port);
      byte[] bufer = new byte[1000];

      while (true) {
        // Construimos el DatagramPacket para recibir peticiones
        DatagramPacket peticion =
          new DatagramPacket(bufer, bufer.length);

        // Leemos una petición del DatagramSocket
        socketUDP.receive(peticion);

        System.out.print("Datagrama recibido del host: " +
                           peticion.getAddress());
        System.out.println(" desde el puerto remoto: " +
                           peticion.getPort());
        
        String cadena = new String(peticion.getData());
        int numero = Integer.valueOf(cadena.trim());
        // Construimos el DatagramPacket para enviar la respuesta
        String primo = "ES PRIMO";
        String noprimo = "NO ES PRIMO";
        byte[] mensaje = primo.getBytes();
        byte[] mensaje2 = noprimo.getBytes();
        DatagramPacket respuesta =
          new DatagramPacket(mensaje,primo.length(),peticion.getAddress(),peticion.getPort());
        
        DatagramPacket respuesta2 =
          new DatagramPacket(mensaje2,noprimo.length(),peticion.getAddress(),peticion.getPort());
        
        
        if (numero == 0 || numero == 1 || numero == 4) {
            socketUDP.send(respuesta2);
            }
            for (int x = 2; x < numero / 2; x++) {

            if (numero % x == 0)
             socketUDP.send(respuesta2);
             }

             socketUDP.send(respuesta);
        
        
        // Enviamos la respuesta, que es un eco
       // socketUDP.send(respuesta);
      }

    } catch (SocketException e) {
      System.out.println("Socket: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
  }

}

    

