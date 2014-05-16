package menu;

public enum OpcionesFactura  implements Opciones{
	
	EMITIR("Emitir una factura","EMITIR"),
	BUSCAR("Buscar una factura","BUSCAR"),
	LISTAR("Listar facturas", "LISTAR"),
	LISTAR_FECHA("Listar facturas que fueron emitidas entre dos fechas","LISTAR_FECHA");
	
	String descripcion;
	String action;
	
	private OpcionesFactura(String descripcion, String action){
		this.descripcion = descripcion;
		this.action = action;
	}
	@Override
	public OpcionesFactura getOpcion(int posicion) {
		return values()[posicion];
	}
	@Override
	public String getDescripcion(){
		return descripcion;
	}
	@Override
	public String listar() {
		String s = "";
		for (int i = 0; i< OpcionesFactura.values().length; i++) {
			OpcionesFactura op= OpcionesFactura.values()[i];
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
		return action;
	}
}

