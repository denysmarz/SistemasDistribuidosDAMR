/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.denysmamani.clientelibros;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author DENYS XD
 */
public interface IOperaciones extends Remote{
    public String crear(String titulo,String autor) throws java.rmi.RemoteException ;
    public Libro editar(int id, String titulo,String autor) throws java.rmi.RemoteException ;
    public String eliminar(int id) throws java.rmi.RemoteException ;
    public ArrayList<Libro> mostrar() throws java.rmi.RemoteException;
}
