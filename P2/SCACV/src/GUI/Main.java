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

        ControlVelocidad controlVelocidad = new ControlVelocidad(500);
        Monitor monitor = new Monitor(controlVelocidad, 500);
        Interfaz display = new Interfaz(controlVelocidad, monitor);
        display.setVisible(true);

        add(display);

        controlVelocidad.start();
        monitor.start();
        display.thr.start();
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame("Applet SCACV");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        JApplet applet = new Main();
        f.getContentPane().add("Center", applet);
        applet.init();
        f.pack();
        f.setSize(new Dimension(780, 400));
        f.setVisible(true);
    }
}
