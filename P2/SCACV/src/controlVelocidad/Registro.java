package controlVelocidad;

/**
 *
 * @author pablorobles
 */
public class Registro {
    private int velocidadConstante;
    private Eje eje;

    public Registro(Eje eje) {
            velocidadConstante = 0;
            this.eje = eje;
    }



    public void registrarVelocidad() { 
            velocidadConstante = eje.getVelocidad();
    }

    public int getVelocidadConstante() {
            return velocidadConstante;
    }
}
