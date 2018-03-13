/** 
 *	Fichero VisitanteEquipo.java, visitante, P1 -Patrones-
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


public abstract class VisitanteEquipo {
	

	public abstract void visitarDisco(Disco d);
	
	public abstract void visitarTarjeta(Tarjeta t);
	
	public abstract void VisitarBus(Bus b);
}
