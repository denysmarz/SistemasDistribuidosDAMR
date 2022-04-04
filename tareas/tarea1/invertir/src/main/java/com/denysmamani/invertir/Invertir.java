/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.denysmamani.invertir;

import java.util.Scanner;

/**
 *
 * @author DENYS XD
 */
public class Invertir {
    public static void main(String[] args) {
 
          Scanner sc = new Scanner(System.in);
          System.out.print("Introduce cadena: ");
          String n = sc.nextLine();
          System.out.print(InvertirCadena(n));                     
     } 

     public static String InvertirCadena(String cadena) {
        String cadenaInvertida = "";
        for (int x = cadena.length() - 1; x >= 0; x--)
            cadenaInvertida = cadenaInvertida + cadena.charAt(x);
        return cadenaInvertida;
    }
}
