package controlVelocidad;

import GUI.Controles;
import GUI.Salpicadero;
import GUI.Ventana;
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
        //Gestor Filtros
        GestorFiltros gestor = new GestorFiltros(obj);
        
        // Instanciación de observadores
        Salpicadero salpicadero = new Salpicadero();
        Controles controles = new Controles();
        
        
        //Creamos ventanas
        Ventana ventanaSalpicadero = new Ventana(salpicadero, "Salpicadero");
        ventanaSalpicadero.setLocation(200, 200);
        Ventana ventanaControles = new Ventana(controles, "Controles");
        controles.setLocation(500, 400);
        
        obj.addObserver(salpicadero);
        obj.addObserver(controles);
          
    }
}
