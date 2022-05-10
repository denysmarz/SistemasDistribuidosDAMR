/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.denysmamani.menu;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DENYS XD
 */
public class MenuCliente {

    public static void main(String[] args) {
        IOperaciones operacion;
        Scanner sc=new Scanner(System.in);
        int op,n;
        String cadena = "";
        try {
            operacion=(IOperaciones)Naming.lookup("rmi://localhost/Operaciones"); // instanciar un objeto remoto 
            do {
                
                System.out.println("1.-SUMATORIA");
                System.out.println("2.-FACTORIAL");
                System.out.println("3.-INVERTIR CADENA");
                System.out.println("4.-SALIR");
                System.out.print("Introduzca una opcion: ");
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        System.out.print("Introduzca un numero: ");
                        n = sc.nextInt();
                        System.out.print("LA SUMATORIA ES: " + operacion.sumatoria(n) + "\n");
                        break;
                    case 2:
                        
                        System.out.print("Introduzca un numero: ");
                        n = sc.nextInt();
                        System.out.print("EL FACTORIAL ES: " + operacion.factorial(n) + "\n");
                        break;
                    case 3:
                        Scanner lecturaTeclado = new Scanner(System.in);
                        System.out.print("Introduzca Cadena: ");
                        cadena = lecturaTeclado.nextLine();
                        System.out.print("LA CADENA INVERTIDA ES: " + operacion.invertir(cadena) + "\n");
                        break;
                    case 4:
                        System.out.println("NOS VEMOS");
                        break;
                    default:
                        System.out.println("OPCION NO VALIDA");

                }
            } while (op != 4);
        
        
    } catch (NotBoundException ex) {
        Logger.getLogger(MenuCliente.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MalformedURLException ex) {
        Logger.getLogger(MenuCliente.class.getName()).log(Level.SEVERE, null, ex);
    } catch (RemoteException ex) {
        Logger.getLogger(MenuCliente.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
