/** 
 *	Fichero FactoriaCarrera.java, factoria_abstracta, P1 -Patrones-
 *
 *
 *	03/03/2018
 *	
 *	Universidad de Granada - Grado en Informatica
 * 
 * 	Asignatura: Desarrollo de Software
 * 	Práctica 1: Ejercicio 2
 * 
 * 	@author Alejandro Ruiz Becerra
 * 
 */
package factoria_abstracta;

import java.util.ArrayList;


public class FactoriaCarrera implements Carrera {

	// Declaración de variables
	protected ArrayList<Bicicleta> bicicletas_carretera;
	protected ArrayList<Bicicleta> bicicletas_montaña;
	protected ArrayList<Bicicleta> no_finalizado;
	protected int n;
	protected int porcentage_abandono;
	protected int abandonos;
	protected Thread t;
	

	@Override
	public void crearCarrera() {
		// Implementado en Factorías Específicas
	}
	
	
	@Override
	public void finalizarCarrera() {
		// Implementado en Factorías Específicas
	}

	
	/**
	 * Getter del número de bicicletas que participan en las carreras.
	 * 
	 * @return n Número de bicicletas que partcipan en la carrera.
	 */
	public int getBicicletas() {
		return n;
	}
}
