package Filtros;

import controlVelocidad.EstadoMotor;

/**
 *
 * @author alex
 */

public class FiltroRozamiento implements Filtro {

    @Override
    public int ejecutar(int revoluciones, EstadoMotor estadoMotor) {
<<<<<<< HEAD
        
        if(estadoMotor == EstadoMotor.APAGADO)
            return 0;
        else
            return Math.max(0, revoluciones - 10);
=======
        return Math.max(0, revoluciones - 10);
>>>>>>> origin/master
    }
    
}
