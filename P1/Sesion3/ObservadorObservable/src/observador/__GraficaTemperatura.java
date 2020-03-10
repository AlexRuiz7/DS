package observador;


import observable.Temperatura;


/**
 * 
 * @author alex
 */
public class __GraficaTemperatura extends ObservadorTemperatura {

    /**
     * Constructor
     * @param t 
     */
    public __GraficaTemperatura(Temperatura t) {
        super(t);
    }

    
    @Override
    public String toString() {
        return "GraficaTemperatura: " + miTemperatura;
    }
}