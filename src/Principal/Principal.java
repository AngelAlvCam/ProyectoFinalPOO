package Principal;

import Usuarios.Usuario;
import Usuarios.Tipos_Usuario.*;
import java.io.*;
import java.util.Hashtable;
import java.util.Set;
import java.util.Scanner;
import javax.swing.*;

public class Principal {

	static String nombre_Archivo = "usuarios.txt";
	
	public static void main(String[] args) {
		
		Hashtable<String, Usuario> Usuarios = new Hashtable<String, Usuario>();
		Utilidades.AbrirArchivo(nombre_Archivo, Usuarios);
		int op;
		boolean stat = true;
		
		System.out.println("¡Bienvenido!");
		while (stat) {
			System.out.println("* Menu principal *");
			System.out.println("1) Iniciar sesion");
			System.out.println("2) Crear usuario");
			System.out.println("3) Salir");
			op = Utilidades.IntInput();
			switch(op) {
			case 1:
				IniciarSesion(Usuarios);
				break;
			case 2:
				RegistrarUsuario(Usuarios);
				Utilidades.ActualizarArchivo(nombre_Archivo, Usuarios);
				break;
			case 3:
				stat = false;
				System.out.println("¡Hasta luego!");
				break;
			case 4:
				System.out.println("Opción inválida");
				break;
			}
		}
	}
	
	/**
	 * Método estático desde el cual se realizan las llamadas a los métodos estáticos de las subclases de 
	 * usuario que se encargan de la creación de usuario.
	 * @param Usuarios Una colección de la clase "Hashtable", con claves "String" y objetos de la clase
	 * "Usuario", la cual funciona como un registro de usuarios en tiempo de ejecución que posteriormente
	 * será reescrita en un archivo de texto que preserva a los usuarios registrados.
	 */
	public static void RegistrarUsuario(Hashtable<String, Usuario> Usuarios) {
		int op;
		System.out.println("* Menu de registro *");
		System.out.println("1) Usuario Diamond");
		System.out.println("2) Usuario Golden");
		System.out.println("3) Usuario Silver");
		op = Utilidades.IntInput();
		switch(op) {
		case 1: // Diamond
			UsuarioDiamond.CrearUsuario(Usuarios);
			break;
		case 2: // Golden
			UsuarioGolden.CrearUsuario(Usuarios);
			break;
		case 3: // Silver
			UsuarioSilver.CrearUsuario(Usuarios);
			break;
		default:
			System.out.println("Opcíón inválida");
			break;
		}
	}
	
	/**
	 * Método estático que permite al usuario iniciar sesión con su identificador y contraseña.
	 * Este método es llamado desde el método "main". Dentro de este método se solicita al usuario ingresar
	 * su identificador y contraseña, y si el "Hashtable" argumentado contiene a un "Usuario" con el que se
	 * comparta nombre, y la contraseña coincida con él, entonces es posible el inicio de sesión.
	 * Si el inicio de sesión es posible, se verificará si el usuario es "Administrador". En caso positivo,
	 * se realiza una llamada al menu de la clase correspondiente; en caso contrario, se llamará al menú de juegos
	 * ordinario para todos los usuarios.
	 * @param Usuarios Una colección de tipo hashtable con claves "String" y objetos de la clase "Usuario", tal
	 * que las claves son las contraseñas de los usuarios, y el objeto "Usuario" es el usuario en sí.
	 */
	public static void IniciarSesion(Hashtable<String, Usuario> Usuarios ) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese su ID: ");
		String id = sc.nextLine();
		if (Usuarios.containsKey(id)) {
			Usuario aux = Usuarios.get(id);
			System.out.println("Ingrese la contraseña: ");
			String contra = sc.nextLine();
			if (aux.getContrasena().equals(contra)) {
				if (aux.getClass().getName().equals("Usuarios.Tipos_Usuario.Administrador")) {
					Administrador auxadmin = (Administrador) aux;
					auxadmin.MenuAdmin(Usuarios, nombre_Archivo);
				} else {
					boolean stat = true;
					System.out.println("Sesión iniciada: " + aux.getID_Usuario());
					System.out.println("¡Hola " + aux.getNombre() + " " + aux.getApellido_P() + " " + aux.getApellido_M() + "!");
					while (stat == true) {
						stat = aux.MenuJugar();
						Utilidades.ActualizarArchivo(nombre_Archivo, Usuarios);
						System.out.println("Progreso guardado");
					}
					System.out.println("Sesión cerrada: " + aux.getID_Usuario());
				}
			} else {
				System.out.println("Contraseña incorrecta...");
			}
		} else {
			System.out.println("El usuario no existe...");
		}
	}
	

	
}
