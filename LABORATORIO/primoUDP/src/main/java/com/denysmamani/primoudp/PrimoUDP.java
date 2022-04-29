/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.denysmamani.primoudp;
import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author DENYS XD
 */
public class PrimoUDP {

    public static void main(String[] args) {
        int puerto = 6789;

    try {
       Scanner sc=new Scanner(System.in);
       System.out.print("Introduzca un numero: ");
       int numero=sc.nextInt();
        
        String dato=String.valueOf(numero);
        String ip="localhost";
      DatagramSocket socketUDP = new DatagramSocket();
      
      
      
      byte[] mensaje = dato.getBytes();
      InetAddress hostServidor = InetAddress.getByName(ip);
      
      // Construimos un datagrama para enviar el mensaje al servidor
      DatagramPacket peticion =
        new DatagramPacket(mensaje, dato.length(), hostServidor,
                           puerto);

      // Enviamos el datagrama
      socketUDP.send(peticion);

      // Construimos el DatagramPacket que contendrá la respuesta
      byte[] bufer = new byte[1000];
      DatagramPacket respuesta =
        new DatagramPacket(bufer, bufer.length);
      socketUDP.receive(respuesta);

      // Enviamos la respuesta del servidor a la salida estandar
      System.out.println("Respuesta: " + new String(respuesta.getData()));

      // Cerramos el socket
      socketUDP.close();

    } catch (SocketException e) {
      System.out.println("Socket: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
    }
}
