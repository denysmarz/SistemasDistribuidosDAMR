/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.denysmamani.operacionesrmi;

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
public class ClienteOperaciones {
    public static void main(String[] args){
    IOperaciones operacion;
    Scanner sc=new Scanner(System.in);
    System.out.print("Introduzca un numero: ");
    int x=sc.nextInt();
    
    
    System.out.print("Introduzca segundo numero: ");
    int y = sc.nextInt();
    
    
    
    try {
        operacion=(IOperaciones)Naming.lookup("rmi://localhost/Operaciones"); // instanciar un objeto remoto 
        
        int op;
        do {    
        
        System.out.println("OPERACIONES");
        System.out.println("1.-Sumar");
        System.out.println("2.-Restar");
        System.out.println("3.-Multiplicar");
        System.out.println("4.-Dividir");
        System.out.println("5.-salir");
        
         op = sc.nextInt();
        
        switch (op) {
            case 1: 
                System.out.println("suma = "+operacion.suma(x,y));
                break;
            case 2: 
                System.out.println("resta = "+operacion.resta(x,y));
                break;
            case 3: 
                System.out.println("multiplicacion = "+operacion.multiplicacion(x,y));
                break;
            case 4: 
                System.out.println("division = "+operacion.dividir(x,y));
                break;
            case 5:
                System.out.println("Hasta pronto");
            default:
                System.out.println("OPCION NO VALIDA");
        }
        } while (op != 5);
        
        
        
        
        
    } catch (NotBoundException ex) {
        Logger.getLogger(ClienteOperaciones.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MalformedURLException ex) {
        Logger.getLogger(ClienteOperaciones.class.getName()).log(Level.SEVERE, null, ex);
    } catch (RemoteException ex) {
        Logger.getLogger(ClienteOperaciones.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
