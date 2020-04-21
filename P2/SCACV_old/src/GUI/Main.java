package GUI;

import controlVelocidad.ControlVelocidad;
import monitorizacion.Monitor;
import eu.hansolo.steelseries.gauges.*;
/**
 *
 * @author pablorobles
 */

public class Main extends javax.swing.JApplet {

    private static final long serialVersionUID = 1L;

    @Override
    public void init() {
        
        setSize(1200, 700);
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
