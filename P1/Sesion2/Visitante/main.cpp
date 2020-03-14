
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
#include "src/Equipo.h"

using namespace std;

int main(int argc, char** argv) {
    Equipo equipo_1( Bus("Bus", 5), Disco("Disco", 30), Tarjeta("Tarjeta", 100) );

    VisitantePrecio vp;
    equipo_1.aceptar(vp);
    
    
    cout << "  -  Precio total: " << vp.obtenerPrecioTotal() << endl;
    
    return 0;
}

