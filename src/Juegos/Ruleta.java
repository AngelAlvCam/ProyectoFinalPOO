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

/** @author crismartinez Clase encargada del juego de ruleta, como la ruleta americana, esta tiene tres opciones de juego 
 * lo cual se refiere, a jugar por numeros prediciendo cual valor saldra, por colores para lo cual se manejan listas y comparandolo con 
 * el color del valor encontrado y por area en donde el valor predicho tiene que estar dentro de un rango determinado de cada area,
 * el juego consiste en determinar el valor o color el cual saldra en la ruleta, esto se hace a traves de las listas y los
 * parametros asignados
 *
 * 
 */

public class Ruleta {
    List<Integer> Rojo = new ArrayList();
    List<Integer> Negro = new ArrayList();
    int ruleta;
    Random aleatorio = new Random();
    Scanner sc = new Scanner(System.in);
    int op =0;
    
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
                    op=4;
                    break;
                case 2:
                    win = juegoColores(win);
                    System.out.println("Pulse enter para continuar");
                    sc.nextLine();
                    op=4;
                    break;
                case 3:
                    win = juegoArea(win);
                    System.out.println("Pulse enter para continuar");
                    sc.nextLine();
                    op=4;
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
    
    /** Funcion para jugar a traves de un numero, en esta modalida tienes la opcion de escoger entre uno, dos o tres
     * numeros a los cuales apostar, a traves de un random se genera el numero de la ruleta y se compara con los valores 
     * que el usuario escogio esta es la modalidad de juego que menos probabilidad de ganar se tiene, debido 
     * a que dependiendo de la opcion que se escogio la maxima probabilidad esd e 3/36.
    
    
    */
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
    /** Funcion para jugar en la ruleta por colores, escoges el color al cual le apostaras y generando un random, a traves de este 
     * se compara si este pertenece a la lista de color escogido, esta es una de las formas de juego que tiene mas probabilidades 
     * de ganar debido a que solo existen dos posibles resulyados con una probabilida de similar entre ellos 
    */  
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
    
    /** Funcion para realizar el juego por area de la ruleta, en la cual se te da la opcion de escoger el area en la cual
     * jugaras, la ruleta a traves de un random genera el numero de esta y lo compara con los valores permitidos dentro de 
     * area
     */
    
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
                if((ruleta >= 1) && (ruleta <=12)){
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
                if((ruleta >= 13) && (ruleta <=24)){
                    System.out.println("Felicidades ganaste tu ganancia");
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
                if((ruleta >= 25) && (ruleta <=36)){
                    System.out.println("Felicidades ganaste tu ganancia");
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
    
   /** Funcion creada para asignar el valor a la correspondiente lista de acuerdo al color a la cual pertenece este,
    * el valor va del 1 al 36, estos pueden pertenecer a valores negros o rojos
   */ 
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
