package Usuarios.Tipos_Usuario;

import Usuarios.Usuario;
import java.util.Hashtable;
import java.util.Scanner;
import Juegos.*;
import Juegos.Carrera_de_caballos.Carrera_de_caballos;
import Principal.Utilidades;

/**
 * Este tipo de usuario tiene acceso a todos los juegos sin restricci�n
 * alguna, no tiene restricci�nes en cuanto a sus apuesta (aplica la idea
 * de "todo o nada"), y tambi�n recibe el mayor bono de victoria. 
 * S e consider� un bono de victoria de n.  
 * @author Flutt
 *
 */
public class UsuarioDiamond extends Usuario{
	
	private UsuarioDiamond(String ID_Usuario, String nombre, String apellido_P, 
			String apellido_M, String contrasena) {
		super(ID_Usuario, nombre, apellido_P, apellido_M, contrasena, 500);
	}
	
	@Override
	public boolean MenuJugar() {
		System.out.println("* Menu diamond* ");
		/*
		 * Aqu� va el men� de juegos para los usuarios tipo "Diamond"
		 */
		int op;
		int apuesta;
		boolean win, stat = true;
		boolean stat2 = false;
			
			System.out.println("1) Dados");
			System.out.println("2) Carrera de caballos");
			System.out.println("3) Blackjack");
			System.out.println("4) Maquina traga monedas");
			System.out.println("5) Ruleta");
			System.out.println("6) Salir");
			System.out.println("Usted tiene " + this.getFichas() + " fichas");
			
		do {
			op = Utilidades.IntInput();
			if (op == 6) {
				stat = false;
			} else if (op >= 1 && op <= 5) {
				System.out.println("Ingrese su apuesta, usted puede apostar todas sus fichas en una jugadas: ");
				apuesta = Utilidades.IntInput();
				if (Verificar_Apuesta(apuesta) == true) {
					switch(op){
					case 1:
						win = Dados.Jugar();
						Agregar_Fichas(apuesta, win);
						break;
					case 2:
						win = Carrera_de_caballos.Jugar();
						Agregar_Fichas(apuesta, win);
						break;
					case 3:
						win = Blackjack.Jugar();
						Agregar_Fichas(apuesta, win);
						break;
					case 4:
						win = Maquina_traga_monedas.Jugar();
						Agregar_Fichas(apuesta, win);
						break;
					case 5:
						win = Ruleta.Jugar();
						Agregar_Fichas(apuesta, win);
						break;
					}
					stat2 = false;
				} else {
					System.out.println("E: La cantidad de fichas es inv�lida");
					stat2 = true;
				}
			} else {
				System.out.println("E: Opci�n inv�lida");
				stat2 = true;
			}
		} while (stat2 == true);
		return stat;
		
	}

	@Override
	public boolean Verificar_Apuesta(int apuesta) {
		if (this.getFichas() > 0 && this.getFichas() >= apuesta) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void Agregar_Fichas(int apuesta, boolean win) {
		if (win) {
			int bono = apuesta;
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
		String nombre = Utilidades.StringInput();
		System.out.println("Ingrese el apellido paterno del usuario: ");
		String apellido_P = Utilidades.StringInput();
		System.out.println("Ingrese el apellido materno del usuario: ");
		String apellido_M = Utilidades.StringInput();
		System.out.println("Ingrese un identificador");
		String id = sc.nextLine();
		while (Usuarios.containsKey(id) == true) {
			System.out.println("El identificador est� ocupado, ingrese un identificador diferente");
			id = sc.nextLine();			
		}
		System.out.println("Ingrese una contrase�a: ");
		String contrasena = sc.nextLine();
		UsuarioDiamond aux = new UsuarioDiamond(id, nombre, apellido_P, apellido_M, contrasena);
		Usuarios.put(id, aux);
	}
}
