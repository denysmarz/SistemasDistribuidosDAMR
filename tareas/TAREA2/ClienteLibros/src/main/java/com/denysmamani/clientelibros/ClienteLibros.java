/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.denysmamani.clientelibros;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DENYS XD
 */
public class ClienteLibros {

    public static void main(String[] args) {
        IOperaciones operacion;
        Scanner sc = new Scanner(System.in);
        Scanner leertitulo = new Scanner(System.in);
        Scanner leerautor = new Scanner(System.in);
        
        
        String titulo, autor;
        int id,op;
        //String elim = null;
        
        //Libro libro;
      
        
        try {
            operacion = (IOperaciones) Naming.lookup("rmi://localhost/Operaciones"); // instanciar un objeto remoto 
            do {

                System.out.println("1.-CREAR");
                System.out.println("2.-EDITAR");
                System.out.println("3.-ELIMINAR");
                System.out.println("4.-MOSTRAR");
                System.out.println("5.-SALIR");
                System.out.println("Elija una opcion: ");
                op = sc.nextInt();

                switch (op) {
                    case 1:
                        
                        System.out.print("Introduce titulo: ");
                        titulo = leertitulo.nextLine();
                        System.out.print("Introduce autor: ");
                        autor = leerautor.nextLine();
                        operacion.crear(titulo,autor);
                        break;
                    case 2:
                        System.out.print("Numero de ID: ");
                        id = sc.nextInt();
                        System.out.print("Introduce titulo: ");
                        titulo = leertitulo.nextLine();
                        System.out.print("Introduce autor: ");
                        autor = leerautor.nextLine();
                        System.out.println("Libro: ");
                        Libro aux = operacion.editar(id, titulo, autor);
                        System.out.println(aux);
                        break;
                    case 3:
                        System.out.println("Ingresar ID de libro: ");
                        id = sc.nextInt();
                        operacion.eliminar(id);
                        break;
                    case 4:
                        ArrayList<Libro>auxiliar= operacion.mostrar();
                        for(Libro libro:auxiliar){
                            System.out.println(libro);
                        }
                        break;
                    case 5:
                        System.out.println("NOS VEMOS");
                        break;
                    default:
                        System.out.println("OPCION NO VALIDA");

                }
            } while (op != 5);

            
            

        
        
        
    } catch (NotBoundException ex) {
        Logger.getLogger(ClienteLibros.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MalformedURLException ex) {
        Logger.getLogger(ClienteLibros.class.getName()).log(Level.SEVERE, null, ex);
    } catch (RemoteException ex) {
        Logger.getLogger(ClienteLibros.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
