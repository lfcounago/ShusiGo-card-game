/**
 * Representa el juego del sushiGo, con sus reglas. 
 * Se recomienda una implementación modular.
 */
package com.uvigo.proyectosushigo.IU;

import com.uvigo.poyectosushigo.CORE.*;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


public class Juego {
    
    public static void inicio (){
        int numJugadores = elegirNumJugadores();
        String[] nombresJugadores = leerNombresJugadores(numJugadores);
        
        List<Jugador> jugadores = null;
        
        for(int j = 0; j < Main.RONDAS; j++){
            jugadores = crearJugadores(jugadores, numJugadores, nombresJugadores);
            
            while(jugadores.get(0).getNumCartasMano() != 0){
                for(int i = 0; i < numJugadores; i++){
                    System.out.println("TURNO PARA: " + jugadores.get(i).getNombre());
                    System.out.println(mesasOtrosJugadores(jugadores, numJugadores, i));
                    System.out.println("\tTU MESA:");
                    System.out.println(jugadores.get(i).toStringMesa());

                    System.out.println("\tMANO:");
                    System.out.println(jugadores.get(i).toStringMano());

                    int posCartaMano = elegirCartaMano("\tElige la carta que quieras poner en la mesa: ", jugadores.get(i).getNumCartasMano());

                    int posPilaMesa = elegirPilaMesa(jugadores.get(i).getCartasMesa(), jugadores.get(i).getMano().getCarta(posCartaMano));
                    
                    if(posPilaMesa == -1){
                        jugadores.get(i).añadirPilaMesa();
                        jugadores.get(i).añadirCartaMesa(jugadores.get(i).eliminarCartaMano(posCartaMano), jugadores.get(i).getNumPilasMesa() - 1);
                    }else{
                        jugadores.get(i).añadirCartaMesa(jugadores.get(i).eliminarCartaMano(posCartaMano), posPilaMesa);
                    }
                    System.out.println("");
                }
                
                jugadores = intercambiarManos(jugadores, numJugadores);
            }
            
            System.out.println(mostrarMesas(jugadores, numJugadores));
            
            int[] puntuaciones = CartasMesa.calcularPuntuaciones(jugadores);
            
            for(int i = 0; i < puntuaciones.length; i++){
                jugadores.get(i).añadirPuntuacion(puntuaciones[i]);
            }
            
            mostrarPuntuaciones(jugadores);
        }
        
        System.out.println("");
        mostrarGanadores(jugadores);

    }
    
    public static void mostrarGanadores(List<Jugador> jugadores){
        int maxPuntuacion = 0;
        int numPuntuacionMax = 0;
        for(int i = 0; i < jugadores.size(); i++){
            if(maxPuntuacion == jugadores.get(i).getPuntuacionTotal()){
                numPuntuacionMax++;
            }
            
            if(maxPuntuacion < jugadores.get(i).getPuntuacionTotal()){
                maxPuntuacion = jugadores.get(i).getPuntuacionTotal();
                numPuntuacionMax = 1;
            }
        }
        
        if(numPuntuacionMax == 1){
            System.out.print("EL GANADOR ES: ");
        }else{
            System.out.print("LOS GANADORES SON: ");
        }
        
        int cont = 0;
        for(int i = 0; i < jugadores.size(); i++){
            if(jugadores.get(i).getPuntuacionTotal() == maxPuntuacion){
                if(cont>0){
                    System.out.print(", ");
                }

                System.out.print(jugadores.get(i).getNombre());
                cont++;
            }
        }
        System.out.println("");
        System.out.println("ENHORABUENA!! :)");    
    }
    
    public static void mostrarPuntuaciones(List<Jugador> jugadores){
        for(int i = 0; i < jugadores.size(); i++){
            System.out.print("DATOS DE: " + jugadores.get(i).getNombre());
            System.out.println(jugadores.get(i).toStringPuntuacionesRondas());
            System.out.println("\t\tPUNTUACIÓN TOTAL: " + jugadores.get(i).getPuntuacionTotal() + " puntos");
        }
    }
    

    public static String mostrarMesas(List<Jugador> jugadores, int numJugadores){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numJugadores; i++){
            sb.append("JUGADOR ").append(i+1).append("\n")
                    .append(jugadores.get(i).toStringMesa());
                    
        }
        
