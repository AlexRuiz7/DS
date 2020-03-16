package controlVelocidad;

import GUI.Salpicadero;
import GUI.VentanaControl;
import java.io.IOException;
import java.util.Observer;

/**
 *
 * @author pablorobles
 */
public class Simulador {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        //Objetivo
        Objetivo obj = new Objetivo();
        
        // Instanciación de observadores
        Salpicadero salpicadero = new Salpicadero();
        salpicadero.setLocation(200, 200);
        VentanaControl controles = new VentanaControl();
        controles.setLocation(200, 400);
        
        
        // Añadir los observadores al observable
        obj.addObserver((Observer) salpicadero);
        obj.addObserver((Observer) controles);
        
        
        
    }
}
