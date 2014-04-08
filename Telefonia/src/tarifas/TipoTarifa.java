package tarifas;

import fecha.Dia;
import fecha.FranjaHoraria;


public enum TipoTarifa {
	TARIFA_BASICA("Tarifa Basica", 15, Dia.TODA_LA_SEMANA, FranjaHoraria.TODO_EL_DIA),
	TARIFA_TARDE("Tarifa Tarde", 3, Dia.TODA_LA_SEMANA, FranjaHoraria.TARDE),
	TARIFA_DOMINGO("Tarifa Domingo", 0, Dia.DOMINGO, FranjaHoraria.TODO_EL_DIA );
	private static final int numeroDeTarifasBasicas = 1;
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
		for (int i = numeroDeTarifasBasicas; i< TipoTarifa.values().length; i++) {//No lista las basicas
			TipoTarifa t= TipoTarifa.values()[i];
			s+=t.ordinal()+".- "+t.getNombre()+
					"\t"+t.getCoste()+ "cent/min los "+
					"\t"+t.getDia().getDescripcion()+ " de " +
					"\t"+t.getFranjaHoraria().getHoraInicio() +" a "+
					"\t"+t.getFranjaHoraria().getHoraFin() + "\n";
		}
		return s;
	}
}


