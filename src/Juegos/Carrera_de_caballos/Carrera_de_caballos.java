package Juegos.Carrera_de_caballos;

import java.util.Scanner;

import Principal.Utilidades;

/**
 * Este clase permite llevar a cabo el juego de carrera de caballos con ayuda de la clase
 * "Caballo" proporcionada en el mismo paquete.
 * En esta clase se definen dos m�todos, uno de clase que ejecuta la carrera en s�, y uno
 * est�tico con el cual se realiza la llamada al m�todo de clase mencionado desde un m�nu externo. 
 * @author Flutt
 *
 */
public class Carrera_de_caballos {
	
	/**
	 * M�todo de clase que ejecuta la carrera de caballos, en �ste se inicializan 
	 * 4 objetos de la clase "Caballo" (que en esencia son hilos) y se ejecutan con su m�todo "start".
	 * Se encarga de determinar si el caballo seleccionado por el usuario gan� la carrera o no. 
	 * @param nombre Un objeto de la clase "String" que denota el nombre del caballo seleccionado por el
	 * usuario.
	 * @return Un valor booleano de "true" si el caballo seleccionado por el usuario gan� la carrera, "false"
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
		 * no se ejecuten las instrucciones siguientes hasta que concluya la ejecuci�n de todos los hilos.
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
		 * En este bloque de instrucciones se determina si el caballo seleccionado por el usuario gan� o perdi�
		 * en funci�n del nombre del caballo del usuario y el caballo con clave "1" en el hashtable de posiciones.
		 */
		System.out.println(Caballo.getPosiciones().toString());
		if (Caballo.getPosiciones().get(1).equals(nombre)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * M�todo est�tico que permite la llamada al juego desde alg�n men� de usuario. 
	 * Dentro de este m�todo se crea una instancia de "Carrera_de_caballos" que llama al m�todo
	 * "jugarAux", con el cual se efect�a la carrera.
	 * Con ayuda de este m�todo se simplifica la lectura de los c�digos de men�.
	 * 
	 * En este m�todo se ingresa por parte del usuario el nombre del caballo por el cual se apuesta y
	 * comunica a alg�n m�todo externo si el cabllo del usuario gan�o perdi� la carrera.
	 * @return Un valor booleano de "true" si el m�todo "jugarAux" de la instancia interna retorna "true", "false"
	 * en caso contrario. Se concluye con que este m�todo es un comunicador entre el m�todo "jugarAux" y alg�n
	 * men� de usuario.
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
