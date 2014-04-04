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

	public TarifaAdicional(Tarifa tarifa, TipoTarifa tipoTarifa) {
		super(tipoTarifa);
		this.tarifa = tarifa;
	}

	public double calcularCoste(Llamada ll) {
		if(getPeriodoSemana().estaDentro(ll.getFecha())){
			
		}else{
			
		}
		
		return 0;
	}

}
