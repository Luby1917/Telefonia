package menu;

public enum OpcionesLlamada implements Opciones{


	ATRAS("Atras"),
	NUEVA("Nueva llamada"),
	BUSCAR("Buscar una llamada"),
	LISTAR("Listar llamadas "),
	LISTAR_FECHA("Listar facturas que llamadas realizadas entre dos fechas");
	
	String descripcion;
	
	private OpcionesLlamada(String descripcion){
		this.descripcion = descripcion;
	}
	@Override
	public OpcionesLlamada getOpcion(int posicion) {
		return values()[posicion];
	}
	@Override
	public String getDescripcion(){
		return descripcion;
	}
	@Override
	public String listar() {
		String s = "";
		for (int i = 0; i< OpcionesLlamada.values().length; i++) {
			OpcionesLlamada op= OpcionesLlamada.values()[i];
			s+=op.ordinal()+".- "+op.getDescripcion()+"\n";
		}
		return s;
	}
	@Override
	public int size(){
		return values().length;
	}
	

}