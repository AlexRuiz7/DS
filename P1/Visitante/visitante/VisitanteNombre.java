/** 
 *	Fichero VisitanteNombre.java, visitante, P1 -Patrones-
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


public class VisitanteNombre extends VisitanteEquipo{

	private ArrayList<String> nombres;
	private Cliente cliente;
	
	/**
	 * Constructor
	 * 
	 * @param c
	 */
	public VisitanteNombre(Cliente c) {
		nombres = new ArrayList<String>();
		cliente = c;
	}

	@Override
	public void visitarDisco(Disco d) {
		nombres.add(d.nombre());
	}


	@Override
	public void visitarTarjeta(Tarjeta t) {
		nombres.add(t.nombre());
	}


	@Override
	public void VisitarBus(Bus b) {
		nombres.add(b.nombre());
	}
	
	
	/**
	 * Devuelve la lista de nombres de los dispositivos que componen en equipo
	 * 
	 * @return
	 */
	public ArrayList<String> nombres() {
		return nombres;
	}

}
