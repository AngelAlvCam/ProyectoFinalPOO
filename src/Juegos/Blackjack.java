/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import java.util.Random;
import java.util.Scanner;

/**@author crismartinez Esta clase es la encargada de realizar lo que se le denomina juego de Black Jack, a traves de un metodo static 
 * se implementan dos randoms en los cuales se van agregando a un contador de los valores de las cartas y asi mismo 
 * cuantas cartas se han utilizado hasta el momento; para que con los contadores utilizados se comparen segun las reglas del juego 
 * para asi de acuerdo a esta devolver el respectivo valor por un return
 */
public class Blackjack {

	public static boolean Jugar() {
            Scanner sc = new Scanner(System.in);
            Random aleatorio = new Random();
            Random aleatorio1 = new Random();
            int op = 0;
            int jugador=0;
            int repartidor=0;
            int repartidor1=0;
            boolean win=false;
            int carta1=0;
            int carta2=0;
            int numJ;
            int numR;
		System.out.println("Bienvenido al blackjack");
                System.out.println("Presione enter para empezar el juego");
                sc.nextLine();
                carta1=aleatorio.nextInt(10)+1;
                carta2=aleatorio1.nextInt(10)+1;
                System.out.println("Las cartas que recibise son "+carta1+ " Y "+carta2);
                jugador = carta1 + carta2;
                System.out.println("La suma de estas cartas es de "+jugador);
                carta1=aleatorio.nextInt(10)+1;
                carta2=aleatorio1.nextInt(10)+1;
                numJ=2;
                System.out.println("Las cartas del repartidor son "+carta1+ " y una carta oculta");
                repartidor = carta1 + carta2;
                repartidor1= carta1;
                numR=2;
                System.out.println("Si deseas otra carta presiona 1 si ya no quieres mas cartas presiona 2");
                op = sc.nextInt();
                while(op != 2){
                    carta2=aleatorio1.nextInt(10)+1;
                    System.out.println("La carta que recibiste fue "+carta2);
                    if(repartidor >= 17){
                        System.out.println("El repartidor no toma mas cartas");
                    }else{
                        carta1=aleatorio1.nextInt(10)+1;
                        System.out.println("El repartidor toma otra carta");
                        repartidor1= carta1+repartidor1;
                        numR++;
                        System.out.println("La suma de las cartas del repartidor son "+repartidor1+ " y una carta oculta, lleva en total "+numR+" cartas");
                        repartidor = carta1 +repartidor;
                        
                    }
                    jugador = carta2 + jugador;
                    numJ++;
                    System.out.println("La suma de tus cartas es de "+jugador+" llevas "+numJ+" cartas");
                    System.out.println("Si deseas otra carta presiona 1 si ya no quieres mas cartas presiona 2");
                    op = sc.nextInt();
                    
                }
                
                System.out.println("El valor de tus cartas es de "+jugador+ " con "+numJ+" cartas");
                
                System.out.println("La suma de las cartas del repartidor "+repartidor+" con "+numR+" cartas");
                if((jugador > repartidor) && (jugador <=21)&& (numJ <= numR)){
                    System.out.println("Felicidades ganaste");
                    win = true;
                }else if((repartidor > 21) && (jugador <= 21) && (numJ <= numR)){
                    System.out.println("Felicidades ganaste");
                    win = true;
                }else{
                    System.out.println("Lo siento perdiste");
                    win = false;
                }
		return win;
	}
}