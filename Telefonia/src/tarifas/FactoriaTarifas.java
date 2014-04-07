package tarifas;

import fecha.HoraSemana;
import fecha.PeriodoSemana;



public class FactoriaTarifas {
	Tarifa tarifa;
	public FactoriaTarifas() {
		tarifa = crearTarifa(TipoTarifa.TARIFA_BASICA, null);
	
 

		}
	public Tarifa getTarifa(){
		return tarifa;
	}
	
	public Tarifa anadirTarifaAdicional(TipoTarifa tipoTarifa) {
			tarifa =  crearTarifa(tipoTarifa, tarifa);
			return tarifa;
		}
	
	private Tarifa crearTarifa(TipoTarifa tipoTarifa, Tarifa tarifa){//TODO Revisar
		
		int nDia = tipoTarifa.getDia().getNdia();
		int horaInicio = tipoTarifa.getFranjaHoraria().getHoraInicio();
		int horaFinal = tipoTarifa.getFranjaHoraria().getHoraFin();
		HoraSemana hIni = new HoraSemana();
		HoraSemana hFin = new HoraSemana();
		if (nDia > 7) {
			hIni.setDiaSemana(0);
			hIni.setHora(horaInicio, 0, 0);
			hFin.setDiaSemana(6);
			hFin.setHora(horaFinal, 0, 0);
		} else {
			hIni.setDiaSemana(nDia);
			hIni.setHora(horaInicio, 0, 0);
			hFin.setDiaSemana(nDia);
			hFin.setHora(horaFinal, 0, 0);
		}
		Tarifa tarifaAdicional = new TarifaAdicional(tarifa, tipoTarifa.getNombre(),new PeriodoSemana(hIni, hFin),tipoTarifa.getCoste());

		return tarifaAdicional;
		
	}

}
