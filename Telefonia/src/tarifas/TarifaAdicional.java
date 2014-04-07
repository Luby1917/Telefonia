package tarifas;


import fecha.PeriodoSemana;

public class TarifaAdicional extends Tarifa {
	Tarifa tarifa;
	
	public TarifaAdicional(Tarifa tarifa, String nombre, PeriodoSemana pS, int coste) {
		super(nombre, pS, coste);
		this.tarifa = tarifa;
	}
	

}
