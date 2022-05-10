/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.denysmamani.menu;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DENYS XD
 */
public class MenuRMI {
   public static void main(String[] args){
         
         try {
             ServidorOperaciones server=new ServidorOperaciones();
         
             LocateRegistry.createRegistry(1099); //levantar el servidor de registro;
             Naming.bind("Operaciones",server);
             System.out.println("El servidor esta levandado");
             
             
         } catch (RemoteException ex) {
             Logger.getLogger(MenuRMI.class.getName()).log(Level.SEVERE, null, ex);
         } catch (AlreadyBoundException ex) {
             Logger.getLogger(MenuRMI.class.getName()).log(Level.SEVERE, null, ex);
         } catch (MalformedURLException ex) {
             Logger.getLogger(MenuRMI.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
    }
}
