package Principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.Set;

import Usuarios.Usuario;

/**
 * Esta clase presenta métodos utiles para otras clases. El objetivo de estos métodos es , principalmente,
 * la operación con el archivo de texto involucrado con la persistencia de la información.
 * @author Flutt
 *
 */
public class Utilidades {
	/**
	 * Este método copia el contenido del hashtable contenido en un archivo (archivo de objetos) a un
	 * objeto de la clase "Hashtable". 
	 * En esencia, este método es el que permite la persistencia de la información.
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
	
	/**
	 * Este método permite sobreescribir el contenido del archivo de texto que permite la persistencia de la
	 * información con el contenido adquirido por el hashtable utilizado en tiempo de ejecución.
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
}
