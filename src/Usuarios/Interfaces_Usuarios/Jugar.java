package Usuarios.Interfaces_Usuarios;

public interface Jugar {
	void MenuJugar();
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