/** 
 *	Fichero Observable.java, observable_observador, P1 -Patrones-
 *
 *
 *	04/03/2018
 *
 *
 * Universidad de Granada - Grado en Informatica
 * 
 * Asignatura: Desarrollo de Software
 * Práctica 1: Ejercicio 2
 * 
 * @author Alejandro Ruiz Becerra
 * 
 */

package observable_observador;

import java.util.ArrayList;


public abstract class Observable {

	protected ArrayList<Observador> observadores;
	
	/**
	 * Constructor
	 */
	public Observable() {
		observadores = new ArrayList<Observador>();
	}
	
	/**
	 * Añade un nuevo observador al conjunto de observadores
	 * 
	 * @param o
	 */
	public void incluirObservador(Observador o) {
		observadores.add(o);
	}
	
	
	/**
	 * Elimina un observador de la lista de observadores
	 * 
	 * @param o	Observador a eliminar
	 */
	public void eliminarObservador(Observador o) {
		observadores.remove(o);
	}
	
	/**
	 * Notifica a todos los observadores de que ha ocurrido un evento, para que
	 * actúen en consecuencia.
	 * 
	 */
	public void notificarObservador(int temp) {
		for(int i=0; i<observadores.size(); i++)
			observadores.get(i).manejarEvento(temp);
	}
}
