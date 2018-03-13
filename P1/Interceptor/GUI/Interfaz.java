/** 
 *	Fichero Interfaz.java, GUI, P1 -Patrones-
 *
 *
 *	06/03/2018
 *
 *	Universidad de Granada - Grado en Informatica
 *
 *	Asignatura: Desarrollo de Software
 *	Práctica 1: Ejercicio 4
 * 
 *	@author Alejandro Ruiz Becerra
 * 
 */
package GUI;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;


@SuppressWarnings("serial")
public class Interfaz extends JFrame implements Runnable{
	private 	static Interfaz 		INSTANCIA = new Interfaz(); 
	private 	static JButton 			boton_acelerar;
	private 	static JToggleButton 	boton_encender;
	private 	static JPanel 			panel_superior, panel_botones;
	private 	static JLabel 			etiqueta_estado;
	private		static boolean 			encendido, acelerando;
	public		Thread 	t;
	
	
	/**
	 * Constructor por defecto
	 */
	private Interfaz() {
		t = new Thread(this, "Pantalla");
		encendido = acelerando = false;
		
		// Propiedades del JFrame
		setTitle("Pantalla del Simulador");
		setSize(300,100);
		setResizable(false); 
		
		// Crear panel superior y adherirlo al JFrame
		crearPanelSuperior();
		getContentPane().add(panel_superior);
		
		// Crear panel inferior y adherirlo al JFrame
		crearPanelBotones();
		getContentPane().add(panel_botones, BorderLayout.SOUTH);
		
		// Añadir gestor de eventos para acabar la aplicación al cerrar la
		// ventana
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
	}
	
	
	/**
	 * 
	 * 
	 * @param p
	 */
	public void ejecutar(double p) {
		this.pack();
		setVisible(true);
		System.out.println("Para un número de vueltas iniciales del eje = " + p);
	}
	
	
	/**
	 * Devuelve la única instancia de Ventana
	 * @return
	 */
	public static Interfaz getInstancia() {
		return INSTANCIA;
	}
	
	
	/**
	 * Crea el panel superior que contiene la etiqueta de estado de la interfaz
	 * gráfica.
	 */
	private static void crearPanelSuperior() {
		panel_superior = new JPanel(new GridBagLayout());
		panel_superior.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		etiqueta_estado = new JLabel("APAGADO");
		etiqueta_estado.setFont(new Font(Font.SERIF,Font.BOLD,16));
		etiqueta_estado.setForeground(Color.RED);
		panel_superior.add(etiqueta_estado);
	}
	
	
	/**
	 * Crea el panel inferior que contiene los dos botones de la interfaz
	 * gráfica.
	 */
	private static void crearPanelBotones() {		
		panel_botones = new JPanel(new FlowLayout());
		panel_botones.setAlignmentY(100);
		panel_botones.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		boton_acelerar = new JButton("Acelerar");
		panel_botones.add(boton_acelerar);
		
		boton_encender = new JToggleButton("Encender", false);
		boton_encender.setForeground(Color.RED);
		panel_botones.add(boton_encender);
	}
	
	
	/**
	 * Rutina de refresco del panel superior. Cambia el texto de la etiqueta.
	 */
	private static void refrescarPanelSuperior() {
		if(boton_encender.isSelected())
			if(boton_acelerar.getModel().isPressed()) 
				etiqueta_estado.setText("ACELERANDO");
			else
				etiqueta_estado.setText("ENCENDIDO");
		else
			etiqueta_estado.setText("APAGADO");
	}
	
	
	/**
	 * Rutina de refresco del panel inferior. Controla la apariencia de los
	 * botones.
	 */
	private static void refrescarPanelBotones() {
		if(boton_encender.isSelected()) {
			boton_encender.setText("Apagar");
			boton_encender.setForeground(Color.BLUE);
		}
		else {
			boton_encender.setText("Encender");
			boton_encender.setForeground(Color.RED);
		}
	}
	
	
	/**
	 * Rutina de refresco general
	 */
	private static void refrescarVentana() {
		refrescarPanelBotones();
		refrescarPanelSuperior();
	}


	@Override
	public void run() {
		while(true)
			refrescarVentana();
	}
	
	/**
	 * CadenaFiltros
	 * CalculaDistancia
	 * CalculaVelocidad
	 * Cliente
	 * DemoInterceptor
	 * Estado
	 * Filtro
	 * GestorFiltros
	 * Interfaz
	 * PanelBotones
	 */
	
}
