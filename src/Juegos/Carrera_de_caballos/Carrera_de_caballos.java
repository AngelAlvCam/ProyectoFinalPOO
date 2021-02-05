package Juegos.Carrera_de_caballos;

import java.util.Scanner;

public class Carrera_de_caballos {
	
	public boolean JugarAux(String nombre) {
		
		Caballo.setSeleccionado(nombre);
		Caballo c1 = new Caballo(nombre);
		Caballo c2 = new Caballo("c2");
		Caballo c3 = new Caballo("c3");
		Caballo c4 = new Caballo("c4");
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
			
		try {
			c1.join();
			c2.join();
			c3.join();
			c4.join();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException");
		}
		
		System.out.println(Caballo.getPosiciones().toString());
		if (Caballo.getPosiciones().get(1).equals(nombre)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean Jugar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el nombre del caballo por el que apuesta: ");
		String nombre = sc.nextLine();
		Carrera_de_caballos aux = new Carrera_de_caballos();
		if (aux.JugarAux(nombre) == true) {
			return true;
		} else {
			return false;
		}
	}
}
