/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.juez;

import java.rmi.Remote;
import java.util.ArrayList;

/**
 *
 * @author Cursos_x86
 */
public interface IOperaciones extends Remote{
     public ArrayList<Cuenta>ConsultarCuentas(String ci,String nombres,String apellidos) throws java.rmi.RemoteException;
    public boolean RetenerMonto(Cuenta cuenta,int monto,int glosa) throws java.rmi.RemoteException;
}
