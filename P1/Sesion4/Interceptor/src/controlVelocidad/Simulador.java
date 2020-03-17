package controlVelocidad;

import GUI.Salpicadero;
import GUI.Ventana;
import GUI.Controles;
import java.io.IOException;

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
        
        // Objetivo
        Objetivo obj = new Objetivo();
        
        // Instanciación de observadores
        Salpicadero salpicadero = new Salpicadero();
        salpicadero.setObjetivo(obj);
        salpicadero.setLocation(200, 200);
        Ventana ventana_salpicadero = new Ventana(salpicadero, "Salpicadero");
        
        Controles controles = new Controles();
        controles.setLocation(200, 400);
    }
}
