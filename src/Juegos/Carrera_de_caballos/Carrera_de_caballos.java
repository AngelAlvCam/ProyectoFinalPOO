package Juegos.Carrera_de_caballos;

import java.util.Scanner;

import Principal.Utilidades;

/**
 * Este clase permite llevar a cabo el juego de carrera de caballos con ayuda de la clase
 * "Caballo" proporcionada en el mismo paquete.
 * En esta clase se definen dos métodos, uno de clase que ejecuta la carrera en sí, y uno
 * estático con el cual se realiza la llamada al método de clase mencionado desde un ménu externo. 
 * @author Flutt
 *
 */
public class Carrera_de_caballos {
	
	/**
	 * Método de clase que ejecuta la carrera de caballos, en éste se inicializan 
	 * 4 objetos de la clase "Caballo" (que en esencia son hilos) y se ejecutan con su método "start".
	 * Se encarga de determinar si el caballo seleccionado por el usuario ganó la carrera o no. 
	 * @param nombre Un objeto de la clase "String" que denota el nombre del caballo seleccionado por el
	 * usuario.
	 * @return Un valor booleano de "true" si el caballo seleccionado por el usuario ganó la carrera, "false"
	 * en caso contrario.
	 */
	private boolean JugarAux(String nombre) {
		Caballo c1 = new Caballo(nombre);
		Caballo c2 = new Caballo("c2");
		Caballo c3 = new Caballo("c3");
		Caballo c4 = new Caballo("c4");
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		
		/*
		 * Con este bloque de instrucciones se establece un "tope" en el hilo default para que
		 * no se ejecuten las instrucciones siguientes hasta que concluya la ejecución de todos los hilos.
		 */
		try {
			c1.join();
			c2.join();
			c3.join();
			c4.join();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException");
		}
		
		/*
		 * En este bloque de instrucciones se determina si el caballo seleccionado por el usuario ganó o perdió
		 * en función del nombre del caballo del usuario y el caballo con clave "1" en el hashtable de posiciones.
		 */
		System.out.println(Caballo.getPosiciones().toString());
		if (Caballo.getPosiciones().get(1).equals(nombre)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Método estático que permite la llamada al juego desde algún menú de usuario. 
	 * Dentro de este método se crea una instancia de "Carrera_de_caballos" que llama al método
	 * "jugarAux", con el cual se efectúa la carrera.
	 * Con ayuda de este método se simplifica la lectura de los códigos de menú.
	 * 
	 * En este método se ingresa por parte del usuario el nombre del caballo por el cual se apuesta y
	 * comunica a algún método externo si el cabllo del usuario gan´o perdió la carrera.
	 * @return Un valor booleano de "true" si el método "jugarAux" de la instancia interna retorna "true", "false"
	 * en caso contrario. Se concluye con que este método es un comunicador entre el método "jugarAux" y algún
	 * menú de usuario.
	 */
	public static boolean Jugar() {
		System.out.println("Ingrese el nombre del caballo por el que apuesta: ");
		String nombre = Utilidades.StringInput();
		Carrera_de_caballos aux = new Carrera_de_caballos();
		if (aux.JugarAux(nombre) == true) {
			return true;
		} else {
			return false;
		}
	}
}
