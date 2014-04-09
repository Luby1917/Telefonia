package fecha;

import java.io.Serializable;


public class Periodo  implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6353730000267295783L;
	private Fecha fechaInicio;
	private Fecha fechaFin;

	public Periodo() {
		this.setFechaInicio(new Fecha());
		this.setFechaFin(new Fecha());
	}

	public Periodo(Fecha inicio, Fecha fin) {
		this.setFechaFin(fin);
		this.setFechaInicio(inicio);
	}

	public Fecha getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Fecha fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Fecha getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Fecha fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public String toString(){
		return getFechaInicio().toString() +" - "+ getFechaFin();
	}
	
	public boolean estaDentro(Fecha f){
		if (fechaInicio.compareTo(f)==-1 && fechaFin.compareTo(f)==1)
			return true;
		return false;
	}

}
