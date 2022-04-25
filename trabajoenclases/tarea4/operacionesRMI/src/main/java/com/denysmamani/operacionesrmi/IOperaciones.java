/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.denysmamani.operacionesrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author DENYS XD
 */
public interface IOperaciones extends Remote{
    public int suma(int x,int y) throws RemoteException ;
    public int resta(int x,int y) throws RemoteException ;
    public int multiplicacion(int x,int y) throws RemoteException ;
    public int dividir(int x,int y) throws RemoteException ;
}
