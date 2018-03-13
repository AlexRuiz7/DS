/** 
 *	Fichero Bus.java, visitante, P1 -Patrones-
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


public class Bus extends Equipo{

	private double precio, potencia;
	
	/**
	 * Constructor
	 * 
	 * @param nombre
	 */
	public Bus(String nombre, double precio, double potencia) {
		super(nombre);
		this.precio = precio;
		this.potencia = potencia;
	}


	@Override
	public double potencia() {
		return potencia;
	}


	@Override
	public double precioNeto() {
		return precio;
	}


	@Override
	public double precioConDescuento(Cliente c) {
		return (precio - (precio*c.descuento()/100) );
	}


	@Override
	public void aceptar(VisitanteEquipo ve) {
		ve.VisitarBus(this);
	}

}
