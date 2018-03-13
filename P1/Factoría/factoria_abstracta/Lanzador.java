/**
 * Universidad de Granada - Grado en Informatica
 * 
 * Asignatura: Desarrollo de Software
 * Práctica 1: Ejercicio 2
 * 
 * @author Alejandro Ruiz Becerra
 * 
 */

package factoria_abstracta;

import java.util.Scanner;

public class Lanzador {

	private static Scanner scanner;


	public static void main(String[] args) {
		
		// Recolectar número de participantes de la carrera
		System.out.print("Introduzca número de participantes por carrera: ");
		scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		FactoriaCarreraMontaña cm 	= new FactoriaCarreraMontaña(n);
		FactoriaCarreraCarretera cc	= new FactoriaCarreraCarretera(n);
		
		System.out.println("Participantes por carrera: " + n);
		
		// Lanzamos las hebras
		cm.t.start();
		cc.t.start();

	}

}
