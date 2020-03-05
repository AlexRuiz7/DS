package observador;


import observable.Temperatura;

/**
 * 
 * @author alex
 */
public class BotonCambio extends ObservadorTemperatura {

    
    /**
     * Constructor
     * @param t 
     */
    public BotonCambio(Temperatura t) {
        super(t);
    }
    
    @Override
    public String toString() {
        return "BotonCambio: " + miTemperatura;
    }
    
}