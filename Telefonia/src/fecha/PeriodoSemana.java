package fecha;

import java.io.Serializable;

public class PeriodoSemana  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1386303151887076509L;
	private HoraSemana horaIni, horaFin;
	public PeriodoSemana(){
		this.horaIni = null;
		this.horaFin = null;
	}
	
	public PeriodoSemana(HoraSemana hIni, HoraSemana hFin){
		this.horaIni = hIni;
		this.horaFin = hFin;		
	}

	public HoraSemana getHoraIni() {
		return horaIni;
	}

	public HoraSemana getHoraFin() {
		return horaFin;
	}

	public void setHoraIni(HoraSemana hIni) {
		this.horaIni = hIni;
	}

	public void setHoraFin(HoraSemana hFin) {
		this.horaFin = hFin;
	}
	
	public boolean estaDentro(Fecha h){
		if (horaIni.compararSemana(h)==-1 && horaFin.compararSemana(h)==1)
			return true;
		return false;
		
	}
	
	public String toString(){
		return horaIni.toString()+" a "+ horaFin.toString()+"";
	}
}