package GUI;


import java.awt.BorderLayout;
import observable.Temperatura;
import observador.BotonCambio;
import observador.GraficaTemperatura;
import observador.PantallaTemperatura;
import observador.Ventana;


/**
 *
 * @author alex
 */
public class Simulador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instanciación de observable
        Temperatura t = new Temperatura();
        
        // Instanciación de observadores
        PantallaTemperatura p = new PantallaTemperatura(t);
        GraficaTemperatura g = new GraficaTemperatura(t);
        BotonCambio b = new BotonCambio(t);
        
        // Frame
        Ventana ventana_grafica = new Ventana();
        ventana_grafica.setTitle("Gráfica temperatura");
        ventana_grafica.setLayout(new BorderLayout());
        ventana_grafica.add(g, BorderLayout.CENTER);
//        ventana_grafica.setResizable(false);
        ventana_grafica.pack();
        ventana_grafica.setVisible(true);
        
        Ventana ventana_pantalla = new Ventana();
        ventana_pantalla.setTitle("Pantalla temperatura");
        ventana_pantalla.setLayout(new BorderLayout());
        ventana_pantalla.add(p, BorderLayout.CENTER);
//        ventana_pantalla.setResizable(false);
        ventana_pantalla.pack();
        ventana_pantalla.setVisible(true);
        
        Ventana ventana_boton = new Ventana();
        ventana_boton.setTitle("Botón cambiar temperatura");
        ventana_boton.setLayout(new BorderLayout());
        ventana_boton.add(b, BorderLayout.CENTER);
//        ventana_boton.setResizable(false);
        ventana_boton.pack();
        ventana_boton.setVisible(true);
        
        // Añadir los observadores al observable
        // t.addObserver(p);
        t.addObserver(g);
        t.addObserver(b);
        
        // Lanzar la hebra del observable
        t.hebra.start();
        p.hebra.start();
    }
    
}
