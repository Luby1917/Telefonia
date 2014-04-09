package tarifas;

import fecha.Dia;
import fecha.FranjaHoraria;


public enum TarifasExtraFranjaHoraria implements TipoTarifa {
	TARIFA_MANANA("Tarifa Mañana", 3, Dia.TODA_LA_SEMANA, FranjaHoraria.MANANA),
	TARIFA_TARDE("Tarifa Tarde", 3, Dia.TODA_LA_SEMANA, FranjaHoraria.TARDE),
	TARIFA_NOCHE("Tarifa Noche", 3, Dia.TODA_LA_SEMANA, FranjaHoraria.NOCHE);
		
	private Dia dia;
	private FranjaHoraria franjaHoraria;
	private String nombre;
	private int coste;

	private TarifasExtraFranjaHoraria(String nombre, int coste, Dia d, FranjaHoraria fh) {
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
	
	public  TarifasExtraFranjaHoraria getOpcion(int posicion) {
		return values()[posicion];
	}

	public static  String listar() {
		String s = "";
		for (int i = 0; i< TarifasExtraFranjaHoraria.values().length; i++) {
			TarifasExtraFranjaHoraria t= TarifasExtraFranjaHoraria.values()[i];
			s+=t.ordinal()+".- "+t.getNombre()+
					"\t"+t.getCoste()+ "cent/min los "+
					"\t"+t.getDia().getDescripcion()+ " de " +
					"\t"+t.getFranjaHoraria().getHoraInicio() +" a "+
					"\t"+t.getFranjaHoraria().getHoraFin() + "\n";
		}
		return s;
	}
}


