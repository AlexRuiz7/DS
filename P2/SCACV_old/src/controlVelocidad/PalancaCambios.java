package controlVelocidad;

/**
 *
 * @author pablorobles
 */
public final class PalancaCambios {

	private Estado estado;
	
	public PalancaCambios() {
            estado = Estado.PARADO;
	}
	
	public void setEstado(Estado estado) {
            this.estado = estado;
	}
	
	public Estado getEstado() {
            return estado;
	}
}

