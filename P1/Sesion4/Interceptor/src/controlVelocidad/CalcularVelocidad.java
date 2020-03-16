package controlVelocidad;

/**
 *
 * @author pablorobles
 */
public class CalcularVelocidad implements Filtro{
    
    protected double incrementoVelocidad = 0;
    protected final int MAX_VELOCIDAD = 500;

    public double getIncrementoVelocidad() {
        return incrementoVelocidad;
    }

    public void setIncrementoVelocidad(double incrementoVelocidad) {
        this.incrementoVelocidad = incrementoVelocidad;
    }
     
    @Override
    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        
        switch (estadoMotor) {
            case FRENANDO:
                this.setIncrementoVelocidad(-100);
                break;
            case ACELERANDO:
                this.setIncrementoVelocidad(100);
                break;
            default:
                this.setIncrementoVelocidad(0);
                break;
        }
        
        revoluciones = revoluciones + this.getIncrementoVelocidad();
        
        return revoluciones;
    }
}
