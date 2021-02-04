/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ruleta {
    List<Integer> Rojo = new ArrayList();
    List<Integer> Negro = new ArrayList();
    int ruleta;
    Random aleatorio = new Random();
    Scanner sc = new Scanner(System.in);
    int op = 4;
    
    private boolean JugarAux(){
        boolean win = false;
        System.out.println("Bienvenido a su ruleta preferida");
        System.out.println("Comienza el juego");
        do{
            System.out.println("Ingrese su apuesata");
            System.out.println("Como desea jugar en nuestra ruleta por numeros o por color");
            System.out.println("1)Por numeros");
            System.out.println("2)Por colores");
            System.out.println("3)Por area");
            System.out.println("4)Salir");
            op = sc.nextInt();
            switch(op){
                case 1:
                    win = juegoNumeros(win);
                   System.out.println("Pulse enter para continuar");
                    sc.nextLine();
                    break;
                case 2:
                    win = juegoColores(win);
                    System.out.println("Pulse enter para continuar");
                    sc.nextLine();
                    break;
                case 3:
                    win = juegoArea(win);
                    System.out.println("Pulse enter para continuar");
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("Gracias por jugar");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
            
        }while(op != 4);
        return win;
    }
    
    public static boolean Jugar() {
    	Ruleta ruletaAux = new Ruleta();
    	if (ruletaAux.JugarAux() == true) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    
    private boolean juegoNumeros(boolean valor){
        int num1;
        int num2;
        int num3;
        System.out.println("Seleccione la opcion que desee");
        System.out.println("Cuantos numeros desea elegir");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        op = sc.nextInt();
        switch(op){
            case 1:
                System.out.println("Cual es el numero al cual quiere apostarle");
                System.out.println("Puede seleccionar entre el 1 y el 36");
                num1 = sc.nextInt();
                ruleta = aleatorio.nextInt(36)+1;
                System.out.println("La pelotita callo en el numero "+ruleta);
                if(num1 == ruleta){
                    System.out.println("Felicidades ganaste con un solo numero");
                    valor = true;
                    
                }else{
                    System.out.println("Uy que mala suerte");
                    System.out.println("Perdiste tu apuesta");
                    valor= false;
                }
                break;
            case 2:
                System.out.println("Cuales son los numeros a los cuales quiere apostarle");
                System.out.println("Primer Numero, Puede seleccionar entre el 1 y el 36");
                num1 = sc.nextInt();
                System.out.println("Segundo Numero, Puede seleccionar entre el 1 y el 36");
                num2 = sc.nextInt();
                ruleta = aleatorio.nextInt(36)+1;
                System.out.println("La pelotita callo en el numero "+ruleta);
                if((num1 == ruleta)|| (num2 == ruleta)){
                    System.out.println("Felicidades ganaste con dos numeros");
                   valor = true;
                }else{
                    System.out.println("Uy que mala suerte");
                    System.out.println("Perdiste tu apuesta");
                    valor = false;
                }
                break;
            case 3:
                System.out.println("Cuales son los numeros a los cuales quiere apostarle");
                System.out.println("Primer Numero, Puede seleccionar entre el 1 y el 36");
                num1 = sc.nextInt();
                System.out.println("Segundo Numero, Puede seleccionar entre el 1 y el 36");
                num2 = sc.nextInt();
                System.out.println("Tercer Numero, Puede seleccionar entre el 1 y el 36");
                num3 = sc.nextInt();
                ruleta = aleatorio.nextInt(36)+1;
                System.out.println("La pelotita callo en el numero "+ruleta);
                if((num1 == ruleta)|| (num2 == ruleta) || (num3 == ruleta)){
                    System.out.println("Felicidades ganaste con tres numeros");
                   valor = true;
                }else{
                    System.out.println("Uy que mala suerte");
                    System.out.println("Perdiste tu apuesta");
                    valor = false;
                }
                break;
            default:
                System.out.println("Opcion Invalida");
        }
        return valor;
    }
        
    private boolean juegoColores(boolean valor){
        System.out.println("Seleccione el color");
        System.out.println("1)Negro");
        System.out.println("2)Rojo");
        op = sc.nextInt();
        switch(op){
            case 1:
                ruleta=aleatorio.nextInt(36)+1;
                System.out.println("La pelotita callo en el numero "+ruleta);
                if(Negro.contains(ruleta)== true){
                    System.out.println("Felicidades ganaste el numero es de color negro");
                    valor = true;
                }else{
                    System.out.println("Uy que mala suerte");
                    System.out.println("El numero en el que callo la ruleta es de color rojo");
                    valor = false;
                }
                break;
            case 2:
                ruleta=aleatorio.nextInt(36)+1;
                System.out.println("La pelotita callo en el numero "+ruleta);
                if(Rojo.contains(ruleta)== true){
                    System.out.println("Felicidades ganaste el numero es de color rojo");
                    valor = true;
                }else{
                    System.out.println("Uy que mala suerte");
                    System.out.println("El numero en el que callo la ruleta es de color negro");
                    valor = false;
                }
                break;
            default:
               System.out.println("Opcion Invalida"); 
        }
        return valor;
    }
    
    private boolean juegoArea(boolean valor){
        System.out.println("Seleccione la opcion que desee");
        System.out.println("En cual area desea jugar");
        System.out.println("En la 1");
        System.out.println("En la 2");
        System.out.println("En la 3");
        op = sc.nextInt();
        switch(op){
            case 1:
                System.out.println("El area 1 contiene los numeros del 1 al 12");
                ruleta=aleatorio.nextInt(36)+1;
                System.out.println("La pelotita callo en el numero "+ruleta);
                if((ruleta >= 1) || (ruleta <=12)){
                    System.out.println("Felicidades ganaste");
                    valor = true;
                }else{
                    System.out.println("Uy que mala suerte");
                    System.out.println("Perdiste tu apuesta");
                    valor = false;
                }
                break;
            case 2:
                System.out.println("El area 2 contiene los numeros del 13 al 24");
                ruleta=aleatorio.nextInt(36)+1;
                System.out.println("La pelotita callo en el numero "+ruleta);
                if((ruleta >= 13) || (ruleta <=24)){
                    System.out.println("Felicidades ganaste tu ganancia es de 5 veces tu apuesta");
                    valor = true;
                }else{
                    System.out.println("Uy que mala suerte");
                    System.out.println("Perdiste tu apuesta");
                    valor = false;
                }
                break;
            case 3:
                System.out.println("El area 3 contiene los numeros del 24 al 36");
                ruleta=aleatorio.nextInt(36)+1;
                System.out.println("La pelotita callo en el numero "+ruleta);
                if((ruleta >= 25) || (ruleta <=36)){
                    System.out.println("Felicidades ganaste tu ganancia es de 5 veces tu apuesta");
                    valor = true;
                }else{
                    System.out.println("Uy que mala suerte");
                    System.out.println("Perdiste tu apuesta");
                    valor = false;
                }
                break;
            default:
               System.out.println("Opcion Invalida"); 
        }
        
        return valor;
    }
    
    
    
    
        void llenandoLista(){
        Rojo.add(1);
        Negro.add(2);
        Rojo.add(3);
        Negro.add(4);
        Rojo.add(5);
        Negro.add(6);
        Rojo.add(7);
        Negro.add(8);
        Rojo.add(9);
        Negro.add(10);
        Negro.add(11);
        Rojo.add(12);
        Negro.add(13);
        Rojo.add(14);
        Negro.add(15);
        Rojo.add(16);
        Negro.add(17);
        Rojo.add(18);
        Rojo.add(19);
        Negro.add(20);
        Rojo.add(21);
        Negro.add(22);
        Rojo.add(23);
        Negro.add(24);
        Rojo.add(25);
        Negro.add(26);
        Rojo.add(27);
        Negro.add(28);
        Negro.add(29);
        Rojo.add(30);
        Negro.add(31);
        Rojo.add(32);
        Negro.add(33);
        Rojo.add(34);
        Negro.add(35);
        Rojo.add(36);

    }
}