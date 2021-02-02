package Usuarios.Interfaces_Usuarios;

public interface Jugar {
	void MenuJugar();
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