package tarifas;

import fecha.PeriodoSemana;

public abstract class Tarifa {
	private int costeMinuto;
	private PeriodoSemana periodoSemana;
	private String nombre;
	
	public Tarifa(){
		
	}
	
	public Tarifa(String nombre, PeriodoSemana pS,  int coste){
		this.setCoste(coste);
		this.setPeriodoSemana(pS);
		this.setNombre(nombre);
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
