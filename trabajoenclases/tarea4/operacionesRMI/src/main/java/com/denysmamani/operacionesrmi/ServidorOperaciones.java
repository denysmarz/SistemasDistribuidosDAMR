/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.denysmamani.operacionesrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author DENYS XD
 */
public class ServidorOperaciones extends UnicastRemoteObject implements IOperaciones{
     public ServidorOperaciones() throws RemoteException {
        super();
    }

    @Override
    public int suma(int x,int y) throws RemoteException {
        

        return x+y;
    }
    
        @Override
    public int resta(int x,int y) throws RemoteException {
        

        return x-y;
    }
    
        @Override
    public int multiplicacion(int x,int y) throws RemoteException {
        

        return x*y;
    }
    
        @Override
    public int dividir(int x,int y) throws RemoteException {
        

        return x/y;
    }
}
