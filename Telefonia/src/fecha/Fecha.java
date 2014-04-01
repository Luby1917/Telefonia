package fecha;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Calendar calendar;
	SimpleDateFormat sdf;

	 private int year;
	 private int month;
	 private int dayOfWeek;
	 private int day;
	 private int hour;
	 private int minute;
	 private int seconds;
	 
	
	

	public Fecha() {
		sdf = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
		calendar = GregorianCalendar.getInstance();
		this.year = calendar.get(Calendar.YEAR);
		this.month = calendar.get(Calendar.MONTH);
		this.dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		this.day = calendar.get(Calendar.DAY_OF_MONTH);
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.seconds =calendar.get(Calendar.SECOND);

	}

	public String toString() {
		return sdf.format(calendar.getTime());

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Fecha)) {
			return false;
		}
		Fecha other = (Fecha) obj;
		if (other.toString().equals(this.toString())) {
			return true;
		}
		return false;
	}
	
	public void setFecha(int dia, int mes, int ano){
		calendar.set(ano, mes, dia);
		this.year = ano;
		this.month = mes;
		this.day = dia; 
	}
	
	public void setHora(int hora, int min, int seg){
		calendar.set(year, month, day, hora, min, seg);
		this.hour = hora;
		this.minute = min;
		this.seconds = seg;
	}
	
	public void setDiaSemana(int diaSemana){
		calendar.set(Calendar.DAY_OF_WEEK, diaSemana);
		this.dayOfWeek = diaSemana;		
	}

	public int compareTo(Fecha f) {
		if (calendar.after(f.calendar))// this es mayor que f
			return 1;
		if (calendar.equals(f.calendar))// this es igual que f
			return 0;
		if (calendar.before(f.calendar))// this es menor que f
			return -1;
		return -1;
	}
	
	public int compararSemana(Fecha hs) {
		/**
		 * f1.compareTo(f2) si f1 es mayor : 1 si f1 es menor : -1
		 * 
		 */
		if (dayOfWeek == hs.getDiaSemana() && hour == hs.getHora()
				&& minute == hs.getMinutos() && seconds == hs.getSegundos())
			return 0;
		
		else if (dayOfWeek > hs.getDiaSemana())
			return 1;
		else if (dayOfWeek < hs.getDiaSemana())
			return -1;	
		else if (hour > hs.getHora())
			return 1;
		else if (hour < hs.getHora())
			return -1;
		else if (minute > hs.getMinutos())
			return 1;
		else if (minute < hs.getMinutos())
			return -1;
		else if (seconds > hs.getSegundos())
			return 1;
		else if (seconds < hs.getSegundos())
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
		return day;
	}

	public int getDiaSemana() {
		return dayOfWeek;
	}

}
