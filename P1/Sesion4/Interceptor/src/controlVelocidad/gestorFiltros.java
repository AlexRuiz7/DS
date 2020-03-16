package controlVelocidad;

/**
 *
 * @author pablorobles
 */
public class gestorFiltros {
    CadenaFiltros cadenaFiltros;
    
    public gestorFiltros(Objetivo ob){
        cadenaFiltros = new CadenaFiltros();
        cadenaFiltros.setObjetivo(ob);
    }
    
    public void setFiltro(Filtro f){
        cadenaFiltros.añadirFiltro(f);
    }
    
    public void peticionFiltro(String peticion){
        cadenaFiltros.ejecutar(peticion);
    }
}
