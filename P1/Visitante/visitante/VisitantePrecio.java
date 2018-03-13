/** 
 *	Fichero VisitantePrecio.java, visitante, P1 -Patrones-
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

/**
 * @author Alejandro Ruiz Becerra
 *
 */
public class VisitantePrecio extends VisitanteEquipo{

	private double precio;
	private Cliente cliente;
	
	
	/**
	 * Constructor
	 * 
	 * @param c
	 */
	public VisitantePrecio(Cliente c) {
		precio = 0;
		cliente = c;
	}

	@Override
	public void visitarDisco(Disco d) {
		precio += d.precioConDescuento(cliente);
	}


	@Override
	public void visitarTarjeta(Tarjeta t) {
		precio += t.precioConDescuento(cliente);
	}


	@Override
	public void VisitarBus(Bus b) {
		precio += b.precioConDescuento(cliente);
	}
	
	public double precio() {
		return precio;
	}

}
