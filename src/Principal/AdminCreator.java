package Principal;

import Usuarios.Usuario;
import Usuarios.Tipos_Usuario.*;
import java.util.Hashtable;

/*
 * 
 * user: aacfi
 * password: soyadminxd
 * 
 * �ste se trata de un programa que al ejecutarse de forma independiente permite la creaci�n de usuarios.
 * Hace uso de los m�todos de la clase "Utilidades" para a�adir al administrador creado en el archivo de usuarios.
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
