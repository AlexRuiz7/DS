/** 
 *	Fichero VisitantePotencia.java, visitante, P1 -Patrones-
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


public class VisitantePotencia extends VisitanteEquipo{

	private double potencia;
	private Cliente cliente;
	
	
	/**
	 * 
	 * @param c
	 */
	public VisitantePotencia(Cliente c) {
		potencia = 0;
		cliente = c;
	}


	@Override
	public void visitarDisco(Disco d) {
		potencia += d.potencia();
	}


	@Override
	public void visitarTarjeta(Tarjeta t) {
		potencia += t.potencia();
	}


	@Override
	public void VisitarBus(Bus b) {
		potencia += b.potencia();
	}
	
	/**
	 * Devuelve la potencia total
	 * 
	 * @return
	 */
	public double potencia() {
		return potencia;
	}
	
	
}
