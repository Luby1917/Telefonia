package fecha;


public enum FranjaHoraria {
	MANANA("Manana", 6,14),
	TARDE("Tarde",14,21),
	NOCHE("Noche", 21,6),
	TODO_EL_DIA("Todo el dia", 0,24);

	
	private String descripcion;
	private int horaInicio;
	private int horaFin;

	private FranjaHoraria(String descrpicion, int horaInicio, int horaFin) {
		this.descripcion = descrpicion;
		this.horaInicio=horaInicio;
		this.horaFin=horaFin;
	}
	
	public static FranjaHoraria getOpcion(int posicion) {
		return values()[posicion];
	}

	public static String listar() {
		String s = "";
		for (FranjaHoraria fh : FranjaHoraria.values()) {
			s+=fh.ordinal()+".  "+fh.getDescripcion()+ fh.getHoraInicio()+".- "+fh.getHoraFin()+"\n";
		}
		return s;
	}

	public int getHoraFin() {
		return horaFin;
	}
	public int getHoraInicio() {
		return horaInicio;
	}
	public String getDescripcion() {
		return descripcion;
	}
}


