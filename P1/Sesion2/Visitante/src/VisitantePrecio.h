#ifndef VISITANTEPRECIO_H
#define VISITANTEPRECIO_H

#include "VisitanteEquipo.h"

class VisitantePrecio : public VisitanteEquipo {
    

public:
    float obtenerPrecioTotal() const;

    void visitarBus(const Bus &);
    void visitarDisco(const Disco &);
    void visitarTarjeta(const Tarjeta &);
    
private:
    float total; 
};

#endif
