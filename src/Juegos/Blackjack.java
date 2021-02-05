/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import java.util.*;

import Principal.Utilidades;

/** @author Luis Carlos**/
/**@author crismartinez Esta clase es la encargada de realizar lo que se le denomina juego de Black Jack, a traves de un metodo static 
 * se implementan dos randoms en los cuales se van agregando a un contador de los valores de las cartas y asi mismo 
 * cuantas cartas se han utilizado hasta el momento; para que con los contadores utilizados se comparen segun las reglas del juego 
 * para asi de acuerdo a esta devolver el respectivo valor por un return
 */
public class Blackjack {
	
static int contj=0,contj2=0;
static int contd=0,contd2=0;

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
            int a=0,a2=0;
            LinkedList<Integer> listj = new LinkedList<Integer>();
            LinkedList<Integer> listd = new LinkedList<Integer>();
            LinkedList<Integer> listdf = new LinkedList<Integer>();
            
 
		System.out.println("Bienvenido al blackjack");
                System.out.println("Presione enter para empezar el juego");
                sc.nextLine();
                carta1=aleatorio.nextInt(13)+1;
                carta2=aleatorio1.nextInt(13)+1;
                listj.add(carta1);
                listj.add(carta2);
                System.out.println("Las cartas que recibise son:");
                imprimirCartas(listj);//Imprime las cartas
                System.out.println();//Salto de línea
                carta1=tamañodelacarta(carta1);
                carta2=tamañodelacarta(carta2);
                
                if(carta1==1||carta2==1) {
                	if(carta1==1&&carta1+carta2+10<=21) {
            			carta1=11;
            			contj++;
            		}
                	if(carta2==1&&carta1+carta2+10<=21) {
            			carta2=11;
            			contj++;
            		} 
                	
                }
         
                jugador = carta1 + carta2;

                System.out.println("La suma de estas cartas es de "+jugador);
                
                
                
                carta1=aleatorio.nextInt(13)+1;
                carta2=aleatorio1.nextInt(13)+1;
               
                listdf.add(carta1);
                listdf.add(carta2);
                
