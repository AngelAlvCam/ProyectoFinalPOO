package Usuarios;

import java.io.Serializable;

import Usuarios.Interfaces_Usuarios.Jugar;

/**
 * Clase abstracta que representa, conceptualmente, a un usuario del casino.
 * Implementa a las interfaces "Serializable" y "Jugar", por lo tanto, las subclases de ésta
 * también.
 * @author Flutt
 */
public abstract class Usuario implements Serializable, Jugar {
	/**
	 * Atributo entero que denota el número de fichas enteras que posee un usuario.
	 */
	private int fichas;
	
	/**
	 * Atributo String que denota el identificador de acceso de un usuario.
	 */
	private String ID_Usuario;
	
	/**
	 * Atributo String que denota el nombre del usuario.
	 */
	private String nombre;
	
	/**
	 * Atributo String que denota el apellido paterno de un usuario.
	 */
	private String apellido_P;
	
	/**
	 * Atributo String que denota el apellido materno de un usuario.
	 */
	private String apellido_M;
	
	/**
	 * Atributo String que denota la contraseña de un usuario.
	 */
	private String contrasena;
	
	/**
	 * Constructor de la clase "Abstracta", aunque se supone no puede haber instancias de una clases abstracta,
	 * este constructor obliga a settear los atributos designados en éste.
	 * @param ID_Usuario Un objeto String que denota el identificador de acceso del usuario
	 * @param nombre Un objeto String que denota el nombre del usuario
	 * @param apellido_P Un objeto String que denota el apellido paterno del usuario
	 * @param apellido_M Un objeto String que denota el apellido materno del usuario
	 * @param contrasena Un objeto String que denota la contraseña del usuario
	 * @param fichas Un valor entero que denota la cantidad de fichas asignadas al usuario 
	 */
	protected Usuario(String ID_Usuario, String nombre, String apellido_P, 
			String apellido_M, String contrasena, int fichas) {
		this.ID_Usuario = ID_Usuario;
		this.nombre = nombre;
		this.apellido_P = apellido_P;
		this.apellido_M = apellido_M;
		this.contrasena = contrasena;
		this.fichas = fichas;
	}
	
	/*
	 * Definición de los métodos getters
	 */
	public int getFichas() {
		return fichas;
	}
	public String getID_Usuario() {
		return ID_Usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido_P() {
		return apellido_P;
	}
	public String getApellido_M() {
		return apellido_M;
	}
	public String getContrasena() {
		return contrasena;
	}

	/*
	 * Definición de los métodos setters
	 */
	public void setFichas(int fichas) {
		this.fichas = fichas;
	}
	public void setID_Usuario(String iD_Usuario) {
		ID_Usuario = iD_Usuario;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido_P(String apellido_P) {
		this.apellido_P = apellido_P;
	}
	public void setApellido_M(String apellido_M) {
		this.apellido_M = apellido_M;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		String aux = nombre + ", " + apellido_P + ", " + apellido_M + ", " + 
				ID_Usuario + ", " + fichas + ", " + contrasena + ", ";
		return aux;
	}

}