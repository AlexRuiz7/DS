/** 
 *	Fichero Pantalla.java, observable_observador, P1 -Patrones-
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
package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import observable_observador.Observador;


@SuppressWarnings("serial")
public class Pantalla extends JFrame implements Observador, Runnable {
	
	private	static Pantalla INSTANCE = new Pantalla();
	private static int 		celsius;
	private static int 		kelvin;
	private static double 	fahrenheit;
	private static JLabel 	cabecera, t_cel, t_kel, t_far;
	private static JPanel 	panel;
	public  static Thread 	t;
	
	
	/**
	 * 
	 */
	private Pantalla() {
		t = new Thread(this, "Pantalla");
		
		setTitle("Pantalla del Simulador");
		setSize(300,80);
		setResizable(false); 
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		cabecera = new JLabel("TEMPERATURAS");
		cabecera.setFont(new Font(Font.SERIF,Font.BOLD,12));
		panel.add(cabecera, JLabel.CENTER);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		t_cel = new JLabel("Celsius: no hay datos");
		t_cel.setAlignmentX(CENTER_ALIGNMENT);
		panel.add(t_cel);
		
		t_kel = new JLabel("Kelvin: no hay datos");
		t_kel.setAlignmentX(CENTER_ALIGNMENT);
		panel.add(t_kel);
		
		t_far = new JLabel("Fahrenheit: no hay datos");
		t_far.setAlignmentX(CENTER_ALIGNMENT);
		panel.add(t_far);
		
		getContentPane().add(panel, BorderLayout.CENTER);
		
		this.addWindowListener(new WindowAdapter(){
		  public void windowClosing(WindowEvent we){
		    System.exit(0);
		  }
		});
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static Pantalla getInstancia() {
		return INSTANCE;
	}
	
	
	/**
	 * 
	 */
	public static void refrescarPantalla() {
		t_cel.setText("Celsius: " 	+ String.valueOf(celsius) 	+ "ºC");
		t_kel.setText("Kelvin: "	+ String.valueOf(kelvin) 	+ "ºK");
		t_far.setText("Fahrenheit: "+ String.valueOf(fahrenheit)+ "ºF");
	}
	
	
	/**
	 * Convierte de grados Celsius a grados Kelvin
	 */
	private void convertirCelsiusKelvin() {
		kelvin = celsius + 273;
	}
	
	
	/**
	 * Convierte de grados Celsius a grados Fahrenheit
	 */
	private void convertirCelsiusFahrenheit() {
		fahrenheit = celsius*1.8 + 32;
		fahrenheit = Math.floor(fahrenheit * 100) / 100;
	}
	
	
	@Override
	public void manejarEvento(int temp) {
		celsius = temp;
		convertirCelsiusKelvin();
		convertirCelsiusFahrenheit();
		System.out.println("\tPantalla: notificación recibida. Temperatura:" + celsius);
	}

	@Override
	public void run() {
		while(true) {
			refrescarPantalla();			
		}
	}

}
