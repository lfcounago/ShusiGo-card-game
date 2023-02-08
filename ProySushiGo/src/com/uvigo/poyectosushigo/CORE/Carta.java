/*
 * Representa una carta, formada por un nombre
 */
package com.uvigo.poyectosushigo.CORE;


public class Carta {

    private final String nombre;
    
    public Carta(String nombre){
        this.nombre = nombre;    
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
}
