package controlVelocidad;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author pablorobles
 */
public class CadenaFiltros {
    private ArrayList<Filtro> filtros = new ArrayList<Filtro>();
    private Objetivo objetivo;
    
    public void añadirFiltro(Filtro filtro){
        filtros.add(filtro);
    }
    
    public void ejecutar(String peticion){
        for(Filtro f : filtros){
            f.ejecutar(0, EstadoMotor.APAGADO)
        }
        objetivo.ejecutar();
    }
    
    public void setObjetivo(Objetivo ob){
        objetivo = ob;
    }
}
