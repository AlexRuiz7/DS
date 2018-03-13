/** 
 *	Fichero CalcularDistancia.java, interceptor, P1 -Patrones-
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


public class CalcularDistancia implements Filtro {

	private double distancia;	// Distancia recorrida por el vehículo (metros)
	private double radio_rueda;	// Radio del neumático del vehículo (metros)
	
	
	/**
	 * Constructor
	 */
	public CalcularDistancia() {
		distancia 	= 0;
		radio_rueda = 0.6;
	}
	
	
	/**
	 * Constructor con parámetros
	 */
	public CalcularDistancia(double radio) {
		distancia 	= 0;
		radio_rueda = radio;
	}
	
	
	@Override
	/**
	 * Calcula la distancia recorrida por el vehículo
	 */
	public double ejecutar(Object o) {
		double revoluciones = (double) o;
		
		distancia = 2*Math.PI*radio_rueda * revoluciones;
		
		return Math.ceil(distancia);
	}


	/**
	 * 
	 */
	public void toString(double o) {
		System.out.println("Distancia recorrida: " + (double) o + " metros (1 segundo)");
	}

}
