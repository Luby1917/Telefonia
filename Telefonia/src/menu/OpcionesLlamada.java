package menu;

public enum OpcionesLlamada implements Opciones{


	NUEVA("Nueva llamada", "NUEVA"),
	BUSCAR("Buscar una llamada", "BUSCAR"),
	LISTAR("Listar llamadas","LISTAR"),
	LISTAR_FECHA("Listar facturas que llamadas realizadas entre dos fechas","LISTAR_FECHA");
	
	String descripcion;
	String action;
	
	private OpcionesLlamada(String descripcion, String action){
		this.descripcion = descripcion;
		this.action = action;
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
	@Override
	public String getAction() {
		// TODO Auto-generated method stub
		return null;
	}
	

}