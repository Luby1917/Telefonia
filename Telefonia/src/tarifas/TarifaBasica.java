package tarifas;

import fecha.PeriodoSemana;

public class TarifaBasica extends Tarifa {

	public TarifaBasica() {
		super();

	}

	public TarifaBasica(String nombre, PeriodoSemana pS, int coste) {
		super(nombre, pS, coste);
	}
	
}
