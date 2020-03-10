package observador;


import observable.Temperatura;


/**
 * 
 * @author alex
 */
public class __PantallaTemperatura extends ObservadorTemperatura {

    /**
     * Constructor
     * @param t 
     */
    public __PantallaTemperatura(Temperatura t) {
        super(t);
    }

    @Override
    public String toString() {
        return "PantallaTemperatura: " + miTemperatura;
    }

}