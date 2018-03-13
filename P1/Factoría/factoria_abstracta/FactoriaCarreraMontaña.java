/** 
 *	Fichero FactoriaCarreraMontaña.java, factoria_abstracta, P1 -Patrones-
 *
 *
 *	03/03/2018
 *
 *
 * Universidad de Granada - Grado en Informatica
 * 
 * Asignatura: Desarrollo de Software
 * Práctica 1: Ejercicio 2
 * 
 * @author Alejandro Ruiz Becerra
 * 
 * Factoría específica para la creación de una carrera de bicicletas de montaña.
 */
package factoria_abstracta;

import java.util.ArrayList;


public class FactoriaCarreraMontaña extends FactoriaCarrera implements Runnable{
	
	/**
	 * Constructor con parámetros.
	 * Incializa el array correspondiente a su tipo al número de bicicletas que
	 * participan en la carrera de bicicletas de montaña.
	 * 
	 * @param n	Número de bicicletas que participan en la carrera
	 */
	public FactoriaCarreraMontaña(int n) {
		bicicletas_montaña = new ArrayList<Bicicleta>(n);
		porcentage_abandono = 20;
		this.n = n;
		t = new Thread(this, "Montaña");
		
		for(int i=0; i<n; i++) {
			bicicletas_montaña.add(new Bicicleta(TipoBicicleta.MONTAÑA, i));
		}
	}
	
	
	/**
	 * Devuelve el porcentage de abandono de la carrera de montaña.
	 * 
	 * @return porcentage de abandono del tipo de carrera
	 */
	public float getPorcentageAbandono() {
		return porcentage_abandono;
	}
	
	
	/**
	 * Crea la carrera de montaña. Ejecuta por el método run de la hebra.
	 */
	public void crearCarrera() {
		System.out.println("Comenzando carrera de montaña... En curso.");
		
		abandonos = (int) Math.ceil(n*porcentage_abandono/100.0);
		no_finalizado = new ArrayList<Bicicleta>(abandonos);
		int b;
		
		for(int i=0; i<abandonos; i++) {
			b = (int) (Math.random() * bicicletas_montaña.size());
			no_finalizado.add(bicicletas_montaña.get(b));
			bicicletas_montaña.remove(b);
		}
		
		try {
			Thread.currentThread();
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Método llamado al finalizar la carrera. Muestra resultados por pantalla.
	 * Ejecutado por el método run de cada hebra.
	 */
	public void finalizarCarrera() {
		String mensage = "\nCarrera de montaña finalizada." + 
				"\n\tAbandonos: " + abandonos;
		for(int i=0; i<abandonos; i++)
			mensage += "\n\t\t"+no_finalizado.get(i).toString();
		
		
		mensage += "\n\tFinalizados: " + bicicletas_montaña.size();
		for(int i=0; i<bicicletas_montaña.size(); i++)
			mensage += "\n\t\t"+bicicletas_montaña.get(i).toString();
		
		System.out.println(mensage);
	}
	
	
	/**
	 * Sobrecarga del método run de Thread para que ejecute el método crearCarrera
	 * 
	 * @see crearCarrera
	 */
	public void run() {
		crearCarrera();
		finalizarCarrera();
	}
	
}
