package controlVelocidad;

<<<<<<< HEAD
import GUI.Controles;
import GUI.Salpicadero;
import GUI.Ventana;
import java.io.IOException;
import java.util.Observer;
=======
import Filtros.FiltroCalcularRPM;
import Filtros.FiltroRozamiento;
import GUI.Salpicadero;
import GUI.Ventana;
import GUI.Controles;
import java.io.IOException;
>>>>>>> origin/master

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
<<<<<<< HEAD
        
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
          
=======

        Objetivo motor = new Objetivo();
        GestorFiltros gestor = new GestorFiltros(motor);
        Cliente controlador = new Cliente(gestor);
        
        /****/
        
        FiltroCalcularRPM filtro_velocidad = new FiltroCalcularRPM();
        FiltroRozamiento filtro_rozamiento = new FiltroRozamiento();
        gestor.setFiltro(filtro_velocidad);
        gestor.setFiltro(filtro_rozamiento);
        
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
>>>>>>> origin/master
    }
}
