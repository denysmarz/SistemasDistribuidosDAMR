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
import java.net.Socket;
import java.util.Scanner;


public class Clientesumatoria {

    public static void main(String[] args) {
        int port = 5002;
        try {
            Socket client = new Socket("localhost", port); 
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("INtroducir un numero:");
            Scanner llamada = new Scanner(System.in);
            int numero = llamada.nextInt();
            
            toServer.println(numero);
            String result = fromServer.readLine();  
            System.out.println("La sumatoria es: " + result);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
