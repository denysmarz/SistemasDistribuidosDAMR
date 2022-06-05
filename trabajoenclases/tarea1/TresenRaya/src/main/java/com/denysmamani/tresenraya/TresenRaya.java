/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.denysmamani.tresenraya;

import java.util.Scanner;

/**
 *
 * @author DENYS XD
 */
public class TresenRaya {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] datos = {"-", "-", "-", "-", "-", "-", "-", "-", "-"};
        String turno = "";
        System.out.println("    POSICIONES DEL TABLERO");
        System.out.println("\t " + 0 + " | " + 1 + " | " + 2);
        System.out.println("\t-----------");
        System.out.println("\t " + 3 + " | " + 4 + " | " + 5);
        System.out.println("\t-----------");
        System.out.println("\t " + 6 + " | " + 7 + " | " + 8);
        
        System.out.println("\nCuando sea tu turno debes poner un numero para posicionarte en el tablero");
        System.out.println("\n\tEl Juego a Empezado");
        while (true) {
            System.out.println("\n");
            tablero(datos);
            System.out.println("\n");
            System.out.println("TURNO DE JUGADOR X : ");
            int x = sc.nextInt();
            turno = "a";
            verificar(datos, x, turno);
            if (ganadorx(datos)==true) {
                tablero(datos);
                break;
            }
            
            tablero(datos);

            System.out.println("\nTURNO DE JUGADOR O : ");
            int o = sc.nextInt();
            turno = "b";
            verificar(datos, o, turno);
            if (ganadory(datos)==true) {
                tablero(datos);
                break;
            }
        }
        System.out.println("JUEGO TERMINADO");
    }

    public static void tablero(String[] datos) {
        System.out.println(" " + datos[0] + " | " + datos[1] + " | " + datos[2]);
        System.out.println("-----------");
        System.out.println(" " + datos[3] + " | " + datos[4] + " | " + datos[5]);
        System.out.println("-----------");
        System.out.println(" " + datos[6] + " | " + datos[7] + " | " + datos[8]);
    }

    private static void verificar(String[] datos, int x, String turno) {
        if(datos[x] == "-"){
            if (turno == "a") {
                datos[x]="X";
            }else{
                datos[x]="O";
            }
            
        }
        else{
            System.out.println("\nESE ESPACIO YA ESTA OCUPADO\nPerdiste tu Turno :(\n");
        }
        
    }

    private static boolean ganadorx(String[] datos) {
        for (int i = 0; i < datos.length; i++) {
            if(i == 0 || i == 1 || i == 2){
            if (datos[i] == "X" && datos[i + 3] == "X" && datos[i + 6] == "X") {
                System.out.println("EL GANADOR ES 'X'!!!!");
                return true;
            }
            }
            if (i == 0 || i == 3 || i == 6) {
                if (datos[i] == "X" && datos[i + 1] == "X" && datos[i + 2] == "X") {
                    System.out.println("EL GANADOR ES 'X'!!!!");
                    return true;
                }
            }
            if(i == 0 ){
                if (datos[i] == "X" && datos[i + 4] == "X" && datos[i + 8] == "X") {
                    System.out.println("EL GANADOR ES 'X'!!!!");
                    return true;
                }
            }
            if( i == 2){
                if (datos[i] == "X" && datos[i + 2] == "X" && datos[i + 4] == "X") {
                    System.out.println("EL GANADOR ES 'X'!!!!");
                    return true;
                }
            }
            
        }

return  false;
    }

    private static boolean ganadory(String[] datos) {
         for (int i = 0; i < datos.length; i++) {
            if(i == 0 || i == 1 || i == 2){
            if (datos[i] == "O" && datos[i + 3] == "O" && datos[i + 6] == "O") {
                System.out.println("EL GANADOR ES 'O'!!!!");
                return true;
            }
            }
            if (i == 0 || i == 3 || i == 6) {
                if (datos[i] == "O" && datos[i + 1] == "O" && datos[i + 2] == "O") {
                    System.out.println("EL GANADOR ES 'O'!!!!");
                    return true;
                }
            }
            if(i == 0 ){
                if (datos[i] == "O" && datos[i + 4] == "O" && datos[i + 8] == "O") {
                    System.out.println("EL GANADOR ES 'O'!!!!");
                    return true;
                }
            }
            if( i == 2){
                if (datos[i] == "O" && datos[i + 2] == "O" && datos[i + 4] == "O") {
                    System.out.println("EL GANADOR ES 'O'!!!!");
                    return true;
                }
            }
            
        }
         return false;
    }
}
