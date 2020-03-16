package controlVelocidad;

/**
 *
 * @author pablorobles
 */

public interface Filtro {
    public double ejecutar(double revoluciones, EstadoMotor estadoMotor);
}
