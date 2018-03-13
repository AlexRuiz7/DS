/** 
 *	Fichero CadenaFiltros.java, interceptor, P1 -Patrones-
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

import java.util.ArrayList;

import GUI.Interfaz;


public class CadenaFiltros{

	private ArrayList<Filtro> filtros;
	private Interfaz objetivo;
	

	/**
	 * Constructor
	 */
	public CadenaFiltros() {
		filtros = new ArrayList<Filtro>();
		objetivo = Interfaz.getInstancia();
	}
	
	
	/**
	 * Envía la petición definida por el usuario a todo los filtros aplicables
	 * almacenados en el Array filtros. Por último, se llama al método ejecutar
	 * del Objetivo para que actualice y continúe su ejecución.
	 * 
	 * @param peticion
	 */
	public void ejecutar(double peticion) {
		for(Filtro f : filtros) {
			f.toString(f.ejecutar(peticion));
		}
		objetivo.ejecutar(peticion);
	}
	
	
	/**
	 * Asignamos el Objeto sobre el que se van a aplicar los filtros
	 * 
	 * @param o Interfaz u objeto objetivo
	 */
	public void setObjetivo(Interfaz o) {
		objetivo = Interfaz.getInstancia();
		// objetivo = o;
	}

	
	/**
	 * Añade un filtro al array de filtros
	 * 
	 * @param f	Filtro a añadir
	 */
	public void addFiltro(Filtro f) {
		filtros.add(f);
	}
}
