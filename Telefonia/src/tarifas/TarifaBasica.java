package tarifas;

import fecha.PeriodoSemana;

public class TarifaBasica extends Tarifa {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1814654976039740229L;

	public TarifaBasica() {
		super();
		super.setTarifa(null);

	}

	public TarifaBasica(String nombre, PeriodoSemana pS, int coste) {
		super(nombre, pS, coste);
		super.setTarifa(null);
	}
	
}










