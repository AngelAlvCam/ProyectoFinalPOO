package Usuarios;

import java.io.Serializable;

import Usuarios.Interfaces_Usuarios.Jugar;

/**
 * Clase abstracta que representa, conceptualmente, a un usuario del casino.
 * @author Flutt
 *
 */
public abstract class Usuario implements Jugar, Serializable {
	private int fichas;
	private String ID_Usuario;
	private String nombre;
	private String apellido_P;
	private String apellido_M;
	private String contrasena;
	
	protected Usuario(String ID_Usuario, String nombre, String apellido_P, 
			String apellido_M, String contrasena, int fichas) {
		this.ID_Usuario = ID_Usuario;
		this.nombre = nombre;
		this.apellido_P = apellido_P;
		this.apellido_M = apellido_M;
		this.contrasena = contrasena;
		this.fichas = fichas;
	}
	
	protected Usuario() {};
	
	protected int getFichas() {
		return fichas;
	}
	public String getID_Usuario() {
		return ID_Usuario;
	}
	protected String getNombre() {
		return nombre;
	}
	protected String getApellido_P() {
		return apellido_P;
	}
	protected String getApellido_M() {
		return apellido_M;
	}
	public String getContrasena() {
		return contrasena;
	}

	@Override
	public String toString() {
		String aux = nombre + ", " + apellido_P + ", " + apellido_M + ", " + 
				ID_Usuario + ", " + fichas + ", " + contrasena + ", ";
		return aux;
	}
}