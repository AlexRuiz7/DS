/** 
 *	Fichero CalcularVelocidad.java, interceptor, P1 -Patrones-
 *
 *
 *	13/03/2018
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


public class CalcularVelocidad implements Filtro {

	private double velocidad;	// Velocidad del vehículo (metros por segundo)
	private double radio_rueda;	// Radio del neumático del vehículo (metros)
	

	/**
	 * Constructor
	 */
	public CalcularVelocidad() {
		velocidad = 0;
		radio_rueda = 0.6;
	}
	
	
	/**
	 * Constructor con parámetros
	 */
	public CalcularVelocidad(double radio) {
		velocidad = 0;
		radio_rueda = radio;
	}
	
	
	@Override
	/**
	 * Calcula la velocidad actual del vehículo
	 */
	public double ejecutar(Object o) {
		// velocidad_angular = 2*pi*frecuencia_de_rotacion(revoluciones/seg)
		double revoluciones		 = (double) o;
		double velocidad_angular = 2*Math.PI*revoluciones;		// radianes/seg
		
		// Velocidad_lineal = aceleración_angular*radio_rueda
		velocidad = velocidad_angular*radio_rueda;
		
		return Math.ceil(velocidad);
	}
	

	/**
	 * 
	 */
	public void toString(double o) {
		System.out.println("Velocidad del vehículo: " + o + " m/s (1 segundo)");
	}

}
