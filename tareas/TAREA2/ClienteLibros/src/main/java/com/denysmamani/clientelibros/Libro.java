/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.denysmamani.clientelibros;

import java.io.Serializable;

/**
 *
 * @author DENYS XD
 */
public class Libro implements Serializable{
    public int id;
    public String titulo;
    public String autor;
    
    //constructor
    
    Libro(int top, String titulo, String autor) {
        this.id=top;
        this.titulo=titulo;
        this.autor=autor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
    @Override
    public String toString(){
        return "Libro{"+"ID: "+id+", TITULO: "+titulo+", AUTOR: "+autor+"}";
    }
}
