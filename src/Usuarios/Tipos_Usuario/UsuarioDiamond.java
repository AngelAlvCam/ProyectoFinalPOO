package Usuarios.Tipos_Usuario;

import Usuarios.Usuario;
import java.util.Hashtable;
import java.util.Scanner;
import Juegos.*;

/**
 * Este tipo de usuario tiene acceso a todos los juegos sin restricción
 * alguna, no tiene restricciónes en cuanto a sus apuesta (aplica la idea
 * de "todo o nada"), y también recibe el mayor bono de victoria. 
 * S e consideró un bono de victoria de n.  
 * @author Flutt
 *
 */
public class UsuarioDiamond extends Usuario{
	
	public UsuarioDiamond(String ID_Usuario, String nombre, String apellido_P, 
			String apellido_M, String contrasena) {
		super(ID_Usuario, nombre, apellido_P, apellido_M, contrasena, 500);
	}
	
	public UsuarioDiamond() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void MenuJugar() {
		System.out.println("Menu diamond");
		/*
		 * Aquí va el menú de juegos para los usuarios tipo "Diamond"
		 */
		Dados.DAD();
		Carrera_de_caballos.CDC();
		Blackjack.BJ();
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
		UsuarioDiamond aux = new UsuarioDiamond(id, nombre, apellido_P, apellido_M, contrasena);
		Usuarios.put(id, aux);
	}
}
