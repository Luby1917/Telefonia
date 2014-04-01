package fecha;

public class PeriodoSemana {
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

	public void setHoraIni(HoraSemana horaIni) {
		this.horaIni = horaIni;
	}

	public void setHoraFin(HoraSemana horaFin) {
		this.horaFin = horaFin;
	}
	
	public boolean estaDentro(Fecha h){
		if (horaIni.compararSemana(h)==-1 && horaFin.compararSemana(h)==1)
			return true;
		return false;
		
	}
}