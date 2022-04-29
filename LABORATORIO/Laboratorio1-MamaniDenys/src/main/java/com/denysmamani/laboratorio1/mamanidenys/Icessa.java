/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.denysmamani.laboratorio1.mamanidenys;

import java.rmi.RemoteException;

/**
 *
 * @author DENYS XD
 */
public interface Icessa {
    public Factura pendientes(int idCliente)throws RemoteException;
    String Pagar(Factura[]fact)throws RemoteException;
}
