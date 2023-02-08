/*
* Representa las cartas que coloca el jugador en la mesa (únicamente las suyas).
* Estructura: Se utilizarán TADs adecuados para su respresentación. En concreto:Una lista de pilas 
* Funcionalidad: colocar una carta en la mesa, calcular la puntuación de las cartas de la mesa, calcular el número de rollitos, visualizar cartas de la mesa, descartar cartas de la mesa, etc
*/
package com.uvigo.poyectosushigo.CORE;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class CartasMesa {
    private List<Stack<Carta>> cartasMesa; //las cartas de la mesa se representan como una lista de pilas
    
    public CartasMesa(){
        cartasMesa = new LinkedList<>();
    }
    
    public int getTamaño(){
        return cartasMesa.size();
    }
    
    public void añadirPila(){
        cartasMesa.add(new Stack<>());
    }

    public Stack<Carta> get(int pos){
        return cartasMesa.get(pos);
    }
    
    public void añadirCarta(Carta nuevaCarta, int pos){
        cartasMesa.get(pos).add(nuevaCarta);
    }
    
    public static int[] calcularPuntuaciones(List<Jugador> jugadores){ //funcion para calcular la puntacion de cada jugador
        int[] puntuaciones = new int[jugadores.size()];
        int[] contadorMakis = new int[jugadores.size()];

        
        for(int j = 0; j < jugadores.size(); j++){
            puntuaciones[j] = 0;
            contadorMakis[j] = 0;
            for(int i = 0; i < jugadores.get(j).getCartasMesa().getTamaño(); i++){
                String carta = jugadores.get(j).getCartasMesa().get(i).pop().toString();

                if(carta.equals("Niguiri de calamar")){
                    if(jugadores.get(j).getCartasMesa().get(i).isEmpty()){
                        puntuaciones[j] += 3;
                    }else{
                        puntuaciones[j] += 9;
                    }
                }else{
                    if(carta.equals("Niguiri de salmón")){
                        if(jugadores.get(j).getCartasMesa().get(i).isEmpty()){
                            puntuaciones[j] += 2;
                        }else{
                            puntuaciones[j] += 6;
                        }
                    }else{
                        if(carta.equals("Niguiri de tortilla")){
                            if(jugadores.get(j).getCartasMesa().get(i).isEmpty()){
                                puntuaciones[j] += 1;
                            }else{
                                puntuaciones[j] += 3;
                            }
                        }else{
                            if(carta.equals("Tempura") || carta.equals("Sashimi") || carta.equals("Gyoza")){
                                int cont = 1;
                                while(!jugadores.get(j).getCartasMesa().get(i).isEmpty()){
                                    jugadores.get(j).getCartasMesa().get(i).pop();
                                    cont++;
                                }

                                if(carta.equals("Tempura")){
                                    puntuaciones[j] += (cont/2)*5;
                                }else{
                                    if(carta.equals("Sashimi")){
                                        puntuaciones[j] += (cont/3)*10;
                                    }else{
                                        puntuaciones[j] += puntuacionGyoza(cont); 
                                    }
                                }
                            }else{
                                if(carta.equals("Maki de 1 rollo") || carta.equals("Maki de 2 rollos") || carta.equals("Maki de 3 rollos")){
                                    if(carta.equals("Maki de 1 rollo")){
                                        contadorMakis[j]++;
                                    }else{
                                        if(carta.equals("Maki de 2 rollos")) {
                                            contadorMakis[j] += 2;
                                        }else{
                                            contadorMakis[j] += 3;
                                        }
                                    }
                                    
                                    contadorMakis[j] += contarMakis(jugadores.get(j).getCartasMesa().get(i));
                                    
                                }
                            }
                        }
                    }
                }
            }
        }
        
        int masMakis = 0;
        
        for(int i = 0; i < contadorMakis.length; i++){ //busca la mayor cantidad de makis de los jugadores
            if(masMakis < contadorMakis[i]){
                masMakis = contadorMakis[i];
            }
        }
        
        if(masMakis > 0){
            int[] posMasMakis = new int[jugadores.size()]; 
            int numElem = 0;
            for(int i = 0; i < contadorMakis.length; i++){ //calculamos cuantos y que jugadores tienen la cantidad maxima de makis
                if(masMakis == contadorMakis[i]){
                    posMasMakis[numElem] = i;
                    numElem++;
                }
            }
            
            for(int i = 0; i < numElem; i++){ //sumamos la puntuacion de los makis a cada jugador que le corresponda
                puntuaciones[posMasMakis[i]] += 6/numElem;
            }
        }
        
        return puntuaciones;
        
    }
    
    private static int puntuacionGyoza(int cont){  //calcula la putuacion de los Gyoza dependiendo de la contidad de cartas
        int puntuacion;
        switch(cont){
            case 1:
                puntuacion = 1;
                break;
            case 2:
                puntuacion = 3;
                break;
            case 3:
                puntuacion = 6;
                break;
            case 4:
                puntuacion = 10;
                break;
            default:
                puntuacion = 15;
        }
        
        return puntuacion;
    }
    
    private static int contarMakis(Stack<Carta> pila){ //cuenta la cantidad de rollitos de makis que hay en una pila
        int contador = 0;
        while(!pila.isEmpty()){
            Carta carta = pila.pop();
            if(carta.toString().equals("Maki de 1 rollo")){
                contador++;
            }else{
                if(carta.toString().equals("Maki de 2 rollos")) {
                    contador += 2;
                }else{
                    contador += 3;
                }
            } 
        }
        return contador;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < cartasMesa.size(); i++){
            sb.append("\t\t[").append(i + 1).append("] ");
            for(Carta c: cartasMesa.get(i)){
                sb.append(c.toString()).append("\t");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
}