                listd.add(carta1);
                System.out.println("Las cartas que tiene el repartidor son:");
                imprimirCartas(listd);//Imprime las cartas
                System.out.print("X");
                System.out.println("");//Salto de línea
                carta1=tamañodelacarta(carta1);
                carta2=tamañodelacarta(carta2);
                
                
                if(carta1==1||carta2==1) {
                	
                		if(carta1==1&&carta1+carta2+10<=21) {
                			carta1=11;
                			contd++;
                		}
                		if(carta2==1&&carta1+carta2+10<=21) {
                			carta2=11;
                			contd++;
                		}       	
                }
                numJ=2;
                System.out.println("La suma de las cartas del repartidor son "+carta1+ " y una carta oculta");
                repartidor = carta1 + carta2;
                repartidor1= carta1;
                numR=2;
                
                
                System.out.println("Si deseas otra carta presiona 1 si ya no quieres mas cartas presiona 2");
                op = Utilidades.IntInput();
                while(op != 2){
                	
                    carta2=aleatorio1.nextInt(13)+1;
                    listj.add(carta2);
                    System.out.println("Las cartas que recibise son:");
                    imprimirCartas(listj);//Imprime las cartas
                    System.out.println();//Salto de línea
                    carta2=tamañodelacarta(carta2);
                    
                    if(carta2==1&&carta2+jugador+10<=21) {
                    	carta2=11;
                    	contj++;
                    }
                    
                    jugador = carta2 + jugador;
                    jugador=comprobarCartasj(listj, jugador);
                    numJ++;
                            
                    if(repartidor >= 17){
                        System.out.println("El repartidor no toma mas cartas");
                    }else{
                        carta1=aleatorio1.nextInt(13)+1;
                        listdf.add(carta1);
                        listd.add(carta1);
                        System.out.println("El repartidor toma otra carta, las cartas que tiene el repartidor son:");
                        imprimirCartas(listd);//Imprime las cartas
                        System.out.print("X");
                        System.out.println("");//Salto de línea
                        carta1=tamañodelacarta(carta1);
                        
                        	
                    		if(carta1==1&&carta1+repartidor+10<=21) {
                    			carta1=11;
                    			contd++;
                    		}
                    	     	
                    
                        repartidor1= carta1+repartidor1;
                        numR++;
                        System.out.println("La suma de las cartas del repartidor son "+repartidor1+ " y una carta oculta, lleva en total "+numR+" cartas");
                        repartidor = carta1 +repartidor;
                        repartidor=comprobarCartasd(listdf, repartidor);
                        
                    }
                    
                    System.out.println("La suma de tus cartas es de "+jugador+" llevas "+numJ+" cartas");
                    System.out.println("Si deseas otra carta presiona 1 si ya no quieres mas cartas presiona 2");
                    op = Utilidades.IntInput();
                    
                }
                while(repartidor<17){
                    
                    carta1=aleatorio1.nextInt(13)+1;
                    listdf.add(carta1);
                    listd.add(carta1);
                    System.out.println("El repartidor toma otra carta, las cartas que tiene el repartidor son:");
                    imprimirCartas(listd);//Imprime las cartas
                    System.out.print("X");
                    System.out.println("");//Salto de línea
                    carta1=tamañodelacarta(carta1);
                  
                    	
                		if(carta1==1&&carta1+repartidor+10<=21) {
                			carta1=11;
                			contd++;
                		}
                	     	
                    
                    repartidor1= carta1+repartidor1;
                    numR++;
                    System.out.println("La suma de las cartas del repartidor son "+repartidor1+ " y una carta oculta, lleva en total "+numR+" cartas");
                    repartidor = carta1 +repartidor;
                    repartidor=comprobarCartasd(listdf, repartidor);
                    
                
                }
                System.out.println("Tus cartas son:");
                imprimirCartas(listj);//Imprime las cartas
                System.out.println();//Salto de línea
                System.out.println("El valor de tus cartas es de "+jugador+ " con "+numJ+" cartas");
                
                
                System.out.println("Las cartas del repartidor son");
                imprimirCartas(listdf);//Imprime las cartas
                System.out.println();//Salto de línea
                System.out.println("La suma de las cartas del repartidor "+repartidor+" con "+numR+" cartas");
                if((jugador > repartidor) && (jugador ==21) && (numJ==2) ){
                    System.out.println("Felicidades ganaste con BlackJack ");
                    win = true;
                }
                else if((jugador > repartidor) && (jugador <=21)){
                     System.out.println("Felicidades ganaste");
                        win = true;
                }else if((repartidor > 21) && (jugador <= 21) ){
                    System.out.println("Felicidades ganaste");
                    win = true;
                
             
                }else if((repartidor==jugador) ){
                    System.out.println("Felicidades ganaste por quedar en empate");
                    win = true;
                
             
                }
                else{
                    System.out.println("Lo siento perdiste");
                    win = false;
                }
		return win;
	}
	 public static void imprimirCartas(List<Integer> lista){//IMPRIME LAS CARTAS QUE LA IDENTIDAD POSEE
		 int valor; 
		
		 for(int i=0; i<lista.size();i++) {
	        	valor=lista.get(i);
	        	switch(valor) {
	        	case 1: 
	        		System.out.print("A ");
	        		break;
	        	case 2: 
	        		System.out.print("2 ");
	        		break;
	        	case 3: 
	        		System.out.print("3 ");
	        		break;
	        	case 4: 
	        		System.out.print("4 ");
	        		break;
	        	case 5: 
	        		System.out.print("5 ");
	        		break;
	        	case 6: 
	        		System.out.print("6 ");
	        		break;
	        	case 7: 
	        		System.out.print("7 ");
	        		break;
	        	case 8: 
	        		System.out.print("8 ");
	        		break;
	        	case 9: 
	        		System.out.print("9 ");
	        		break;
	        	case 10: 
	        		System.out.print("10 ");
	        		break;
	        	case 11: 
	        		System.out.print("J ");
	        		break;
	        	case 12: 
	        		System.out.print("Q ");
	        		break;
	        	case 13: 
	        		System.out.print("K ");
	        		break;    	
	        	}
	        }
	    }
	    
	 public static int tamañodelacarta(int carta) {//Reduce J, Q ,K A VALOR DE 10 USUAL
		 if(carta==11) {
			 carta=10;
		 }
		 if(carta==12) {
			 carta=10;
		 }
		 if(carta==13) {
			 carta=10;
		 }
		 return carta;
	 }
	 public static int comprobarCartasj(List<Integer> lista, int persona){//Regresa el valor de 11 del As a 1 en caso de que exista
		 int valor; 
		
		 for(int i=0; i<lista.size();i++) {
	        	valor=lista.get(i);
	        	if(valor==1&&persona>21&&contj>contj2) {
	        		persona= persona-10;
	        		contj2++;
	        	}
	       
	        	
	        }
		 return persona;
	    }
	 public static int comprobarCartasd(List<Integer> lista, int persona){//Regresa el valor de 11 del As a 1 en caso de que exista
		 int valor; 
		
		 for(int i=0; i<lista.size();i++) {
	        	valor=lista.get(i);
	        	if(valor==1&&persona>21&&contd>contd2) {
	        		persona= persona-10;
	        		contd2++;
	        	}
	       
	        	
	        }
		 return persona;
	    }
	 
	
}