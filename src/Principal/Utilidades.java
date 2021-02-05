package Principal;

import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Set;

import Usuarios.Usuario;

/**
 * Esta clase presenta m�todos utiles para otras clases. El objetivo de estos m�todos es , principalmente,
 * la operaci�n con el archivo de texto involucrado con la persistencia de la informaci�n.
 * @author Flutt
 *
 */
public class Utilidades {
	/**
	 * Este m�todo copia el contenido del hashtable contenido en un archivo (archivo de objetos) a un
	 * objeto de la clase "Hashtable". 
	 * En esencia, este m�todo es el que permite la persistencia de la informaci�n.
	 * @param nombre_Archivo Un objeto de la clase "String" que denota el nombre del archivo de texto del cual
	 * se quiere copiar el objeto de la clase "Hashtable" contenido.
	 * @param Usuarios Un objeto de la clase "Hashtable" en el cual se desea copiar el contenido del archivo
	 * de texto. 
	 */
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
			//	System.out.println(Usuarios.toString());
				ois.close();
			} else {
				System.out.println("El archivo no existe, se crear� uno nuevo");
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
	
	/**
	 * Este m�todo permite sobreescribir el contenido del archivo de texto que permite la persistencia de la
	 * informaci�n con el contenido adquirido por el hashtable utilizado en tiempo de ejecuci�n.
	 * @param nombre_archivo Un objeto de la clase "String" que denota el nombre del archivo de objetos que se
	 * desea sobreescribir. 
	 * @param Usuarios Un objeto de la clase "Hashtable" que se desea sobreescribir en el archivo de objetos cuyo
	 * nombre es argumentado..
	 */
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
	
	/**
	 * Este m�todo se encarga de controlar las excepciones al ingresar valores enteros. Reemplaza a la clausula "<scanner object>.nextInt".
	 * Es un m�todo de naturaleza recursiva, tal que si se atrapa a la excepci�n, se realiza una llamada autoreferencial al mismo m�todo.
	 * @return Un valor entero ingresado dentro del mismo m�todo, o sea, una entrada v�lida.
	 */
	public static int IntInput() {
		boolean stat = false;
		Scanner sc = new Scanner(System.in);
		int op = 0;
		try {	
		//	System.out.println("INPUT: ");
			op = sc.nextInt();
			stat = true;
		} catch (InputMismatchException e) {
			System.out.println("E: Seleccione con valores enteros");
			return op = IntInput();
		}
		return op;
	}
	
	/**
	 * Este m�todo se encarga de controlar la entrada de cadenas de caracteres para los atributos de
	 * nombres y apellidos en los usuarios.
	 * @return Un objeto String que cumple con las caracter�sticas propuestas en el m�todo.
	 */
	public static String StringInput() { 
		Scanner sc = new Scanner(System.in);
		String aux = null;
		aux = sc.nextLine();
		if ((aux != null) && (aux.length() >= 3) && (aux.matches("^[a-zA-Z]*$"))) {
			return aux;
		} else {
			System.out.println("E: Cadena inv�lida, debe tener m�s de 3 caracteres alfab�ticos");
			return aux = StringInput();
		}
	}
}
