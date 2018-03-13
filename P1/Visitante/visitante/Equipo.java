/** 
 *	Fichero Equipo.java, visitante, P1 -Patrones-
 *
 *
 *	06/03/2018
 *
 *	Universidad de Granada - Grado en Informatica
 *
 *	Asignatura: Desarrollo de Software
 *	Práctica 1: Ejercicio 3
 * 
 *	@author Alejandro Ruiz Becerra
 * 
 */
package visitante;


public abstract class Equipo {
	private String nombre;
	private String marca;
	
	
	/**
	 * Constructor
	 * 
	 * @param nombre
	 */
	public Equipo(String nombre) {
		this.nombre = nombre;
	}
	
	
	/**
	 * Devuelve la variable nombre de tipo String
	 * 
	 * @return nombre del equipo
	 */
	public String nombre() {
		return nombre;
	}
	
	
	/**
	 * Implementado en clases concretas
	 * 
	 * @return
	 */
	public abstract double potencia();
	
	
	/**
	 * Implementado en clases concretas
	 * 
	 * @return
	 */
	public abstract double precioNeto();
	
	
	/**
	 * Implementado en clases concretas
	 * 
	 * @return
	 */
	public abstract double precioConDescuento(Cliente c);
	
	
	/**
	 * Implementado en clases concretas
	 * 
	 * @param ve
	 */
	public abstract void aceptar(VisitanteEquipo ve);
}
