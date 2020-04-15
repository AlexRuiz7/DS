package GUI;


import controlVelocidad.ControlVelocidad;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JApplet;
import javax.swing.JFrame;
import monitorizacion.Monitor;

/**
 *
 * @author pablorobles
 */

public class Main extends javax.swing.JApplet {

    private static final long serialVersionUID = 1L;

    @Override
    public void init() {
        
        setSize(850, 400);
        ControlVelocidad controlVelocidad = new ControlVelocidad(500);
        Monitor monitor = new Monitor(controlVelocidad, 500);
        Interfaz display = new Interfaz(controlVelocidad, monitor);
        display.setVisible(true);

        add(display);

        controlVelocidad.start();
        monitor.start();
        display.thr.start();
    }
}
