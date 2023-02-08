/*
* Representa las cartas que tiene un jugador en la mano (las que dispone para jugar).
* Estructura: Se utilizarán TAD adecuado. 
* Funcionalidad: añadir carta a la mano, quitar carta de la mano, visualizar cartas de la mano,...
*/
package com.uvigo.poyectosushigo.CORE;

import java.util.LinkedList;
import java.util.List;


public class Mano{
   List<Carta> mano;
   int numCartas;
   
   public Mano(){
       mano = new LinkedList<>();
       numCartas = 0;
   }
   
   public int getNumCartas(){
       return numCartas;
   }
   
   public Carta getCarta(int pos){
       return mano.get(pos);
   }
   
   public void añadirElemento(Carta nuevo){
       mano.add(nuevo);
       numCartas++;
   }
   
   public Carta eliminarElemento(int pos){
       numCartas--;
       return mano.remove(pos);
       
   }
   
   @Override
   public String toString()
   {
       StringBuilder sb = new StringBuilder();
       for(int i = 0; i < mano.size(); i++){
           sb.append("\t\t[").append(i + 1).append("] ")
                .append(mano.get(i))
                   .append("\n");
       }
       
       return sb.toString();
       
   }

}