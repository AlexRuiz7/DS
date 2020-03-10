#ifndef EQUIPO_H
#define EQUIPO_H

class Equipo {

private:
	std::list componentes;

public:
	Equipo(std::list componentes);

	void aceptar(Visitante v);
};

#endif
