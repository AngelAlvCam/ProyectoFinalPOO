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
	
	private UsuarioSilver(String ID_Usuario, String nombre, String apellido_P, 
			String apellido_M, String contrasena) {
		super(ID_Usuario, nombre, apellido_P, apellido_M, contrasena, 200);
	}
	
	
	@Override
	public boolean MenuJugar() {
		System.out.println("* Menu silver *");
		/*
		 * Aquí va el menú de juegos para los usuarios tipo "Silver"
		 */
		int op;
		int apuesta;
		boolean win;
		boolean stat = true;
		Scanner sc = new Scanner(System.in);
		
			System.out.println("1) Dados");
			System.out.println("2) Maquina traga monedas");
			System.out.println("3) Ruleta");
			System.out.println("4) Salir");
			op = sc.nextInt();
			if (op != 4) {
				System.out.println("Fichas: " + getFichas());
				System.out.println("Ingrese su apuesta, usted puede apostar a lo mucho la mitad de su total de fichas");
				apuesta = sc.nextInt();
				if (Verificar_Apuesta(apuesta) == true) {
					switch (op) {
						case 1:
							win = Dados.Jugar();
							Agregar_Fichas(apuesta, win);
							break;
						case 2:
							win = Maquina_traga_monedas.Jugar();
							Agregar_Fichas(apuesta, win);
							break;
						case 3:
							win = Ruleta.Jugar();
							Agregar_Fichas(apuesta, win);
							break;
						case 4:
							stat = false;
							break;
						default:
							System.out.println("Opción inválida");
							break;
					}
				} else {
					System.out.println("La cantidad de fichas es inválida... ");
				}
			} else {
				stat = false;
			}
			return stat;
	}

	@Override
	public boolean Verificar_Apuesta(int apuesta) {
		if (this.getFichas() > 0 && apuesta < (this.getFichas()/2)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void Agregar_Fichas(int apuesta, boolean win) {
		if (win) {
			int bono = apuesta/4;
			setFichas(getFichas() + apuesta + bono);
			System.out.println("Has ganado " + (apuesta + bono) + " fichas");
		} else {
			setFichas(getFichas() - apuesta);
			System.out.println("Has perdido " + apuesta + " fichas");
		}
		System.out.println("Tu nuevo saldo es: " + getFichas());
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
