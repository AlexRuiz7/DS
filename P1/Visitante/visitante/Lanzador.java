/** 
 *	Fichero Lanzador.java, visitante, P1 -Patrones-
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

import java.util.ArrayList;
import java.util.Random;


public class Lanzador {

	public static Random rand = new Random(System.currentTimeMillis());
	
	
	/**
	 * Suspende la hebra durante un periodo de tiempo definido por [min, max]
	 * 
	 * @param min
	 * @param max
	 */
	public static void sleep(int min, int max) {
		int duerme = rand.nextInt(max*1000)+min*1000;
		
		try {
			Thread.currentThread();
			Thread.sleep(duerme);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		
		ArrayList<Equipo> configuracionEquipo1 = new ArrayList<>();
		ArrayList<Equipo> configuracionEquipo2 = new ArrayList<>();
		ArrayList<Equipo> configuracionEquipo3 = new ArrayList<>();
		
		// Definicion de configuraciones de equipos
		Equipo e1 = new Tarjeta("Nvidia GTX 650", 114, 50);
		Equipo e2 = new Tarjeta("Nvidia GTX 1080 Ti", 300, 140);
		Equipo e3 = new Bus("USB 3.0 16GB", 10, 0);
		Equipo e4 = new Disco("Western Digital 250GB", 55, 10);
		Equipo e5 = new Disco("Seagate SSD 1TB", 240, 60);
		
		// Añadimos los componentes de la configuracion de equipo
		configuracionEquipo1.add(e1);		
		configuracionEquipo1.add(e3);
		
		configuracionEquipo2.add(e2);
		configuracionEquipo2.add(e5);
		
		configuracionEquipo3.add(e1);
		configuracionEquipo3.add(e3);
		configuracionEquipo3.add(e4);
		
		// Generamos aleatoriamente el tipo de cliente
		Cliente c1 = new Cliente(0, TipoCliente.values()[rand.nextInt(3)], configuracionEquipo1);
		Cliente c2 = new Cliente(1, TipoCliente.values()[rand.nextInt(3)], configuracionEquipo2);
		Cliente c3 = new Cliente(2, TipoCliente.values()[rand.nextInt(3)], configuracionEquipo3);
		Cliente c4 = new Cliente(3, TipoCliente.values()[rand.nextInt(3)], configuracionEquipo3);
		
		// Lanzamos las hebras
		c1.t.start();
		sleep(6,10);
		c2.t.start();
		sleep(3,8);
		c3.t.start();
		sleep(5,17);
		c4.t.start();
		sleep(4,11);
	}

}
