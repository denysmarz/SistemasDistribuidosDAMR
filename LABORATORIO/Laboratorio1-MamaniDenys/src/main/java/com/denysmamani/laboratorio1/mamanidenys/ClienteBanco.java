/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.denysmamani.laboratorio1.mamanidenys;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DENYS XD
 */
public class ClienteBanco {

    public static void main(String[] args) {
        Ibanco operacion;
    Scanner sc=new Scanner(System.in);
    System.out.print("Introduzca su ID ");
    int n=sc.nextInt();
    try {
        operacion=(Ibanco)Naming.lookup("rmi://localhost/Operaciones"); // instanciar un objeto remoto 
        //System.out.print(operacion.factorial(n));
        
        
        
        
    } catch (NotBoundException ex) {
        Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MalformedURLException ex) {
        Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
    } catch (RemoteException ex) {
        Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
