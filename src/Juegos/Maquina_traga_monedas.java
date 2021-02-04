/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import java.util.Random;
import java.util.Scanner;

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
            dib1 = aleatorio1.nextInt(4);
            dib2= aleatorio2.nextInt(4);
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
