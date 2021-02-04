/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author miguelmartinez
 */
public class Dados {
    
    //Random aleatorio = new Random();
    //Random aleatorio1 = new Random();
    
    public static boolean Jugar() {
        System.out.println("Este es un juego de dados");
        Scanner sc = new Scanner(System.in);
        Random aleatorio = new Random();
        Random aleatorio1 = new Random();
        int op =0;
        int dado1;
        int dado2;
        int punto = 0;
        boolean valor = false;
        System.out.println("Comienza el juego");
        
        do{
            System.out.println("Se lanzan los dados");
            dado1 = aleatorio.nextInt(6)+1;
            dado2 = aleatorio1.nextInt(6)+1;
            int resultado = dado1 +dado2;
            System.out.println("El valor de los dados fue: "+dado1+ " y "+dado2 );
            System.out.println("la suma de estos es "+resultado);
            if((resultado == 7) || (resultado == 11)){
                System.out.println("Felicidades ganaste");
                op = 5;
                valor=true;
            }else if((resultado == 2) || (resultado == 3) || (resultado ==12)){
                System.out.println("Perdiste la apuesta");
                op=5;
                valor=false;
            }else{
                punto = punto +1;
                System.out.println("Acumulaste un punto, llevas "+punto+" puntos");
            }
            if(punto==7){
                System.out.println("Has acumulado los punto necesarios para ganar");
                op = 5;
                valor=true;
            }
            System.out.println("Pulse enter para continuar ");
             sc.nextLine();
            
            
        }while(op != 5);
		return valor;
        
    }
}
