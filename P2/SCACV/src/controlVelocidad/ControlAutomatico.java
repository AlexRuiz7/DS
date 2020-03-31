package controlVelocidad;

/**
 *
 * @author pablorobles
 */
public class ControlAutomatico {
	
    private Acelerador acelerador;
    private Freno freno;
    private Registro registro;
    private Eje eje;

    public ControlAutomatico(Acelerador acelerador, Freno freno, Registro registro, Eje eje) {
        this.acelerador = acelerador;
        this.freno = freno;
        this.registro = registro;
        this.eje = eje;
    }

    public void mantenerVelocidad() {
        if(eje.getVelocidad() > registro.getVelocidadConstante())
            freno.frenar("brusco");
        else if (eje.getVelocidad() < registro.getVelocidadConstante())
            acelerador.acelerar();
    }
}
