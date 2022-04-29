/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author Denys
 */
public class ServidorBanco extends UnicastRemoteObject implements Ibanco {

    public ServidorBanco() throws RemoteException {
        super();
    }

    @Override
    public Factura[] Calcular(int idCliente) throws RemoteException {
        
        Icessa operacion;
        //Scanner sc=new Scanner(System.in);
        //System.out.print("Introduzca su ID ");
        //int n=sc.nextInt();
        try {
            operacion=(Icessa)Naming.lookup("rmi://localhost/Operaciones"); // instanciar un objeto remoto 
            //System.out.print(operacion.factorial(n));
            operacion.pendientes(idCliente);
        
        
        
        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    @Override
    public String Pagar(Factura[] fact) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
