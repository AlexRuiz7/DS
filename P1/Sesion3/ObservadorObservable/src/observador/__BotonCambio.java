package observador;


import observable.Temperatura;

/**
 * 
 * @author alex
 */
public class __BotonCambio extends ObservadorTemperatura {

    
    /**
     * Constructor
     * @param t 
     */
    public __BotonCambio(Temperatura t) {
        super(t);
    }
    
    @Override
    public String toString() {
        return "BotonCambio: " + miTemperatura;
    }
    
}