        return sb.toString();
    }
    
    public static String mesasOtrosJugadores(List<Jugador> jugadores, int numJugadores, int posEvitada){
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < numJugadores; i++){
            if(i != posEvitada){
                sb.append("\tMESA DE: ").append(jugadores.get(i).getNombre()).append("\n")
                    .append(jugadores.get(i).toStringMesa());
            }
        }
        
        return sb.toString();
    }
    
    public static List<Jugador> intercambiarManos(List<Jugador> jugadores, int numJugadores){
        Queue<Mano> manos = new ArrayBlockingQueue<>(numJugadores);
        
        for(int i = 0; i < numJugadores; i++){
            manos.offer(jugadores.get(i).getMano());
        }

        manos.add(manos.poll());

        for(int i = 0; i < numJugadores; i++){
            try{
                jugadores.get(i).setMano(manos.remove());
            }catch(NoSuchElementException e){
                System.err.println("\nERROR al intercambiar las manos: " + e.getMessage());
            }
        }
        
        return jugadores;
    }
    
    public static int elegirPilaMesa(CartasMesa mesa, Carta cartaNueva){
        String cartaBuscada = "";
        
        if(cartaNueva.toString().equals("Niguiri de calamar") 
                            || cartaNueva.toString().equals("Niguiri de salmón")
                            || cartaNueva.toString().equals("Niguiri de tortilla")){
            cartaBuscada = "Wasabi";
        }else{
            if(cartaNueva.toString().equals("Tempura")
                            || cartaNueva.toString().equals("Sashimi")
                            || cartaNueva.toString().equals("Gyoza")){
                
                cartaBuscada = cartaNueva.toString();
            }else{ 
                if(cartaNueva.toString().equals("Maki de 1 rollo") 
                            || cartaNueva.toString().equals("Maki de 2 rollos")
                            || cartaNueva.toString().equals("Maki de 3 rollos")){
                    cartaBuscada = "Maki";
                }
            }
        }
        
        if(!cartaBuscada.equals("")){
            for(int i = 0; i < mesa.getTamaño(); i++){
                if(cartaBuscada.equals("Maki")){
                    if(mesa.get(i).peek().toString().equals("Maki de 1 rollo")
                            || mesa.get(i).peek().toString().equals("Maki de 2 rollos")
                            || mesa.get(i).peek().toString().equals("Maki de 3 rollos")){
                        return i;
                    }
                }else{
                    if(mesa.get(i).peek().toString().equals(cartaBuscada)){
                        return i;
                    }
                }
                
            }         
        }
        
        return -1;
    }
    
    public static int elegirCartaMano(String mensaje, int numCartas){
        int eleccion = 0;
        boolean esValido;
        do{
            try{
                esValido = true;
                eleccion = ES.pideNumero(mensaje);
                
                if(eleccion < 1 || eleccion > numCartas){
                    System.err.println("\n\tERROR: Posición incorrecta");
                    esValido = false;
                }
            }catch(NumberFormatException e){
                System.err.println("\n\tERROR: Tienes que introducir un número");
                esValido = false;
            }
            
        }while(!esValido);
        
        return eleccion - 1;
    }
    
    public static List<Jugador> crearJugadores(List<Jugador> jugadores, int numJugadores, String[] nombresJugadores){
        
        Baraja baraja = new Baraja(); 
        baraja.barajar();                                       
        
        int numCartas = numCartasPorJugador(numJugadores);
        
        List<Jugador> nuevosJugadores = new LinkedList<>();
        for(int i = 0; i < numJugadores; i++){
            Jugador jugador = new Jugador(nombresJugadores[i]);
            
            for(int j = 0; j < numCartas; j++){      
                jugador.añadirCartaMano(baraja.popCarta());
            }
            
            if(jugadores != null){
                for(int k = 0; k < jugadores.get(i).getPuntuacionesRondasTamaño(); k++){
                    jugador.añadirPuntuacion(jugadores.get(i).getPuntuacionRonda(k));
                }
                
            }
            
            nuevosJugadores.add(jugador);                   
        }
        
        return nuevosJugadores;
    }
    
    public static int numCartasPorJugador(int numJugadores){ 
        int numCartas = 0;
        switch(numJugadores){
            case 2:
                numCartas = 10;
                break;
            case 3:
                numCartas = 9;
                break;
            case 4:
                numCartas = 8;
                break;
            case 5:
                numCartas = 7;
                break;
        }
        
        return numCartas;  
    }
    
    public static String[] leerNombresJugadores(int numJugadores){
        String[] nombresJugadores = new String[numJugadores];
        
        for(int i = 0; i < nombresJugadores.length; i++){
            nombresJugadores[i] = "";
        }
        
        for(int i = 0; i < numJugadores; i++){
            String nombreLeido;
            boolean esValido;
            do{
                nombreLeido = ES.pideCadena("Introduce el nombre del jugador " + (i+1) + ": ");
                esValido = !nombreYaIntroducido(nombresJugadores, nombreLeido);
                
                if(!esValido){
                    System.err.println("Ese jugador ya existe");
                }
            }while(!esValido);
            
            nombresJugadores[i] = nombreLeido;
            
        }
        
        return nombresJugadores;
    }
    
    private static boolean nombreYaIntroducido(String[] nombres, String buscado){
        for(int i = 0; i < nombres.length; i++){
            if(nombres[i].equals(buscado)){
                return true;
            }
        }
        
        return false;
    }
    
    public static int elegirNumJugadores(){
        int numJugadores = 0;
        boolean esValido;
        do{
            try{
                esValido = true;
                numJugadores = ES.pideNumero("Introduce el número de jugadores (de 2 a 5 personas): ");
                if(numJugadores < 2 || numJugadores > 5){
                    esValido = false;
                    System.err.println("\nERROR: Número de jugadores incorrecto");
                }
            }catch(NumberFormatException e){
                esValido = false;
                System.err.println("\nERROR: Introduce un número");
            }
            
        }while(!esValido);
        
        return numJugadores;
    } 
}