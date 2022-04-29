/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.denysmamani.primotcp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author DENYS XD
 */
public class PrimoTCP {

    public static void main(String[] args) {
       int port = 5002;
        try {
            Socket client = new Socket("localhost", port); 
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
             Scanner sc=new Scanner(System.in);
             System.out.print("Introduzca un numero: ");
             int x=sc.nextInt();
             
             
            toServer.println(x);
            String result = fromServer.readLine();  
            System.out.println("cadena devuelta es: " + result);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
