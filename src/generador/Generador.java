/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Atributo;
import modelo.Clase;

/**
 *
 * @author Labing 201
 */
public class Generador {

    private ArrayList<Clase> clases;

    public Generador(ArrayList<Clase> clases) {
        this.clases = clases;
    }

    public boolean generar() {
        //Generacion del Script
        File archivo = new File("script.sql");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException ex) {
                System.out.println("Archivo no se creo");
            }
        }
        try {
            PrintStream flujoSalida = new PrintStream(archivo);
            for (Clase clase : clases) {
                flujoSalida.print("CREATE TABLE ");
                flujoSalida.println(clase.getNombre() + " ( ");
                flujoSalida.println(" id int primary key auto_increment,");

                for (int i = 0; i < clase.getAtributos().size(); i++) {
                    Atributo atributo = clase.getAtributos().get(i);
                    if (i == clase.getAtributos().size() - 1) {
                        if (atributo.getTipo().equals("string")) {
                            flujoSalida.println(atributo.getNombre() + " VARCHAR(50) NOT NULL");
                        } else {
                            flujoSalida.println(atributo.getNombre() + " INT NOT NULL");
                        }

                    } else {
                        if (atributo.getTipo().equals("string")) {
                            flujoSalida.println(atributo.getNombre() + " VARCHAR(50) NOT NULL,");
                        } else {
                            flujoSalida.println(atributo.getNombre() + " INT NOT NULL,");
                        }
                    }

                }

                flujoSalida.println(");");
                flujoSalida.println("");
                
                
                
                //Generacion de los VO
                File archivoClase = new File(clase.getNombre() + ".java");
                PrintStream flujoClase = new PrintStream(archivoClase);
                flujoClase.println("public class " + clase.getNombre() + "{");
                for (Atributo atributo : clase.getAtributos()) {
                    flujoClase.println("private " + atributo.getTipo() + " " + atributo.getNombre()  + ";" );
                    flujoClase.println("public  " + atributo.getTipo() + " get" + atributo.getNombre()  + "(){" );
                    flujoClase.println("return this." + atributo.getNombre() + ";");
                    flujoClase.println("}");
                    
                    
                    flujoClase.println("public void set" + atributo.getNombre() + "("  + atributo.getTipo() + " " + atributo.getNombre()  + "){" );
                    flujoClase.println("this." + atributo.getNombre() + " = " + atributo.getNombre() + ";");
                    flujoClase.println("}");
                    
                }
                   
                flujoClase.flush();
                flujoClase.println("}");
                flujoClase.close();
                
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Generador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
