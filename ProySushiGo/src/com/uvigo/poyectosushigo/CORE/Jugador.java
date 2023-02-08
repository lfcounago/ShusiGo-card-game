/*
 * Representa a un jugador de la partida, identificado por el nombre 
 * Funcionalidad: escoge una carta de su mano; la colocará en su mesa; coge cartas de la baraja para la mano,
 *                entrega las cartas de su mano; coge las cartas de otra mano; calcula su puntuación por ronda;
 *                calcula su puntuación total; cuenta cuantos rollitos tiene en su mesa; ....
 */
package com.uvigo.poyectosushigo.CORE;

import com.uvigo.proyectosushigo.IU.Main;


public class Jugador {
    private final String nombre;
    private Mano mano;
    private CartasMesa mesa;
    private int[] puntuacionesRondas;
    int numPuntuaciones;

    public Jugador(String nombre) {
        this.nombre = nombre;
        mano = new Mano();
        mesa = new CartasMesa();
        puntuacionesRondas = new int[Main.RONDAS];
        numPuntuaciones = 0;
        
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void añadirPuntuacion(int puntos){
        puntuacionesRondas[numPuntuaciones] = puntos;
        numPuntuaciones++;
    }
    
    public int getPuntuacionesRondasTamaño(){
        return numPuntuaciones;
    }
    
    public int getPuntuacionRonda(int pos){
        return puntuacionesRondas[pos];
    }
    
    public int getPuntuacionTotal(){
        int puntuacionTotal = 0;
        for(int i = 0; i < numPuntuaciones; i++){
            puntuacionTotal += puntuacionesRondas[i];
        }
        return puntuacionTotal;
    }
    
    public void setMano(Mano mano){
        this.mano = mano;
    }
    
    public Mano getMano(){
        return mano;
    }
    
    public int getNumCartasMano(){
        return mano.getNumCartas();
    }
    
    public CartasMesa getCartasMesa(){
        return mesa;
    }
    
    public int getNumPilasMesa(){
        return mesa.getTamaño();
    }
    
    public Carta eliminarCartaMano(int pos){
        return mano.eliminarElemento(pos);
    }
    
    public void añadirCartaMano(Carta nuevaCarta){
        mano.añadirElemento(nuevaCarta);
    }
    
    public void añadirCartaMesa(Carta nuevaCarta, int pos){
        mesa.añadirCarta(nuevaCarta, pos);
    }
    
    public void añadirPilaMesa(){
        mesa.añadirPila();
    }
    
    public String toStringMano(){
        return mano.toString();
    }
    
    public String toStringMesa(){ 
        return mesa.toString();
    }
    
    public String toStringPuntuacionesRondas(){
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < numPuntuaciones; i++){
            sb.append("\n\tRONDA ")
                    .append(i + 1)
                    .append(": ")
                    .append(puntuacionesRondas[i])
                    .append(" puntos");
        }
        
        return sb.toString();
    }
}
