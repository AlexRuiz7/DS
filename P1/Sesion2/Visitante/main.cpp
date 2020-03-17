/* 
 * File:   main.cpp
 * Author: alex
 *
 * Created on 10 de marzo de 2020, 12:12
 */

#include <iostream>

#include "src/Bus.h"
#include "src/Disco.h"
#include "src/Tarjeta.h"
#include "src/VisitantePrecio.h"
#include "src/VisitantePrecioDetalle.h"
#include "src/Equipo.h"
#include "src/TipoCliente.h"

using namespace std;

int main(int argc, char** argv) {
    VisitantePrecio * vp;
    VisitantePrecioDetalle * vpd;
    Equipo * equipo;
    TipoCliente tc = estudiante; 
    
    /**/
    
    equipo = new Equipo( Bus("Bus", 5), Disco("Disco", 30), Tarjeta("Tarjeta", 100) );
    vp = new VisitantePrecio;
    vpd = new VisitantePrecioDetalle;
    vp->setCliente(tc);
    
    equipo->aceptar(*vp);
    equipo->aceptar(*vpd);
    
    cout << "  -  Precio total: " << vp->obtenerPrecioTotal() << "€ (-" << tc << "%)";
    cout << endl << endl;
    
    /**/
    
    equipo = new Equipo( Bus("Bus", 15), Disco("Disco", 60), Tarjeta("Tarjeta", 600) );
    vp = new VisitantePrecio;
    vpd = new VisitantePrecioDetalle;
    vp->setCliente(tc);
    
    equipo->aceptar(*vp);
    equipo->aceptar(*vpd);
    
    cout << "  -  Precio total: " << vp->obtenerPrecioTotal() << "€ (-" << tc << "%)";
    cout << endl << endl;
    
    /**/
    
    delete vp;
    delete vpd;
    delete equipo;
    
    return 0;
}

