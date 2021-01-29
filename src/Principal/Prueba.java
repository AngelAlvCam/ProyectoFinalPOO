package Principal;

import Usuarios.Usuario;
import Usuarios.Tipos_Usuario.*;
import java.io.*;
import java.util.Hashtable;
import java.util.Set;
import java.util.Scanner;
import javax.swing.*;

public class Prueba {

	public static void main(String[] args) {
		
		String nombre_Archivo = "usuarios.txt";
		Hashtable<String, Usuario> Usuarios = new Hashtable<String, Usuario>();
		AbrirArchivo(nombre_Archivo, Usuarios);
		int op;
		boolean stat = true;
		Scanner sc = new Scanner(System.in);
		while (stat) {
			System.out.println("1) Iniciar sesion");
			System.out.println("2) Crear usuario");
			System.out.println("3) Salir");
			op = sc.nextInt();
			switch(op) {
			case 1:
				IniciarSesion(Usuarios);
				break;
			case 2:
				RegistrarUsuario(Usuarios);
				ActualizarArchivo(nombre_Archivo, Usuarios);
				break;
			case 3:
				stat = false;
				break;
			case 4:
				System.out.println("Opción inválida");
				break;
			}
		}
	}
	
	public static void RegistrarUsuario(Hashtable<String, Usuario> Usuarios) {
		Scanner sc = new Scanner(System.in);
		int op;
		Usuario aux;
		System.out.println("1) Usuario Diamond");
		System.out.println("2) Usuario Golden");
		System.out.println("3) Usuario Silver");
		op = sc.nextInt();
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
	
	public static void IniciarSesion(Hashtable<String, Usuario> Usuarios ) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese su ID: ");
		String id = sc.nextLine();
		if (Usuarios.containsKey(id)) {
			Usuario aux = Usuarios.get(id);
			System.out.println("Ingrese la contraseña: ");
			String contra = sc.nextLine();
			if (aux.getContrasena().equals(contra)) {
				aux.MenuJugar();
			} else {
				System.out.println("Contraseña incorrecta...");
			}
		} else {
			System.out.println("El usuario no existe...");
		}
	}
	
	public static void ActualizarArchivo(String nombre_archivo, Hashtable<String, Usuario> Usuarios) {
		try {
			File file = new File(nombre_archivo);
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Usuarios);
			oos.close();
		// FileNotFoundException, IOException, 
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	public static void AbrirArchivo(String nombre_Archivo, Hashtable<String, Usuario> Usuarios) {
		try {	
			File file = new File(nombre_Archivo);
			if (file.exists() == true) {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Hashtable<String, Usuario> aux = (Hashtable<String, Usuario>) ois.readObject();
				Set<String> keySet = aux.keySet();
				for(String key : keySet) {
					Usuarios.put(key, aux.get(key));
				}
				System.out.println(Usuarios.toString());
				ois.close();
			} else {
				System.out.println("El archivo no existe, se creará uno nuevo");
				file.createNewFile();
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		}
	}
	
}
