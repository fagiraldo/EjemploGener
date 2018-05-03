/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Labing 201
 */
public class Clase {
    private String nombre;
    private ArrayList<Atributo> atributos;

    public Clase(String nombre) {
        this.nombre = nombre;
        this.atributos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public boolean addAtributo(String nombre, String tipo){
      Atributo atributo = new Atributo(nombre, tipo);
      return this.atributos.add(atributo);
      
    }
    public ArrayList<Atributo> getAtributos() {
        return atributos;
    }

    
    
    
    
}
