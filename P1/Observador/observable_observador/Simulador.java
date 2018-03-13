/** 
 *	Fichero Simulador.java, observable_observador, P1 -Patrones-
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

import java.util.Random;


public class Simulador extends Observable implements Runnable{

	private 	int 	t_min;
	private 	int 	t_max;
	private 	int 	temperatura;
	protected 	Thread 	t;
	
	/**
	 * Constructor por defecto
	 */
	public Simulador(int min, int max) {
		t_min 	= min;
		t_max 	= max;
		t 		= new Thread(this, "Simulador");
	}
	
	
	/**
	 * Getter de la variable 'temperatura'
	 * 
	 * @return Temperatura actual del simulador
	 */
	public int getTemperatura() {
		return temperatura;
	}
	

	/**
	 * Método run que ejecutará la hebra del programa Simulador
	 */
	public void run() {
		while(true) {
			Random r = new Random(System.currentTimeMillis());
			temperatura = r.nextInt(t_max)+t_min;
			System.out.println("Temperatura actual: " + temperatura);
			notificarObservador(temperatura);
			try {
				Thread.currentThread();
				Thread.sleep(15000);			// Duerme 15 segundos
			}catch(java.lang.InterruptedException e) {
				e.printStackTrace();
			}
		}	// while
	}	// run	
}	// class 

