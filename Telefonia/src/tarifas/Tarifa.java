package tarifas;

import llamadas.Llamada;
import fecha.PeriodoSemana;

public abstract class Tarifa {
	public static int PRECIO_BASICO = 15;
	
	
	private Tarifa tarifa;
	private int costeMinuto;
	private PeriodoSemana periodoSemana;
	private String nombre;

	public Tarifa() {

	}

	public Tarifa(String nombre, PeriodoSemana pS, int coste) {
		this.setCoste(coste);
		this.setPeriodoSemana(pS);
		this.setNombre(nombre);
	}

	public String toString() {
			return "Tarifa" + getNombre() +
						"\nHorario"	+ getPeriodoSemana().toString() + 
						"\nCoste" + getCoste();
	}
	
	public double calcularCoste(Llamada ll) {// llamada a analizar y
		if (getPeriodoSemana().estaDentro(ll.getFecha())) {// Si la llamada esta dentro de la franja horaria
			if (this.getCoste() == 0) {// si el precio es 0, no puede ser inferior, no seguimos buscando
				ll.setTarifa(this);
				ll.setCoste(0);
				return 0;
			} else {
				if (tarifa != null) {// mientras sea tarifa adicional
					if (costeMinuto < tarifa.calcularCoste(ll)) {// Si el precio de esta tarifa es el minimo
						ll.setCoste(costeMinuto);
						ll.setTarifa(this);
						return costeMinuto;
					}
				}
			}
		}
		return PRECIO_BASICO;
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

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

}
