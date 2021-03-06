package tarifas;

import java.io.Serializable;

import llamadas.Llamada;
import fecha.PeriodoSemana;

public abstract class Tarifa   implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8600543543180760546L;


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
		if (tarifa != null)
			return "" + getNombre() +
						"\nHorario "	+ getPeriodoSemana().toString() + 
						"\nCoste " + getCoste() +
						"\n\n"+ tarifa.toString() + "\n";
		else
			return "" + getNombre() +
					"\nHorario "	+ getPeriodoSemana().toString() + 
					"\nCoste " + getCoste() +
					"\n";
			
	}
	
	public double calcularCoste(Llamada ll) {// llamada a analizar y

		
		if (getPeriodoSemana().estaDentro(ll.getFecha())) {// Si la llamada esta dentro de la franja horaria
			if (this.getCoste() == 0) {// si el precio es 0, no puede ser inferior, no seguimos buscando
				System.out.println("Calcular Coste: "+this.getClass().getName()+"--"+this.getCoste());
				
				ll.setTarifa(this);
				ll.setCoste(0);
				return 0;
			} else {
				if (tarifa != null) {// mientras sea tarifa adicional
					if (costeMinuto < tarifa.calcularCoste(ll)) {// Si el precio de esta tarifa es el minimo
						System.out.println("Calcular Coste: "+this.getClass().getName()+"--"+this.getCoste());
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

	public void setNombre(String n) {
		this.nombre = n;
	}

	public PeriodoSemana getPeriodoSemana() {
		return periodoSemana;
	}

	public void setPeriodoSemana(PeriodoSemana pSemana) {
		this.periodoSemana = pSemana;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa t) {
		this.tarifa = t;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + costeMinuto;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result
				+ ((periodoSemana == null) ? 0 : periodoSemana.hashCode());
		result = prime * result + ((tarifa == null) ? 0 : tarifa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarifa other = (Tarifa) obj;
		if (costeMinuto != other.costeMinuto)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (periodoSemana == null) {
			if (other.periodoSemana != null)
				return false;
		} else if (!periodoSemana.equals(other.periodoSemana))
			return false;
		if (tarifa == null) {
			if (other.tarifa != null)
				return false;
		} else if (!tarifa.equals(other.tarifa))
			return false;
		return true;
	}
	
	
}
