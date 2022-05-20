/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.denysmamani.resolucionparcial1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Carlos
 */
public class ServidorAsfi extends UnicastRemoteObject implements IAsfi {
ArrayList<Cuenta>libros= new ArrayList();
    public ServidorAsfi() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Cuenta> ConsultarCuentas(String ci, String nombres, String apellidos) throws RemoteException {
        int port = 5002;
        ArrayList aux = new ArrayList();
        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            toServer.println("Buscar:" + ci + "-" + nombres + "-" + apellidos);
            String result = fromServer.readLine();
            String[] listacuentas = result.split(":");
            for (String c : listacuentas) {
                String[] datos = c.split("-");
                Cuenta cuenta = new Cuenta(Banco.BancoMercantil, ci, datos[0], nombres, apellidos, Double.valueOf(datos[1]));
                aux.add(cuenta);
                System.out.println("cadena devuelta es: " + cuenta);
            }
    

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return aux;
    }

    @Override
    public Boolean RetenerMonto(Cuenta cuenta, double monto, String glosa) throws RemoteException {
        int port = 5002;
        
        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            toServer.println("Cogelar:" + cuenta.getCi() + "-" + monto);
            String result = fromServer.readLine();
            String[] respuesta = result.split("-");
            //System.out.println(result+"RMI "+"resp"+Arrays.toString(respuesta));
            //System.out.println(monto+" "+cuenta.getCi());
            if (respuesta.equals("SI")) {
                return true;
            } else {
                //System.out.println(respuesta);
                return false;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
