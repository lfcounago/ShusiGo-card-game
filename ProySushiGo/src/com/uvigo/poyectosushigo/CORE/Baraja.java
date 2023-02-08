/*
* Representa la baraja del sushiGo, 94 cartas, cada una representa a una comida 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: estando la baraja desordenada, devolverá la carta situada encima del montón de cartas
 */
package com.uvigo.poyectosushigo.CORE;

import java.util.List;
import java.util.LinkedList;

public class Baraja {
    private List<Carta> baraja;
    
    public Baraja(){
        baraja = new LinkedList<>();
        
        for(int i = 0; i < 5; i++){
            baraja.add(new Carta("Niguiri de calamar"));
        }
        
        for(int i = 0; i < 10; i++){
            baraja.add(new Carta("Niguiri de salmón"));
        }
        
        for(int i = 0; i < 5; i++){
            baraja.add(new Carta("Niguiri de tortilla"));
        }
        
        for(int i = 0; i < 6; i++){
            baraja.add(new Carta("Wasabi"));
        }
        
        for(int i = 0; i < 6; i++){
            baraja.add(new Carta("Maki de 1 rollo"));
        }
        
        for(int i = 0; i < 12; i++){
            baraja.add(new Carta("Maki de 2 rollos"));
        }
        
        for(int i = 0; i < 8; i++){
            baraja.add(new Carta("Maki de 3 rollos"));
        }
        
        for(int i = 0; i < 14; i++){
            baraja.add(new Carta("Tempura"));
        }
        
        for(int i = 0; i < 14; i++){
            baraja.add(new Carta("Sashimi"));
        }
        
        for(int i = 0; i < 14; i++){
            baraja.add(new Carta("Gyoza"));
        }
        
    }
    
    public void barajar(){
        Carta[] cartas = new Carta[94];
        List<Carta> nuevaBaraja= new LinkedList<>();
        
        for(int i = 0; i < 94; i++){
            cartas[i] = baraja.remove(0);
        }
        
        int numCartas = 94;
        int posAleatoria;
        
        for(int i = 0; i < 94; i++){
            posAleatoria = (int) (Math.random() * (93 - i));
            
            nuevaBaraja.add(cartas[posAleatoria]);
            
            for(int j = posAleatoria; j < numCartas - 1; j++ ){
                cartas[j] = cartas[j+1];
            }
            numCartas--;
        }
        
        baraja = nuevaBaraja;
    }
    
    public Carta popCarta(){
        return baraja.remove(0);
    }
}