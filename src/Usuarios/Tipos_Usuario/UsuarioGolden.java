package Usuarios.Tipos_Usuario;

import Usuarios.Usuario;
import Juegos.*;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Este tipo de usuario tiene acceso a todos los juegos posibles, pero no
 * pues apostar todas sus fichas en una única jugada; además, recibe un bono
 * medio de fichas por victoria. Es decir, si al jugar apuesta n fichas y gana,
 * obtendrá n/2 fichas como bono.
 * 
 * @author Flutt
 *
 */
public class UsuarioGolden extends Usuario{
	
	public UsuarioGolden(String ID_Usuario, String nombre, String apellido_P, 
			String apellido_M, String contrasena) {
		super(ID_Usuario, nombre, apellido_P, apellido_M, contrasena, 350);
	}
	
	public UsuarioGolden() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void MenuJugar() {
		System.out.println("Menu golden");
		/*
		 * Aquí va el menú de juegos para los usuarios tipo "Golden"
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
		UsuarioGolden aux = new UsuarioGolden(id, nombre, apellido_P, apellido_M, contrasena);
		Usuarios.put(id, aux);
	}
}
