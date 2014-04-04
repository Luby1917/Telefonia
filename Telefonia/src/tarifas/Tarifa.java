package tarifas;

import fecha.HoraSemana;
import fecha.PeriodoSemana;

public abstract class Tarifa {
	private int costeMinuto;
	private PeriodoSemana periodoSemana;
	private String nombre;

	public Tarifa() {

	}

	public Tarifa(TipoTarifa tipoTarifa) {
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
		
		this.setCoste(tipoTarifa.getCoste());
		this.setPeriodoSemana(new PeriodoSemana(hIni, hFin));
		this.setNombre(tipoTarifa.getNombre());
	}

	public String toString() {
		return "Tarifa" + getNombre() +
				"\nHorario"	+ getPeriodoSemana().toString() + 
				"\nCoste" + getCoste();
	}

	public int getCoste() {
		return costeMinuto;
	}

	public void setCoste(int coste) {
		this.costeMinuto = coste;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public PeriodoSemana getPeriodoSemana() {
		return periodoSemana;
	}

	public void setPeriodoSemana(PeriodoSemana periodoSemana) {
		this.periodoSemana = periodoSemana;
	}

}
