package tarifas;

import fecha.HoraSemana;
import fecha.PeriodoSemana;

public class FactoriaTarifas {
	Tarifa tarifa;
	

	public FactoriaTarifas() {
	}

	public Tarifa crearTarifa() {
		tarifa = crearTarifa(TarifasBasicas.TARIFA_BASICA, null);
		return tarifa;
	}

	public Tarifa anadirTarifaAdicional(TipoTarifa tipoTarifa) {
		tarifa = crearTarifa(tipoTarifa, tarifa);
		return tarifa;
	}

	private Tarifa crearTarifa(TipoTarifa tipoTarifa, Tarifa t) {// TODO Revisar

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
		Tarifa tarifaAdicional;
		if (t == null)
			tarifaAdicional = new TarifaBasica(
					tipoTarifa.getNombre(),	new PeriodoSemana(hIni, hFin),
					tipoTarifa.getCoste());
		else
			tarifaAdicional = new TarifaAdicional(t,
					tipoTarifa.getNombre(), new PeriodoSemana(hIni, hFin),
					tipoTarifa.getCoste());

		return tarifaAdicional;

	}

}
