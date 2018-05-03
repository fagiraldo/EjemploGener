/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import generador.Generador;
import java.util.ArrayList;
import modelo.Clase;

/**
 *
 * @author Labing 201
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ArrayList<Clase> clases = new ArrayList<Clase>();
       Clase equipo = new Clase("Equipo");
       equipo.addAtributo("nombre", "string");
       
       
       Clase jugador = new Clase("Jugador");
       jugador.addAtributo("nombre", "string");
       jugador.addAtributo("edad", "int");
       
       clases.add(equipo);
       clases.add(jugador);
       
       Generador generador = new Generador(clases);
       generador.generar();
       
       
    }
    
}
