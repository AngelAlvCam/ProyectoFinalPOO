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

public class Utilidades {
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
