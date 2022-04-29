/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denysmamani.primotcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Carlos
 */
public class ServidorTCP {

    public static void main(String[] args) {
        int port = 5002; 
              
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");
            Socket client;
            PrintStream toClient;       
            client = server.accept(); //conexion
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            
            toClient = new PrintStream(client.getOutputStream());
            int numero = Integer.parseInt(fromClient.readLine());
            
            if (numero == 0 || numero == 1 || numero == 4) {
            toClient.println("NO ES PRIMO");
            }
            for (int x = 2; x < numero / 2; x++) {

            if (numero % x == 0)
             toClient.println("NO ES PRIMO");
             }

             toClient.println("ES PRIMO");
            
            
            System.out.println(numero);
             
           // toClient.println("Hola Mundo");
            System.out.println("Cliente se conecto");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

      
    }
}
