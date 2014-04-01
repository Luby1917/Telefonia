package tarifas;

import fecha.HoraSemana;
import fecha.PeriodoSemana;

public abstract class Tarifa {
	private int costeMinuto;
	private PeriodoSemana periodoSemana;
	private String nombre;
	
	public Tarifa(){
		
	}
	
	public Tarifa(TipoTarifa tipoTarifa){
		this.setCoste(tipoTarifa.getCoste());
		
		int n = tipoTarifa.getDia().getNdia();
		if (n > 7)
		
		
		HoraSemana hIni = new HoraSemana();
		HoraSemana hFin = new HoraSemana();
		this.setPeriodoSemana(new PeriodoSemana(hIni, hFin));
		this.setNombre(tipoTarifa.getNombre());
	}

	
	public String toString(){
		return "Tarifa"+ getNombre()+
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
