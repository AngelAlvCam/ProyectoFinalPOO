package Usuarios.Interfaces_Usuarios;

/**
 * Esta interfaz define m�todos necesarios para efectuar el acceso general a juegos
 * por parte de todos los usuarios.
 * Es implementada por la clase abstracta "Usuario", y por lo tanto, tambi�n por todas las subclases
 * de �sta.
 * 
 * Se considera que el m�todo m�s importante de �sta inerface "MenuJugar", pues es el que permite la
 * generalizaci�n de acceso a men�s.  
 * 
 * 
 * 
 * @author Flutt
 *
 */
public interface Jugar {
	
	/**
	 * Este m�todo debe definir al men� de acceso a juegos de cada usuario, de tal manera que cada
	 * subclase de usuario tenga su propio men� con los juegos correspondientes.
	 */
	boolean MenuJugar();
	
	/**
	 * Este m�todo debe encargarse de verificar si una apuesta es v�lida para cada tipo de
	 * usuario.
	 * @param apuesta Un valor entero que denota la cantidad de fichas que se desean apostar.
	 * @return Un valor booleano de "true" si el usuario ingres� una apuesta v�lida en funci�n de la
	 * subclase de usuario que representa; "false" en caso contrario.
	 */
	boolean Verificar_Apuesta(int apuesta);
	
	/**
	 * Este m�todo debe encargarse de sumar o restar fichas a un usuario en funci�n de si gan�
	 * o perdi� en una jugada. 
	 * @param apuesta Cantidad de fichas apostadas por el usuario.
	 * @param win Valro booleano que denota s� se gan� o perdi� en un juego, con un "true" o un
	 * "false" respectivamente.
	 */
	void Agregar_Fichas(int apuesta, boolean win);
}