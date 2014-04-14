package tarifas;

import fecha.Dia;
import fecha.FranjaHoraria;


public enum TarifasExtraDiaGratis implements TipoTarifa  {
	TARIFA_SABADO("Tarifa Sabado", 0, Dia.SABADO, FranjaHoraria.TODO_EL_DIA ),
	TARIFA_DOMINGO("Tarifa Domingo", 0, Dia.DOMINGO, FranjaHoraria.TODO_EL_DIA );

	private Dia dia;
	private FranjaHoraria franjaHoraria;
	private String nombre;
	private int coste;

	private TarifasExtraDiaGratis(String nombre, int coste, Dia d, FranjaHoraria fh) {
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
	
	public TarifasExtraDiaGratis getOpcion(int posicion) {
		return values()[posicion];
	}

	public static  String listar() {
		String s = "";
		for (int i = 0; i< TarifasExtraDiaGratis.values().length; i++) {
			TarifasExtraDiaGratis t= TarifasExtraDiaGratis.values()[i];
			s+=t.ordinal()+".- "+t.getNombre()+
					"\t"+t.getCoste()+ "cent/min los "+
					"\t"+t.getDia().getDescripcion()+ " de " +
					"\t"+t.getFranjaHoraria().getHoraInicio() +" a "+
					"\t"+t.getFranjaHoraria().getHoraFin() + "\n";
		}
		return s;
	}
}


