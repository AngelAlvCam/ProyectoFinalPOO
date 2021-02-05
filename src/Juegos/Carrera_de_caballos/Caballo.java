package Juegos.Carrera_de_caballos;

import java.util.Hashtable;

/**
 * Esta clase representa a un caballo que correrá en la carrera de caballos. 
 * @author Flutt
 *
 */
public class Caballo extends Thread{
	
	/**
	 * Variable estática que permite conocer el puesto en que llegó cada caballo involucrado
	 * en la carrera.
	 * Debe ser inicializada en 1 tras cada ejecución de la carrera.
	 */
	private static int posicion = 1;
	
	/**
	 * Variable de instancia que permite conocer la magnitud del recorrido realizado por cada
	 * caballo de manera individual.
	 */
	private int conteo = 0;
	
	/**
	 * Variable estática que representa el nombre del caballo que el usuario seleccionó para apostar
	 * a favor.
	 */
	private static String seleccionado;
	
	/**
	 * Colección de tipo "Hashtable" con clave enteras y objetos "String" que permite conocer el orden
	 * de llegada de cada caballo a la meta.
	 */
	private static Hashtable<Integer, String> aux = new Hashtable<Integer, String>();
	
	/**
	 * Constructor de la clase "Caballo" con un sólo argumento.
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
