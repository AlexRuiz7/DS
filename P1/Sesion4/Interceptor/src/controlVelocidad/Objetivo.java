package controlVelocidad;

import java.util.Observable;

/**
 *
 * @author pablorobles
 */
public class Objetivo extends Observable {
    
    private double velocidad, distancia_recorrida; 
    private int RPM;
    private EstadoMotor estado;
    private final float R = 0.15f;

    
    public Objetivo() {
        velocidad = distancia_recorrida = 0;
        RPM = 0;
    }

    
    void ejecutar(int revoluciones, EstadoMotor estadoMotor) {
        estado = estadoMotor;       // Actualizar estado del motor
        RPM = revoluciones;         // Actualizar Velocidad Angular
        setVelocidadLineal();       // Calcular Velocidad Lineal
        setDistanciaRecorrida();    // Calcular Distancia recorrida
        
        System.out.println("\nPeticion: " + estado.name() );
        System.out.println("RPM: " + RPM );
        System.out.println("Vel.: " + velocidad );
        System.out.println("Distancia: " + distancia_recorrida );
        
        // Notificar observadores (GUI) para actualicen su estados
        this.setChanged();
        this.notifyObservers();
    }
    
    /**************************/
    /******* SETTERS **********/
    /**************************/
        
    private void setVelocidadLineal() {
        velocidad = 2*Math.PI*R * RPM * (60*0.001);
    }
    
    private void setDistanciaRecorrida() {
        distancia_recorrida += velocidad * 0.06 /* x t */;
    }
    
    /**************************/
    /******* GETTERS **********/
    /**************************/
    
    /**
     * Al ser un objeto Observable, los observadores (las clases que implementan 
     * la interfaz visual en nuestro caso) puede obtener este objeto en el
     * método update(). Teniendo la referencia a este objeto pueden llamar a los
     * getters para obtener la información que necesiten y actualizar su estado.
     */
    
    public int getRPM() {
        return RPM;
    }
    
    public EstadoMotor getEstadoMotor() {
        return estado;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getDistanciaRecorrida() {
        return distancia_recorrida;
    }
   
}
