package fecha;


public enum Dia {
	LUNES("Lunes"),
	MARTES("Martes"),
	MIERCOLES("Miercoles"),
	JUEVES("Jueves"),
	VIERNES("Viernes"),
	SABADO("Sabado"),
	DOMINGO("Domingo"),
	TODA_LA_SEMANA("Toda la semana");

	private String descripcion;
	

	private Dia(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public int getNdia(){
		return ordinal();
	}
	public static Dia getDia(int posicion) {//Index out of bound exception
		return values()[posicion];
	}

	public static String listar() {
		String s = "";
		for (Dia d : Dia.values()) {
			s+=d.ordinal()+".- "+d.getDescripcion()+"\n";
		}
		return s;
	}
}


