/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.denysmamani.menu;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author DENYS XD
 */
public interface IOperaciones extends Remote{
    public int factorial(int n) throws RemoteException ;
    public int sumatoria(int n) throws RemoteException ;
    public String invertir(String cadena) throws RemoteException ;
    
}
