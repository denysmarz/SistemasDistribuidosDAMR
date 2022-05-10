/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.denysmamani.clientelibros;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author DENYS XD
 */
public class ServidorLibros extends UnicastRemoteObject implements IOperaciones{
    
    ArrayList<Libro>libros= new ArrayList();
    int top = 0;
    
    public ServidorLibros() throws RemoteException {
        super();
    }


    @Override
    public String crear(String titulo, String autor) throws RemoteException {
        top++;
        Libro aux = new Libro (top,titulo,autor);
        libros.add(aux);
        return "si";
    }

    @Override
    public Libro editar(int id, String titulo, String autor) throws RemoteException {
        if(id>0&&id<=top){
            libros.get(id-1).setTitulo(titulo);
            libros.get(id-1).setAutor(autor);
            return libros.get(id);
        }
        return null;
    }

    @Override
    public String eliminar(int id) throws RemoteException {
        if(id >0&&id<=top){
        libros.remove(libros.get(id-1));
        top--;
        return "si";
        }
        return "no";
    }

    @Override
    public ArrayList<Libro> mostrar() throws RemoteException {
        return libros;
    }
    
}
