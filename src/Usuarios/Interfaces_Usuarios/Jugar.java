package Usuarios.Interfaces_Usuarios;

/**
 * Esta interfaz define métodos necesarios para efectuar el acceso general a juegos
 * por parte de todos los usuarios.
 * Es implementada por la clase abstracta "Usuario", y por lo tanto, también por todas las subclases
 * de ésta.
 * 
 * Se considera que el método más importante de ésta inerface "MenuJugar", pues es el que permite la
 * generalización de acceso a menús.  
 * 
 * 
 * 
 * @author Flutt
 *
 */
public interface Jugar {
	
	/**
	 * Este método debe definir al menú de acceso a juegos de cada usuario, de tal manera que cada
	 * subclase de usuario tenga su propio menú con los juegos correspondientes.
	 */
	boolean MenuJugar();
	
	/**
	 * Este método debe encargarse de verificar si una apuesta es válida para cada tipo de
	 * usuario.
	 * @param apuesta Un valor entero que denota la cantidad de fichas que se desean apostar.
	 * @return Un valor booleano de "true" si el usuario ingresó una apuesta válida en función de la
	 * subclase de usuario que representa; "false" en caso contrario.
	 */
	boolean Verificar_Apuesta(int apuesta);
	
	/**
	 * Este método debe encargarse de sumar o restar fichas a un usuario en función de si ganó
	 * o perdió en una jugada. 
	 * @param apuesta Cantidad de fichas apostadas por el usuario.
	 * @param win Valro booleano que denota sí se ganó o perdió en un juego, con un "true" o un
	 * "false" respectivamente.
	 */
	void Agregar_Fichas(int apuesta, boolean win);
}