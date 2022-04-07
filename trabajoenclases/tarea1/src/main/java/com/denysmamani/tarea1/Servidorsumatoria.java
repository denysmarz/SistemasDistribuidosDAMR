/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denysmamani.tarea1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidorsumatoria {

    public static void main(String[] args) {
        int port = 5002; 
        do{
            
              
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");
            Socket client;
            PrintStream toClient;       
            client = server.accept(); //conexion
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            
            String cadena = fromClient.readLine();
            System.out.println(cadena);
            int sum = sumatoria(Integer.parseInt(cadena));
            toClient = new PrintStream(client.getOutputStream()); 
            toClient.println(sum);
         
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        }while(true);
      
    }
    public static int sumatoria(int n){
       int sumatoria = 0;
       for(int i = 1;i<=n;i++){
           sumatoria+=i;
       }
       return sumatoria;
    }
}
