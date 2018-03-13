/** 
 *	Fichero GestorFiltros.java, interceptor, P1 -Patrones-
 *
 *
 *	06/03/2018
 *
 *	Universidad de Granada - Grado en Informatica
 *
 *	Asignatura: Desarrollo de Software
 *	Práctica 1: Ejercicio 4
 * 
 *	@author Alejandro Ruiz Becerra
 * 
 */
package interceptor;

import GUI.Interfaz;


public class GestorFiltros {
	
	private CadenaFiltros cf;
	private Interfaz objetivo;
	
	
	/**
	 * Constructor
	 */
	public GestorFiltros() {
		cf = new CadenaFiltros();
		objetivo = Interfaz.getInstancia();
	}
	
	
	/**
	 * Constructor con parámetros
	 * 
	 * @param i
	 */
	public GestorFiltros(Interfaz interfaz) {
		cf = new CadenaFiltros();
		objetivo = interfaz;
	}
	
	
	/**
	 * Añade un filtro al Array de filtros aplicables
	 * 
	 * @param f	Filtro a añadir
	 */
	public void addFiltro(Filtro f) {
		cf.addFiltro(f);
	}
	
	
	/**
	 * Envía la petición a CadenaFiltros para que se envíe a todo los filtros
	 * aplicables.
	 * 
	 * @param p
	 */
	public void peticionFiltro(double p) {
		cf.ejecutar(p);
	}
}
