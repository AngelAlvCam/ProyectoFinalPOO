package Principal;

import Usuarios.Usuario;
import Usuarios.Tipos_Usuario.*;
import java.util.Hashtable;

/*
 * user: aacfi
 * password: soyadminxd
 */

public class AdminCreator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre_Archivo = "usuarios.txt";
		Hashtable<String, Usuario> Usuarios = new Hashtable<String, Usuario>();
		Utilidades.AbrirArchivo(nombre_Archivo, Usuarios);
		Administrador.CrearUsuario(Usuarios);
		Utilidades.ActualizarArchivo(nombre_Archivo, Usuarios);
	}
}
