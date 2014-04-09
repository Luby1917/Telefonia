package tarifas;


import fecha.PeriodoSemana;

public class TarifaAdicional extends Tarifa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2236572387077236745L;
	Tarifa tarifa;
	
	public TarifaAdicional(Tarifa tarifa, String nombre, PeriodoSemana pS, int coste) {
		super(nombre, pS, coste);
		this.tarifa = tarifa;
	}
	

}
