package Juegos.Carrera_de_caballos;

import java.util.Hashtable;

/**
 * Esta clase representa a un caballo que correr� en la carrera de caballos. 
 * @author Flutt
 *
 */
public class Caballo extends Thread{
	
	/**
	 * Variable est�tica que permite conocer el puesto en que lleg� cada caballo involucrado
	 * en la carrera.
	 * Debe ser inicializada en 1 tras cada ejecuci�n de la carrera.
	 */
	private static int posicion = 1;
	
	/**
	 * Variable de instancia que permite conocer la magnitud del recorrido realizado por cada
	 * caballo de manera individual.
	 */
	private int conteo = 0;
	
	/**
	 * Variable est�tica que representa el nombre del caballo que el usuario seleccion� para apostar
	 * a favor.
	 */
	private static String seleccionado;
	
	/**
	 * Colecci�n de tipo "Hashtable" con clave enteras y objetos "String" que permite conocer el orden
	 * de llegada de cada caballo a la meta.
	 */
	private static Hashtable<Integer, String> aux = new Hashtable<Integer, String>();
	
	/**
	 * Constructor de la clase "Caballo" con un s�lo argumento.
	 * @param nombre Un objeto de la clase "String" que denota el nombre asignado al caballo.
	 */
	public Caballo(String nombre) {
		this.setName(nombre);
		if (posicion != 1) {
			posicion = 1;
		}
		if (aux.isEmpty() != true) {
			aux.clear();
		}
	}
	
	@Override
	public void run(){
		while (conteo < 2000) {
			conteo++;
		//	System.out.println(this.getName() + ": " + conteo);
		}
		aux.put(posicion++, this.getName());
	}
	
	public static void setSeleccionado(String nombre) {
		seleccionado = nombre;
	}
	
	public static Hashtable<Integer, String> getPosiciones(){
		return aux;
	}
}
