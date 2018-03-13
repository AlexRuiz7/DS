/** 
 *	Fichero Bicicleta.java, factoria_abstracta, P1 -Patrones-
 *
 *
 *	03/03/2018
 *
 *
 *	Universidad de Granada - Grado en Informatica
 * 
 * 	Asignatura: Desarrollo de Software
 * 	Práctica 1: Ejercicio 2
 * 
 * 	@author Alejandro Ruiz Becerra
 * 
 *	Clase que define un objeto bicicleta y su tipo.
 */
package factoria_abstracta;


public class Bicicleta {

	private TipoBicicleta tipo;
	private int numero;
	
	/**
	 * Constructor con parámetro de la clase Bicicleta
	 * 
	 * @param tipo Tipo de bicicleta
	 */
	public Bicicleta(TipoBicicleta t, int n) {
		tipo = t;
		numero = n;
	}

	
	/**
	 * Getter del tipo Bicicleta
	 * 
	 * @return t Tipo de Bicicleta
	 */
	public TipoBicicleta getTipo() {
		return tipo;
	}
	
	
	/**
	 * Setter del tipo de Bicicleta
	 * 
	 * @param tipo Tipo de bicicleta
	 */
	public void setTipo(TipoBicicleta t) {
		tipo = t;
	}
	
	
	/**
	 * Setter del número de participación de la bicicleta.
	 * 
	 * @param n	Número de participación
	 */
	public void setNumero(int n) {
		numero = n;
	}
	
	
	/**
	 * Getter del número de participación de la bicicleta.
	 * 
	 * @return numero
	 */
	public int getNumero() {
		return numero;
	}
	
	
	/**
	 * Método toString de la clace Bicicleta
	 */
	public String toString() {
		return ("Bicicleta - " + tipo + ", " + numero);
	}

}
