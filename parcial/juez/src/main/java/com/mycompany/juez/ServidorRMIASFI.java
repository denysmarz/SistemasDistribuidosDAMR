/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.juez;

import com.sun.org.apache.xerces.internal.util.URI;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cursos_x86
 */
public class ServidorRMIASFI {
    public static void main(String[] args) {
        try {
            ServidorASFI server = new ServidorASFI();
            
            LocateRegistry.createRegistry(1099);
            Naming.bind("Operaciones", server);
            System.out.println("El servidor esta levantado");
            
        } catch (RemoteException ex) {
            Logger.getLogger(ServidorRMIASFI.class.getName()).log(Level.SEVERE, null, ex);
        }catch (AlreadyBoundException ex) {
            Logger.getLogger(ServidorRMIASFI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex){
            Logger.getLogger(ServidorRMIASFI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
