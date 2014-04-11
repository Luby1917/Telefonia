package fecha;


public enum Dia {
	DOMINGO("Domingo"),
	LUNES("Lunes"),
	MARTES("Martes"),
	MIERCOLES("Miercoles"),
	JUEVES("Jueves"),
	VIERNES("Viernes"),
	SABADO("Sabado"),
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
		if (posicion<0)
			posicion*=-1;
		//else if (posicion>values().length)
			//posicion = (posicion%values().length);
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


