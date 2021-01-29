package Usuarios.Tipos_Usuario;

import Usuarios.Usuario;

import java.util.Hashtable;
import java.util.Scanner;

import Juegos.*;

/**
 * Este tipo de usaurio tiene acceso restringido a todos los juegos, y no puede
 * apostar más de la mitad de sus fichas en una única jugada; además tiene el
 * bono de victoria más pequeño. Se consideró un bono de victoria de n/4 por cada
 * jugada.
 * @author Flutt
 *
 */
public class UsuarioSilver extends Usuario{
	
	public UsuarioSilver(String ID_Usuario, String nombre, String apellido_P, 
			String apellido_M, String contrasena) {
		super(ID_Usuario, nombre, apellido_P, apellido_M, contrasena, 200);
	}
	
	public UsuarioSilver() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void MenuJugar() {
		System.out.println("Menu silver");
		/*
		 * Aquí va el menú de juegos para los usuarios tipo "Silver"
		 */
	}

	@Override
	public boolean Verificar_Apuesta(int apuesta) {
		return true;
	}
	
	public static void CrearUsuario(Hashtable<String, Usuario> Usuarios) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el nombre del usuario: ");
		String nombre = sc.nextLine();
		System.out.println("Ingrese el apellido paterno del usuario: ");
		String apellido_P = sc.nextLine();
		System.out.println("Ingrese el apellido materno del usuario: ");
		String apellido_M = sc.nextLine();
		System.out.println("Ingrese un identificador");
		String id = sc.nextLine();
		while (Usuarios.containsKey(id) == true) {
			System.out.println("El identificador está ocupado, ingrese un identificador diferente");
			id = sc.nextLine();			
		}
		System.out.println("Ingrese una contraseña: ");
		String contrasena = sc.nextLine();
		UsuarioSilver aux = new UsuarioSilver(id, nombre, apellido_P, apellido_M, contrasena);
		Usuarios.put(id, aux);
	}
}
