#ifndef VISITANTEPRECIODETALLE_H
#define VISITANTEPRECIODETALLE_H

#include "VisitanteEquipo.h"

class VisitantePrecioDetalle : public VisitanteEquipo {

    
public:    
    void visitarBus(const Bus &);
    void visitarDisco(const Disco &);
    void visitarTarjeta(const Tarjeta &);    
};

#endif
