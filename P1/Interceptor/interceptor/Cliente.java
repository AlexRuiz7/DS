/** 
 *	Fichero Cliente.java, interceptor, P1 -Patrones-
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


public class Cliente {
	
	private GestorFiltros gestor_filtros;
	
	
	/**
	 * Contructor
	 */
	public Cliente() {
		gestor_filtros = new GestorFiltros();
	}
	
	
	/**
	 * Asigna el gestor de filtros a usar
	 * 
	 * @param g
	 */
	public void setGestorFiltros(GestorFiltros g) {
		gestor_filtros = g;
	}
	
	
	/**
	 * Envía la petición al gestor de filtros para que la aplique a cada uno de
	 * los filtros aplicados al objetivos.
	 * 
	 * @param p
	 */
	public void enviarPeticion(double p) {
		gestor_filtros.peticionFiltro(p);
	}
	
}
