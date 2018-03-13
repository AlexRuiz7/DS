/** 
 *	Fichero DemoInterceptor.java, interceptor, P1 -Patrones-
 *
 *
 *	13/03/2018
 *
 *	Universidad de Granada - Grado en Informatica
 *
 *	Asignatura: Desarrollo de Software
 *	Práctica 1: Ejercicio 4
 * 
 *	@author Alejandro Ruiz Becerra
 * 
 */
package interceptor;

import GUI.Interfaz;


public class DemoInterceptor {


	public static void main(String[] args) {
		Interfaz ventana = Interfaz.getInstancia();
		
		GestorFiltros gf = new GestorFiltros(ventana);
		gf.addFiltro(new CalcularDistancia());
		gf.addFiltro(new CalcularVelocidad());
		
		Cliente cliente = new Cliente();
		cliente.setGestorFiltros(gf);
		cliente.enviarPeticion(500);	// Nº incial de revoluciones del eje.
		
		ventana.t.start();
	}

}
