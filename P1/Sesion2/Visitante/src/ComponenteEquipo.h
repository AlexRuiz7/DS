#ifndef COMPONENTEEQUIPO_H
#define COMPONENTEEQUIPO_H

class ComponenteEquipo {

protected:
	String nombre;
	double precio;

public:
	double getPrecio();

	String getNombre();

protected:
	ComponenteEquipo();

public:
	void aceptar(Visitante v);
};

#endif
