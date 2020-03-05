
import observable.Temperatura;
import observador.BotonCambio;
import observador.GraficaTemperatura;
import observador.PantallaTemperatura;


/**
 *
 * @author alex
 */
public class test {

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
        
        // Añadir los observadores al observable
        t.addObserver(p);
        t.addObserver(g);
        t.addObserver(b);
        
        // Lanzar la hebra del observable
        t.run();
    }
    
}
