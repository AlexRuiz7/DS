package observador;


import observable.Temperatura;


/**
 * 
 * @author alex
 */
public class PantallaTemperatura extends ObservadorTemperatura {

    /**
     * Constructor
     * @param t 
     */
    public PantallaTemperatura(Temperatura t) {
        super(t);
    }

    @Override
    public String toString() {
        return "PantallaTemperatura: " + miTemperatura;
    }

}