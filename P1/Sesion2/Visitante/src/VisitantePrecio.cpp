#include "VisitantePrecio.h"
#include "Bus.h"
#include "Disco.h"
#include "Tarjeta.h"

float VisitantePrecio::obtenerPrecioTotal() const {
    return total;
}

void VisitantePrecio::visitarBus(const Bus & bus) {
    total += bus.getPrecio();
}

void VisitantePrecio::visitarDisco(const Disco & disco) {
    total += disco.getPrecio();
}

void VisitantePrecio::visitarTarjeta(const Tarjeta & tarjeta) {
    total += tarjeta.getPrecio();
}