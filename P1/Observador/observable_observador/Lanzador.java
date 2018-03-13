/**
 * Universidad de Granada - Grado en Informatica
 * 
 * Asignatura: Desarrollo de Software
 * Práctica 1: Ejercicio 2
 * 
 * @author Alejandro Ruiz Becerra
 * 
 */

package observable_observador;

import java.util.Scanner;
import GUI.*;

public class Lanzador {

	private static Scanner scanner;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Simulador s;
		Pantalla p;
		int min, max;
		scanner = new Scanner(System.in);
		
		// Recolectar rango de temperaturas
		do {
			System.out.print("Introduzca temperatura mínima: ");
			min = scanner.nextInt();
			System.out.print("Introduzca temperatura máxima: ");
			max = scanner.nextInt();
			
			if(min >= max)
				System.out.println("Rango de temperaturas no válido");
		}while(min >= max);
		

		s = new Simulador(min, max);	// Crear una instancia de Simulador
		p = Pantalla.getInstancia();	// Recuper la instancia de Pantalla
		p.setVisible(true);				// Hacer la pantalla visible
		s.incluirObservador(p);			// Añadir observadores al Simulador
		s.t.start();					// Lanzar la hebra Simulador
		System.out.println("Simulación en curso...");
		Pantalla.t.start();				// Lanzar la hebra Pantalla
	}

}
