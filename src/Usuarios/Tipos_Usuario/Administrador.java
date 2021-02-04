package Usuarios.Tipos_Usuario;

import java.util.Hashtable;
import java.util.Scanner;
import Principal.Utilidades;
import Usuarios.Usuario;
import java.util.Scanner;
import java.util.Set;

public class Administrador extends Usuario {

	public Administrador(String ID_Usuario, String nombre, String apellido_P, 
			String apellido_M, String contrasena) {
		super(ID_Usuario, nombre, apellido_P, apellido_M, contrasena, 10000);
	}
	
	@Override
	public void MenuJugar() {
		// TODO Auto-generated method stub
		
	}

	public boolean Verificar_Apuesta(int apuesta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Agregar_Fichas(int apuesta, boolean win) {
		// TODO Auto-generated method stub
		
	}
	
	public void MenuAdmin(Hashtable<String, Usuario> Usuarios, String nombre_Archivo) {
		int op;
		boolean stat = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu admin");
		
		while (stat == true) {
			System.out.println("1) Borrar usuarios");
			System.out.println("2) Editar usuarios");
			System.out.println("3) Ver usuarios");
			System.out.println("4) Salir");
			op = sc.nextInt();
			switch(op) {
				case 1:
					BorrarUsuario(Usuarios, nombre_Archivo);
					break;
				case 2:
					EditarUsuarios(Usuarios, nombre_Archivo);
					break;
				case 3:
					VerUsuarios(Usuarios);
					break;
				case 4:
					stat = false;
					break;
				default: 
					System.out.println("Opcíón inválida");
					break;
			}
		}
	}
	
	public static void CrearUsuario(Hashtable<String, Usuario> Usuarios) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese su nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Ingrese su apellido paterno: ");
		String apellido_P = sc.nextLine();
		System.out.println("Ingrese su apellido materno: ");
		String apellido_M = sc.nextLine();
		System.out.println("Ingrese un identificador");
		String id = sc.nextLine();
		while (Usuarios.containsKey(id) == true) {
			System.out.println("El identificador está ocupado, ingrese un identificador diferente");
			id = sc.nextLine();			
		}
		System.out.println("Ingrese una contraseña: ");
		String contrasena = sc.nextLine();
		Administrador aux = new Administrador(id, nombre, apellido_P, apellido_M, contrasena);
		Usuarios.put(id, aux);
	}
	
	private void VerUsuarios(Hashtable<String, Usuario> Usuarios) {
		Set<String> keyset = Usuarios.keySet();
		for (String aux : keyset) {
			System.out.println(Usuarios.get(aux));
		}
	}
	
	private void BorrarUsuario(Hashtable<String, Usuario> Usuarios, String nombre_Archivo) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el ID del usuario que desea eliminar: ");
		String aux_ID = sc.nextLine();
		if (this.getID_Usuario().equals(aux_ID) != true) {
			if (Usuarios.remove(aux_ID) != null) {
				System.out.println("Usuario " + aux_ID + " ha sido eliminado");
			} else {
				System.out.println("El usuario ingresado no existe");
			}
		} else {
			System.out.println("No te puedes eliminar a ti mismo, otro administrador debe hacerlo");
		}
	
	}
	
	private void EditarUsuarios(Hashtable<String, Usuario> Usuarios, String nombre_Archivo) {
		Scanner sc = new Scanner(System.in);
		int op;
		System.out.println("Ingrese el ID del usuario que desea editar: ");
		String aux_ID = sc.nextLine();
		if (Usuarios.contains(aux_ID) == true) {
			Usuario usuario = Usuarios.get(aux_ID);
			String aux;
			int aux2;
			System.out.println("1) Cambio de nombre");
			System.out.println("2) Cambio de apellido paterno");
			System.out.println("3) Cambio de apellido materno");
			System.out.println("4) Cambio de contraseña");
			System.out.println("5) Cambio en la cantidad de fichas");
			op = sc.nextInt();
			switch(op) {
			case 1:
				System.out.println("Ingrese el nuevo nombre");
				aux = sc.nextLine();
				usuario.setNombre(aux);
				break;
			case 2:
				System.out.println("Ingrese el nuevo apellido paterno");
				aux = sc.nextLine();
				usuario.setApellido_P(aux);
				break;
			case 3:
				System.out.println("Ingrese el nuevo apellido materno");
				aux = sc.nextLine();
				usuario.setApellido_M(aux);
				break;
			case 4:
				System.out.println("Ingrese la nueva contraseña");
				aux = sc.nextLine();
				usuario.setContrasena(aux);
				break;
			case 5:
				System.out.println("Ingrese la nueva cantidad de fichas");
				aux2 = sc.nextInt();
				usuario.setFichas(aux2);
				break;
			default:
				System.out.println("Opción incorrecta");
				break;
			}
		}
	}
}
