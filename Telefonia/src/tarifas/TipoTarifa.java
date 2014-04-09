package tarifas;

import fecha.Dia;
import fecha.FranjaHoraria;

public interface TipoTarifa {

	String getNombre();

	int getCoste();

	Dia getDia();

	FranjaHoraria getFranjaHoraria();

	TipoTarifa getOpcion(int posicion);

	//String listar();

}
