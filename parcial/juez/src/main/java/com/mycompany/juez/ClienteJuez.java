/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.juez;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cursos_x86
 */
public class ClienteJuez {
    public static void main(String[] args) {
        IOperaciones operacion;
        Scanner sc = new Scanner(System.in);
        int op;
        
        try {
            operacion = (IOperaciones) Naming.lookup("rmi://localhost/Operaciones");
            do {                
                System.out.println("1.-Consultar cuentas");
                System.out.println("2.- Retener Monto");
                System.out.println("3.-SALIR");
                System.out.println("Elija una opcion: ");
                op = sc.nextInt();
                
                switch(op){
                    case 1: 
                        break;
                    case 2:
                        break;
                    case 3:
                        System.out.println("NOS VEMOS");
                        break;
                    default:
                        System.out.println("OPCION NO VALIDA");
                }
                
            } while (op != 3);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteJuez.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex){
            Logger.getLogger(ClienteJuez.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex){
            Logger.getLogger(ClienteJuez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
