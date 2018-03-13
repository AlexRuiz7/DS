/** 
 *	Fichero Cliente.java, visitante, P1 -Patrones-
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


public class Cliente implements Runnable{

	private int id;
	private TipoCliente tipo;
	private double descuento;
	private ArrayList<Equipo> conf_equipo;
	public Thread t;
	
	
	/**
	 * Constructor
	 * 
	 * @param tc
	 */
	public Cliente(int id, TipoCliente tc, ArrayList<Equipo> ce) {
		this.id = id;
		tipo = tc;
		conf_equipo = ce;
		t = new Thread(this, "Cliente");
		
		switch(tipo) {
			case VIP: 
				descuento = 10;
				break;
			case MAYORISTA:
				descuento = 15;
				break;
			default:
				descuento = 0;
				break;
		}
	}
	
	
	/**
	 * Devuelve el numero identificador del cliente
	 * 
	 * @return
	 */
	public int id() {
		return id;
	}
	
	
	/**
	 * Devuleve el porcentage de descuento aplicable al cliente
	 * 
	 * @return descuento
	 */
	public double descuento() {
		return descuento;
	}
	
	
	/**
	 * Sobrecarga del método run.
	 */
	public void run() {
		// Identificamos al cliente
		System.out.println("Cliente ["+ id +"]: " + tipo);
		
		// Creamos una objeto visitante para este cliente
		VisitanteEquipo ve;
		
		// Consultamos nombres
		ve = new VisitanteNombre(this);
		
		for(int i=0; i<conf_equipo.size(); i++)
			conf_equipo.get(i).aceptar(ve);
		
		System.out.println("Descripción de componentes: " + ((VisitanteNombre) ve).nombres());
		
		// Consultamos precios
		ve = new VisitantePrecio(this);

		for(int i=0; i<conf_equipo.size(); i++)
			conf_equipo.get(i).aceptar(ve);
		
		System.out.println("Precio total de componentes: " + ((VisitantePrecio) ve).precio() + " €");
		
	}
	

}
