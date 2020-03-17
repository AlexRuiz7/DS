package controlVelocidad;

import Filtros.Filtro;
import java.util.ArrayList;

/**
 *
 * @author pablorobles
 */

public class CadenaFiltros {
    private ArrayList<Filtro> filtros;
    private Objetivo objetivo;
    private int RPM;

    
    public CadenaFiltros(Objetivo objetivo) {
        this.objetivo = objetivo;
        filtros = new ArrayList();
        RPM = 0;
    }
    
        
    public void añadirFiltro(Filtro filtro) {
        filtros.add(filtro);
    }
    
    
    /**
     * Llama a cada uno de los filtros en la cadena, para que procesen y 
     * actualicen las revoluciones por minuto del motor (RPM).
     * 
     * Finalmente se propaga el nuevo estado al motor (objetivo).
     * 
     * @param estadoMotor 
     */
    public void ejecutar(EstadoMotor estadoMotor) {
        
        filtros.forEach((f) -> {
            RPM = f.ejecutar(RPM, estadoMotor);
        });
        
        objetivo.ejecutar(RPM, estadoMotor);
    }
    
}
