package Juegos.Carrera_de_caballos;

import java.util.Hashtable;

/**
 * Esta clase representa a un caballo que correrá en la carrera de caballos. Se trata de una
 * implementación especial de hilos. 
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
	 * Colección de tipo "Hashtable" con clave enteras y objetos "String" que permite conocer el orden
	 * de llegada de cada caballo a la meta.
	 */
	private static Hashtable<Integer, String> aux = new Hashtable<Integer, String>();
	
	/**
	 * Constructor de la clase "Caballo" con un sólo argumento.
	 * @param nombre Un objeto de la clase "String" que denota el nombre asignado al caballo.
	 */
	Caballo(String nombre) {
		this.setName(nombre);
		if (posicion != 1) { 
			posicion = 1;
		}
		if (aux.isEmpty() != true) {
			aux.clear();
		}
	}
	
	/**
	 * Sobreescritura del método "run" dado por la interfaz "Runnable" que es implmentada en la clase
	 * "Thread" que hereda a ésta clase.
	 * En este método se definen los pasos que realiza cada objeto de la clase que representa a un caballo.
	 */
	@Override
	public void run(){
		while (conteo < 2000) {
			conteo++;
		//	System.out.println(this.getName() + ": " + conteo);
		}
		aux.put(posicion++, this.getName());
	}
	
	/**
	 * Método estático que retorna al hashtable que denota las posiciones en las que los caballos
	 * concluyeron con la carrera.
	 * @return Un objeto de la clase "Hashtable" con claves enteras y obejetos "String", que representan
	 * las posiciones en las que llegaron los caballos y los nombres de los caballos, respectivamente.
	 */
	static Hashtable<Integer, String> getPosiciones(){
		return aux;
	}
}
