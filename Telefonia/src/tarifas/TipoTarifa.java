package tarifas;

import fecha.Dia;
import fecha.FranjaHoraria;


public enum TipoTarifa {
	TARIFA_TARDE("Tarifa Tarde", 3, Dia.TODA_LA_SEMANA, FranjaHoraria.TARDE),
	TARIFA_DOMINGO("Tarifa Domingo", 0, Dia.DOMINGO, FranjaHoraria.TODO_EL_DIA );

	private Dia dia;
	private FranjaHoraria franjaHoraria;
	private String nombre;
	private int coste;

	private TipoTarifa(String nombre, int coste, Dia d, FranjaHoraria fh) {
		this.nombre = nombre;
		this.coste = coste;
		this.dia = d;
		this.franjaHoraria = fh;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getCoste() {
		return coste;
	}
	
	public Dia getDia(){
		return dia;
	}
	
	public FranjaHoraria getFranjaHoraria(){
		return franjaHoraria;
	}
	
	public static TipoTarifa getOpcion(int posicion) {
		return values()[posicion];
	}

	public static String listar() {
		String s = "";
		for (TipoTarifa t : TipoTarifa.values()) {
			s+=t.ordinal()+".- "+t.getNombre()+
					t.getCoste()+ "cent/min los "+
					t.getDia()+ " de " +
					t.getFranjaHoraria().getHoraInicio() +" a "+
					t.getFranjaHoraria().getHoraFin() + "\n";
		}
		return s;
	}
}


