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

        Objetivo motor = new Objetivo();
        GestorFiltros gestor = new GestorFiltros(motor);
        Cliente controlador = new Cliente(gestor);
        
        /****/
        
        Salpicadero salpicadero = new Salpicadero();
        salpicadero.setObjetivo(motor);
        salpicadero.setLocation(200, 200);
        Ventana ventana_salpicadero = new Ventana(salpicadero, "Salpicadero");
        
        /****/
        
        Controles controles = new Controles();
        controles.setControlador(controlador);
        controles.setLocation(200, 400);
        Ventana ventana_controles = new Ventana(controles, "Controles");
    }
}
