/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.denysmamani.menu;

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
    public int factorial(int n) throws RemoteException {
        int f = 1;

        for (int i = 1; i <= n; i++) {
            f = f * i;
        }

        return f;
    }

    @Override
    public int sumatoria(int n) throws RemoteException {
        
        int iSumatorio = 0;
        int iContador = n;

        while (iContador != 0) {

            iSumatorio = iSumatorio + iContador;
            iContador--;

        }
        return iSumatorio;
    }

    @Override
    public String invertir(String cadena) throws RemoteException {
        StringBuilder strb = new StringBuilder(cadena);
	cadena = strb.reverse().toString();
	//System.out.println(cadena);
        return cadena;
    }
    
}
