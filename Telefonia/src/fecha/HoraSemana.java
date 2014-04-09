package fecha;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HoraSemana implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3442368762836814291L;
	Calendar calendar;
	SimpleDateFormat sdf;
	 private int dayOfWeek;
	 private int hour;
	 private int minute;
	 private int seconds;
	 
	
	

	public HoraSemana() {
		sdf = new SimpleDateFormat("kk:mm:ss");
		calendar = GregorianCalendar.getInstance();
		this.dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.seconds =calendar.get(Calendar.SECOND);

	}

	public String toString() {
		return Dia.getDia(dayOfWeek).getDescripcion()+" "+sdf.format(calendar.getTime());

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof HoraSemana)) {
			return false;
		}
		HoraSemana other = (HoraSemana) obj;
		if (other.toString().equals(this.toString())) {
			return true;
		}
		return false;
	}
	
	public void setHora(int hora, int min, int seg){
		calendar.set(0, 0, 0, hora, min, seg);
		this.hour = hora;
		this.minute = min;
		this.seconds = seg;
	}
	
	public void setDiaSemana(int diaSemana){
		calendar.set(Calendar.DAY_OF_WEEK, diaSemana);
		this.dayOfWeek = diaSemana;		
	}

	public int compareTo(HoraSemana f) {
		/**
		 * f1.compareTo(f2) si f1 es mayor : 1 si f1 es menor : -1
		 * 
		
		if (calendar.after(f.calendar))// this es mayor que f
			return 1;
		else if (calendar.equals(f.calendar))// this es igual que f
			return 0;
		else if (calendar.before(f.calendar))// this es menor que f
			return -1;
		return -1;
		*/
		if (dayOfWeek > f.getDiaSemana())
			return 1;
		else if (dayOfWeek < f.getDiaSemana())
			return -1;	
		else if (hour > f.getHora())
			return 1;
		else if (hour < f.getHora())
			return -1;
		else if (minute > f.getMinutos())
			return 1;
		else if (minute < f.getMinutos())
			return -1;
		else if (seconds > f.getSegundos())
			return 1;
		else if (seconds < f.getSegundos())
			return -1;
		else
			return 0;

	}
	
	
	public int compararSemana(Fecha f) {
	
		if (dayOfWeek == f.getDiaSemana() && hour == f.getHora()
				&& minute == f.getMinutos() && seconds == f.getSegundos())
			return 0;
		
		else if (dayOfWeek > f.getDiaSemana())
			return 1;
		else if (dayOfWeek < f.getDiaSemana())
			return -1;	
		else if (hour > f.getHora())
			return 1;
		else if (hour < f.getHora())
			return -1;
		else if (minute > f.getMinutos())
			return 1;
		else if (minute < f.getMinutos())
			return -1;
		else if (seconds > f.getSegundos())
			return 1;
		else if (seconds < f.getSegundos())
			return -1;
		else
			return 0;

	}

	public int getHora() {
		return hour;
	}

	public int getMinutos() {
		return minute;
	}

	public int getSegundos() {
		return seconds;
	}

	public int getDiaSemana() {
		return dayOfWeek;
	}

}
