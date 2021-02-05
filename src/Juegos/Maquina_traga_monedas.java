/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import java.util.Random;
import java.util.Scanner;

/** @author crismartinez Clase encargada de representar el juego clasico de casino de la ruleta el cual a traves de tres randoms 
 * realizados al mismo tiempo con diferentes limites cada uno, se comparan los valores entre si, para verificar que estos 
 * sean iguales o diferentes y deacuerdo a esa comparacion se determina si se gana o pierde en este juego clasico.
 */

public class Maquina_traga_monedas {
    Scanner sc = new Scanner(System.in);
    Random aleatorio = new Random();
    Random aleatorio1 = new Random();
    Random aleatorio2 = new Random();
    
    private boolean JugarAux(){
    
        boolean win = false;
        int op = 0;
        int dib;
        int dib1;
        int dib2;
        System.out.println("Comienza el juego");
        
        do{
            System.out.println("Pulsa enter para hacer girar las maquina");
            sc.nextLine();
            dib = aleatorio.nextInt(4);
            dib1 = aleatorio1.nextInt(5);
            dib2= aleatorio2.nextInt(6);
            imprimir(dib, dib1, dib2);
            if((dib == dib1) && (dib == dib2) && (dib1 == dib2)){
                System.out.println("Felicidades ganaste");
                win = true;
                op =1;
                
            }else{
                System.out.println("Lo siento perdiste");
                win = false;
                op = 1;
            }
            System.out.println("Pulse enter para continuar");
            sc.nextLine();
     
            
        }while(op != 1);
    return win;
}
    
    public static boolean Jugar() {
    	Maquina_traga_monedas mtmAux = new Maquina_traga_monedas();
    	if (mtmAux.JugarAux() == true) {
    		return true;
    	} else {
    		return false;
    	}
    }
    /** Funcion que se encarga de imprimir en pantalla los valores resultantes de la ruleta, compara que todos los valores
     * sean iguales entre si, una ves hecho esto a traves de otro random se escoge una cadena de caracteres que se imprimira en 
     * pantalla, en caso de que los valores no sean iguales con el mismo random se escoge una cadena de caracteres en la cual todos
     * los caracteres son diferentes
    */
    private void imprimir(int p1, int p2, int p3){
        int imagen = aleatorio.nextInt(4);
        if((p1 == p2) && (p1 == p3) && (p2 == p3)){
                if(imagen == 0){
                    System.out.println("[ 7         7           7]");
                }else if(imagen == 1){
                    System.out.println("[ XD         XD           XD]");
                }else if(imagen == 2){
                    System.out.println("[ ^-^         ^-^           ^-^]");
                }else if(imagen ==3){
                    System.out.println("[ :P         :P           :P]");
                }       
        }else{
                if(imagen == 0){
                    System.out.println("[ 7         ^-^           7]");
                }else if(imagen == 1){
                    System.out.println("[ XD         7           :P]");
                }else if(imagen == 2){
                    System.out.println("[ ^-^         :P           XD]");
                }else if(imagen ==3){
                    System.out.println("[ 7         :P           ^-^]");
                }    
        }
    }

    
}

