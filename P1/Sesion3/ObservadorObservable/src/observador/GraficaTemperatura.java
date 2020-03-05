package observador;


import observable.Temperatura;


/**
 * 
 * @author alex
 */
public class GraficaTemperatura extends ObservadorTemperatura {

    /**
     * Constructor
     * @param t 
     */
    public GraficaTemperatura(Temperatura t) {
        super(t);
    }

    
    @Override
    public String toString() {
        return "GraficaTemperatura: " + miTemperatura;
    }
}