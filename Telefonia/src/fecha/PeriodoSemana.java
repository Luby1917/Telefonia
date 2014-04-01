package fecha;

public class PeriodoSemana {
	private Fecha horaIni, horaFin;
	public PeriodoSemana(){
		this.horaIni = null;
		this.horaFin = null;
	}
	
	public PeriodoSemana(Fecha hIni, Fecha hFin){
		this.horaIni = hIni;
		this.horaFin = hFin;		
	}

	public Fecha getHoraIni() {
		return horaIni;
	}

	public Fecha getHoraFin() {
		return horaFin;
	}

	public void setHoraIni(Fecha horaIni) {
		this.horaIni = horaIni;
	}

	public void setHoraFin(Fecha horaFin) {
		this.horaFin = horaFin;
	}
	
	public boolean estaDentro(Fecha h){
		if (horaIni.compararSemana(h)==-1 && horaFin.compararSemana(h)==1)
			return true;
		return false;
		
	}
}