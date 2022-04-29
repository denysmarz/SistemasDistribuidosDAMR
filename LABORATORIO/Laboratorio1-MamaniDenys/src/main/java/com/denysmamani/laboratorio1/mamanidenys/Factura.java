/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.denysmamani.laboratorio1.mamanidenys;

import java.io.Serializable;

/**
 *
 * @author DENYS XD
 */

class Factura implements Serializable{
    private enum Mes {Enero,Febrero,Marzo,Abril,Mayo,Junio,Julio,Agosto,Septiembre,Octubre,Noviembre,Diciembre};
    private Empresa emprsa;
    private int idfactura;
    //Mes mes;
    private int año;
    private double monto;
    
    String[] cessa1 = new String[5];
    String[] cessa2 = new String[5];
    String[] cessa3 = new String[5];
    String[] cessa4 = new String[5];
    
    String[] cessa1 = {1,154,Mes.Diciembre,2021,150};
}
