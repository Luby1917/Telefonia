package tarifas;

import llamadas.Llamada;
import fecha.PeriodoSemana;

public class TarifaAdicional extends Tarifa {
	Tarifa tarifa;
	int costeMinuto;

	/**
	 * TarifaBasica tarifa = new TarifaBasica(); tarifa = new
	 * TarifaAdicional(tarifa, nobmre, pS, coste);
	 * */

	public TarifaAdicional(Tarifa tarifa, String nombre, PeriodoSemana pS, int coste) {
		super(nombre, pS, coste);
		this.tarifa = tarifa;
	}

	public double calcularCoste(Llamada ll) {
		if(getPeriodoSemana().estaDentro(ll.getFecha())){
			
		}
		return 0;
	}

}
